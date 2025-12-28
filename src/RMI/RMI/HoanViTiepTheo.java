package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class HoanViTiepTheo {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B22DCCN634", "3Qe0Qb5w");
        System.out.println(s);
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : tmp)
            a.add(Integer.parseInt(x));
        int n = a.size();
        int i = n - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1))
            i--;
        if (i < 0)
            Collections.sort(a);
        else {
            int j = n - 1;
            while (a.get(j) <= a.get(i))
                j--;
            Collections.swap(a, i, j);
            int l = i + 1, r = n - 1;
            while (l < r) {
                Collections.swap(a, l, r);
                l++;
                r--;
            }
        }
        String res = "";
        for (int x : a)
            res += String.format("%d,", x);
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        sv.submitData("B22DCCN634", "3Qe0Qb5w", res);
    }
}
/*
 * ##### BÀI 17. [Data] HOÁN VỊ TIẾP THEO
 * [Mã câu hỏi (qCode): 3Qe0Qb5w]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một chuỗi chứa dãy số với định
 * dạng: "1,2,3...".
 * b. Sử dụng thuật toán sinh hoán vị để tìm hoán vị tiếp theo của dãy số nhận
 * được (hoán vị nhỏ nhất lớn hơn hoán vị hiện tại).
 * Ví dụ: dãy [1, 2, 3] → hoán vị tiếp theo [1, 3, 2].
 * c. Triệu gọi phương thức submitData để gửi hoán vị tiếp theo của dãy số trở
 * lại server với định dạng chuỗi "1,3,2".
 * d. Kết thúc chương trình client.
 */
