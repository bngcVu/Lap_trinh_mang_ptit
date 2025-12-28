package RMI.RMI;

import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class LietKeSoCP {
    public static boolean check(int x) {
        double y = Math.sqrt(x);
        int y1 = (int) y;
        return y == y1;
    }

    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B22DCCN634", "eTHcAYZh");
        System.out.println(n);
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (check(i))
                a.add(i);
        }
        System.out.println(a);
        sv.submitData("B22DCCN634", "eTHcAYZh", a);
    }
}
/*
 * ##### BÀI 20. [Data] LIỆT KÊ SỐ CHÍNH PHƯƠNG
 * [Mã câu hỏi (qCode): eTHcAYZh]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một số nguyên dương N từ server.
 * b. Liệt kê tất cả các số chính phương trong phạm vi [1, N).
 * Số chính phương là số có căn bậc hai là số nguyên.
 * Ví dụ: N = 20 → danh sách số chính phương là [1, 4, 9, 16].
 * c. Triệu gọi phương thức submitData để gửi danh sách các số chính phương
 * (List<Integer>) trở lại server.
 * d. Kết thúc chương trình client.
 */