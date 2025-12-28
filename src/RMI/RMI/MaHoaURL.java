package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.net.URLEncoder;
import RMI.CharacterService;

public class MaHoaURL {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "KkihaRAB");
        System.out.println(s);
        String ans = URLEncoder.encode(s, "UTF-8");
        System.out.println(ans);
        sv.submitCharacter("B22DCCN634", "KkihaRAB", ans);
    }
}
/*
 * ##### BÀI 31. [Character] MÃ HOÁ URL
 * [Mã câu hỏi (qCode): KkihaRAB]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa CharacterService: requestCharacter, submitCharacter.
 * Interface CharacterService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server.
 * b. Thực hiện thao tác mã hóa URL (URL Encoding) cho chuỗi đầu vào.
 * Mã hóa URL chuyển đổi các ký tự đặc biệt thành định dạng URL an toàn bằng
 * cách thay thế các ký tự đó bằng ký hiệu phần trăm (%) và mã ASCII.
 * Ví dụ: "Hello World!" → "Hello%20World%21"
 * c. Triệu gọi phương thức submitCharacter để gửi chuỗi đã được mã hóa trở lại
 * server.
 * d. Kết thúc chương trình client.
 */
