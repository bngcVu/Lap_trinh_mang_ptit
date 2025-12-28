package RMI.RMI;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

public class MaHoaBase64 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "psd4Jmnt");
        System.out.println(s);
        byte[] tmp = Base64.getEncoder().encode(s.getBytes());
        String ans = new String(tmp);
        System.out.println(ans);
        sv.submitCharacter("B22DCCN634", "psd4Jmnt", ans);
    }
}
/*
 * ##### BÀI 23. [Character] MÃ HOÁ Base64
 * [Mã câu hỏi (qCode): psd4Jmnt]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa CharacterService: requestCharacter, submitCharacter.
 * Interface CharacterService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server.
 * b. Thực hiện thao tác mã hóa Base64 cho chuỗi đầu vào. Mã hóa Base64 chuyển
 * đổi chuỗi nhị phân thành định dạng văn bản ASCII.
 * Ví dụ: Chuỗi "HELLO" → Chuỗi mã hóa Base64 là: "SEVMTE8="
 * c. Triệu gọi phương thức submitCharacter để gửi chuỗi đã được mã hóa trở lại
 * server.
 * d. Kết thúc chương trình client.
 */
