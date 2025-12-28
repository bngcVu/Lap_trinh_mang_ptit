package RMI.RMI;

import java.util.*;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PhanTichTSNT {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B22DCCN634", "zzmmquoc");
        System.out.println(n);
        List<Integer> a = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                a.add(i);
                n /= i;
            }
        }
        if (n > 1)
            a.add(n);
        System.out.println(a);
        sv.submitData("B22DCCN634", "zzmmquoc", a);
    }
}
/*
 * ##### [Data] PHÂN TÍCH THỪA SỐ NGUYÊN TỐ
 * [Mã câu hỏi (qCode): zzmmquoc]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một số nguyên dương N từ server.
 * b. Phân tích N thành tích các thừa số nguyên tố.
 * Ví dụ: N = 60 → danh sách thừa số nguyên tố [2, 2, 3, 5].
 * c. Triệu gọi phương thức submitData để gửi danh sách các thừa số nguyên tố
 * (List<Integer>) trở lại server.
 * d. Kết thúc chương trình client.
 */
