package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;

public class DemSoLanXH2 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "ctRfIejL");
        System.out.println(s);
        int[] cnt = new int[256];
        for (char x : s.toCharArray())
            cnt[x]++;
        String res = "";
        boolean first = true;
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                if (!first)
                    res += ", ";
                res += String.format("\"%c\": %d", x, cnt[x]);
                cnt[x] = 0;
                first = false;
            }
        }
        res = "{" + res + "}";
        System.out.println(res);
        sv.submitCharacter("B22DCCN634", "ctRfIejL", res);
    }
}
/*
 * ##### BÀI 14. [Character] ĐẾM SỐ LẦN XUẤT HIỆN - 2
 * [Mã câu hỏi (qCode): ctRfIejL]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa CharacterService: requestCharacter, submitCharacter.
 * Interface CharacterService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server.
 * b. Thực hiện đếm tần số xuất hiện của từng ký tự trong chuỗi đầu vào. Kết quả
 * trả về là danh sách các ký tự kèm theo số lần xuất hiện.
 * Ví dụ: "Hello world" → {"H": 1, "e": 1, "l": 3, "o": 2, " ": 1, "w": 1, "r":
 * 1, "d": 1}
 * c. Triệu gọi phương thức submitCharacter để gửi kết quả đếm tần số ký tự trở
 * lại server dưới dạng chuỗi đã được định dạng.
 * d. Kết thúc chương trình client.
 */
