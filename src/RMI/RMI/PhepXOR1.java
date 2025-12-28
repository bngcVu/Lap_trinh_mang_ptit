package RMI.RMI;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PhepXOR1 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "Xidb0Thk");
        System.out.println(s);
        String[] tmp = s.split(";");
        String xorKey = tmp[0], inp = tmp[1], res = "";
        for (int i = 0; i < inp.length(); i++)
            res += (char) (inp.charAt(i) ^ xorKey.charAt(i % xorKey.length()));
        System.out.println(res);
        sv.submitCharacter("B22DCCN634", "Xidb0Thk", res);
    }
}
/*
 * ##### BÀI 10. [Character] PHÉP XOR - 1
 * [Mã câu hỏi (qCode): Xidb0Thk]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa CharacterService: requestCharacter, submitCharacter.
 * Interface CharacterService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server
 * với định dạng: "Khóa XOR;Chuỗi đầu vào".
 * b. Thực hiện thao tác mã hóa XOR cho chuỗi đầu vào với khóa XOR. Mã hóa XOR
 * thực hiện bằng cách áp dụng phép XOR trên từng ký tự, khóa được lặp lại để
 * khớp độ dài.
 * Ví dụ: "A;HELLO" → Khóa "A" → chuỗi mã hóa là: "IFMMN"
 * c. Triệu gọi phương thức submitCharacter để gửi chuỗi đã được mã hóa trở lại
 * server.
 * d. Kết thúc chương trình client.
 */
