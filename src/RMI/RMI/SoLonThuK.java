package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class SoLonThuK {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B22DCCN634", "wzG6G9ji");
        System.out.println(s);
        int x = s.indexOf(";");
        String list = s.substring(0, x), k = s.substring(x + 1);
        ArrayList<Integer> a = new ArrayList<>();
        int k1 = Integer.parseInt(k.trim());
        String[] tmp = list.trim().split(",");
        for (String x1 : tmp)
            a.add(Integer.parseInt(x1.trim()));
        Collections.sort(a);
        int ans = a.get(a.size() - k1);
        sv.submitData("B22DCCN634", "wzG6G9ji", ans);
        System.out.println(ans);
    }
}
/*
 * ##### BÀI 9. [Data] PHẦN TỬ LỚN THỨ K
 * [Mã câu hỏi (qCode): wzG6G9ji]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một chuỗi chứa mảng số nguyên và
 * một số nguyên K với định dạng: "mảng; số nguyên K".
 * b. Sử dụng thuật toán phù hợp để tìm phần tử lớn thứ K trong mảng số nguyên
 * đã cho.
 * Ví dụ: "3, 1, 5, 12, 2, 11; 3" nghĩa là mảng [3, 1, 5, 12, 2, 11] và K = 3 →
 * phần tử lớn thứ 3 là 5.
 * c. Triệu gọi phương thức submitData để gửi kết quả phần tử lớn thứ K đã tìm
 * được trở lại server.
 * d. Kết thúc chương trình client.
 */
