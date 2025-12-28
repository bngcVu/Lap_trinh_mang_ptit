package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;

public class MaHoaCaesar1 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "j4rStb2a");
        System.out.println(s);
        String ans = "";
        int dich = s.length() % 7;
        for (char x : s.toCharArray()) {
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base - dich + 26) % 26 + base);
            ans += x;
        }
        System.out.println(ans);
        sv.submitCharacter("B22DCCN634", "j4rStb2a", ans);
    }
}
/*
 * ##### BÀI 18. [Character] MÃ HOÁ CAESAR - 1
 * [Mã câu hỏi (qCode): j4rStb2a]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa CharacterService: requestCharacter, submitCharacter.
 * Interface CharacterService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server.
 * b. Thực hiện thao tác giải mã Caesar (mã hóa chuỗi bằng cách dịch từng ký tự
 * đi một số lượng vị trí nhất định).
 * Biết rằng giá trị dịch đúng bằng kích thước của chuỗi chia lấy dư cho 7.
 * c. Triệu gọi phương thức submitCharacter để gửi chuỗi đã được giải mã trở lại
 * server.
 * d. Kết thúc chương trình client.
 */
