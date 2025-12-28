package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;

public class ChuyenDoiLaMaThapPhan {
    public static long trans(char c) {
        if (c == 'I')
            return 1;
        else if (c == 'V')
            return 5;
        else if (c == 'X')
            return 10;
        else if (c == 'L')
            return 50;
        else if (c == 'C')
            return 100;
        else if (c == 'D')
            return 500;
        else
            return 1000;
    }

    public static long change(String s) {
        long tong = 0;
        tong += trans(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (trans(s.charAt(i + 1)) > trans(s.charAt(i)))
                tong -= trans(s.charAt(i));
            else
                tong += trans(s.charAt(i));
        }
        return tong;
    }

    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "0JaasIw6");
        System.out.println(s);
        System.out.println(change(s));
        sv.submitCharacter("B22DCCN634", "0JaasIw6", String.valueOf(change(s)));
    }
}
/*
 * ##### [Character] CHUYỂN ĐỔI LA MÃ → THẬP PHÂN
 * [Mã câu hỏi (qCode): 0JaasIw6]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa CharacterService: requestCharacter, submitCharacter.
 * Interface CharacterService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi số La Mã từ server.
 * b. Chuyển đổi số La Mã nhận được thành số thập phân.
 * Quy tắc: I=1, V=5, X=10, L=50, C=100, D=500, M=1000.
 * Ví dụ: "LVIII" → 58
 * c. Triệu gọi phương thức submitCharacter để gửi chuỗi số thập phân đã chuyển
 * đổi trở lại server.
 * d. Kết thúc chương trình client.
 */
