package RMI.RMI;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChuyenDoiThapPhanLaMa {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "ADu6zRYE");
        System.out.println(s);
        String rm = "";
        int dec = Integer.parseInt(s);
        int[] tp = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] lm = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        for (int i = 0; i < tp.length; i++) {
            while (dec >= tp[i]) {
                rm += lm[i];
                dec -= tp[i];
            }
        }
        System.out.println(rm);
        sv.submitCharacter("B22DCCN634", "ADu6zRYE", rm);
    }
}
/*
 * ##### BÀI 25. [Character] CHUYỂN ĐỔI THẬP PHÂN – LA MÃ
 * [Mã câu hỏi (qCode): ADu6zRYE]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa CharacterService: requestCharacter, submitCharacter.
 * Interface CharacterService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server
 * với định dạng: "Số thập phân đầu vào".
 * b. Thực hiện chuyển đổi số thập phân nhận được thành chuỗi số La Mã (Roman).
 * Quy tắc: I=1, V=5, X=10, L=50, C=100, D=500, M=1000.
 * Ví dụ: 58 → "LVIII"
 * c. Triệu gọi phương thức submitCharacter để gửi chuỗi số La Mã đã chuyển đổi
 * trở lại server.
 * d. Kết thúc chương trình client.
 */
