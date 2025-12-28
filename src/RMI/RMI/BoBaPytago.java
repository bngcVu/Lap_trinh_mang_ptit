package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class BoBaPytago {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B22DCCN634", "NMATI6Zw");
        System.out.println(N);
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                for (int c = b + 1; c <= N; c++) {
                    if (a * a + b * b == c * c) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(a);
                        triple.add(b);
                        triple.add(c);
                        res.add(triple);
                    }
                }
            }
        }
        System.out.println(res);
        sv.submitData("B22DCCN634", "NMATI6Zw", res);
    }
}
/*
 * ##### BÀI 1. [Data] BỘ BA SỐ PYTAGO
 * [Mã câu hỏi (qCode): NMATI6Zw]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một số nguyên dương N từ server,
 * đại diện cho giới hạn trên của khoảng cần kiểm tra.
 * b. Xác định tất cả các bộ ba số nguyên (a, b, c) sao cho a² + b² = c² và a <
 * b < c ≤ N.
 * Ví dụ: Với N = 20, kết quả là [(3, 4, 5), (5, 12, 13), (8, 15, 17)].
 * c. Triệu gọi phương thức submitData để gửi đối tượng List<List<Integer>> danh
 * sách các bộ ba số Pytago đã tìm được trở lại server.
 * d. Kết thúc chương trình client.
 */
