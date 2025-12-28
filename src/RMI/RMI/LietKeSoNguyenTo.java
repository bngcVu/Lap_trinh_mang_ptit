package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class LietKeSoNguyenTo {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B22DCCN634", "nD8MdtME");
        System.out.println(N);
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (check(i) == 1)
                res.add(i);
        }
        System.out.println(res);
        sv.submitData("B22DCCN634", "NMATI6Zw", res);
    }

    public static int check(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return 0;
        }
        return 1;
    }
}
/*
 * ##### BÀI 5. [Data] LIỆT KÊ SỐ NGUYÊN TỐ
 * [Mã câu hỏi (qCode): nD8MdtME]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một số nguyên dương N từ server.
 * b. Liệt kê tất cả các số nguyên tố trong phạm vi [2, N].
 * Số nguyên tố là số chỉ chia hết cho 1 và chính nó.
 * Ví dụ: N = 20 → danh sách [2, 3, 5, 7, 11, 13, 17, 19].
 * c. Triệu gọi phương thức submitData để gửi danh sách các số nguyên tố
 * (List<Integer>) trở lại server.
 * d. Kết thúc chương trình client.
 */
