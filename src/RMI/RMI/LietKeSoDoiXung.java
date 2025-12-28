package RMI.RMI;

import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class LietKeSoDoiXung {
    public static boolean check(int x) {
        String s = x + "";
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B22DCCN634", "t3cBY2uk");
        System.out.println(s);
        s = s.replace(";", "");
        String[] tmp = s.trim().split("\\s+");
        int n = Integer.parseInt(tmp[0].trim()), k = Integer.parseInt(tmp[1].trim());
        List<Integer> a = new ArrayList<>();
        for (int i = n; i < k; i++) {
            if (check(i))
                a.add(i);
        }
        System.out.println(a);
        sv.submitData("B22DCCN634", "t3cBY2uk", a);
    }
}
/*
 * ##### [Data] LIỆT KÊ SỐ ĐỐI XỨNG
 * [Mã câu hỏi (qCode): t3cBY2uk]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một chuỗi với định dạng "N; K".
 * b. Liệt kê tất cả các số đối xứng (palindrome) trong phạm vi [N, K).
 * Số đối xứng là số đọc xuôi hay ngược đều giống nhau.
 * Ví dụ: N=10, K=200 → danh sách [11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111,
 * 121, 131, 141, 151, 161, 171, 181, 191].
 * c. Triệu gọi phương thức submitData để gửi danh sách các số đối xứng
 * (List<Integer>) trở lại server.
 * d. Kết thúc chương trình client.
 */
