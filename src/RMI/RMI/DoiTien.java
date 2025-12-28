package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class DoiTien {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B22DCCN634", "Iz06p8Zw"), res = 0;
        System.out.println(n);
        String ans = "";
        int[] a = { 1, 2, 5, 10 };
        for (int i = 3; i >= 0; i--) {
            int p = n / a[i];
            if (p > 0) {
                res += p;
                n -= p * a[i];
                for (int j = 0; j < p; j++)
                    ans += a[i] + ",";
            }
        }
        if (n > 0)
            ans = "-1";
        else {
            ans = ans.substring(0, ans.length() - 1);
            ans = String.format("%d; ", res) + ans;
        }
        System.out.println(ans);
        sv.submitData("B22DCCN634", "Iz06p8Zw", ans);
    }
}
/*
 * ##### BÀI 13. [Data] ĐỔI TIỀN
 * [Mã câu hỏi (qCode): Iz06p8Zw]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một số nguyên dương amount từ
 * server, đại diện cho số tiền cần đạt được.
 * b. Sử dụng thuật toán xếp đồng xu với các mệnh giá cố định [1, 2, 5, 10] để
 * xác định số lượng đồng xu tối thiểu cần thiết. Nếu không thể đạt được số tiền
 * đó, trả về -1.
 * Ví dụ: amount = 18 với mệnh giá [1, 2, 5, 10] → kết quả là 4 (18 = 10 + 5 + 2
 * + 1).
 * Chuỗi cần gửi: "4; 10,5,2,1"
 * c. Triệu gọi phương thức submitData để gửi chuỗi chứa kết quả số lượng đồng
 * xu tối thiểu và giá trị các đồng xu trở lại server.
 * d. Kết thúc chương trình client.
 */
