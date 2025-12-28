package RMI.RMI;

import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.CharacterService;

public class MaHoaVigen {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "Y7YMXHs4");
        System.out.println(s);
        int idx = s.indexOf(";");
        String keyW = s.substring(0, idx), text = s.substring(idx + 1), ans = "";
        for (int i = 0; i < text.length(); i++) {
            char x = text.charAt(i), y = keyW.charAt(i % keyW.length());
            char z;
            if (Character.isUpperCase(x))
                z = (char) ((x - 'A' + y - 'A') % 26 + 'A');
            else
                z = (char) ((x - 'a' + y - 'a') % 26 + 'a');
            ans += z;
        }
        System.out.println(ans);
        sv.submitCharacter("B22DCCN634", "Y7YMXHs4", ans);
    }
}
/*
 * ##### [Character] MÃ HOÁ VIGENÈRE
 * [Mã câu hỏi (qCode): Y7YMXHs4]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa CharacterService: requestCharacter, submitCharacter.
 * Interface CharacterService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi từ server với định
 * dạng "Khóa;Văn bản cần mã hóa".
 * b. Thực hiện mã hóa Vigenère cho văn bản với khóa đã cho.
 * Mã hóa Vigenère dịch từng ký tự theo ký tự tương ứng trong khóa (khóa lặp lại
 * theo chu kỳ).
 * Ví dụ: Khóa "KEY", Văn bản "HELLO" → Mã hóa thành "RIJVS"
 * c. Triệu gọi phương thức submitCharacter để gửi văn bản đã mã hóa trở lại
 * server.
 * d. Kết thúc chương trình client.
 */
