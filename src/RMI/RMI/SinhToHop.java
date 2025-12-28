package RMI.RMI;

import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class SinhToHop {
    static int ok;

    public static void kt(int a[], int k) {
        for (int i = 1; i <= k; i++)
            a[i] = i;
    }

    public static void sinh(int a[], int n, int k) {
        int i = k;
        while (i >= 1 && a[i] == n - k + i)
            i--;
        if (i == 0) {
            ok = 0;
        } else {
            a[i]++;
            for (int j = i + 1; j <= k; j++)
                a[j] = a[j - 1] + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B22DCCN634", "juC3u7C6");
        System.out.println(s);
        int idx = s.indexOf(";");
        String s1 = s.substring(0, idx), s2 = s.substring(idx + 1);
        int k = Integer.parseInt(s2.trim());
        ArrayList<Integer> a = new ArrayList<>();
        s1 = s1.replace(",", " ");
        String[] tmp = s1.trim().split("\\s+");
        for (String x : tmp)
            a.add(Integer.parseInt(x));
        int n = a.size();
        int[] genIdx = new int[k + 1];
        kt(genIdx, k);
        ok = 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (ok == 1) {
            ArrayList<Integer> tmp1 = new ArrayList<>();
            for (int i = 1; i <= k; i++)
                tmp1.add(a.get(genIdx[i] - 1));
            ans.add(tmp1);
            sinh(genIdx, n, k);
        }
        System.out.println(ans);
        sv.submitData("B22DCCN634", "juC3u7C6", ans);
    }
}
/*
 * ##### BÀI 30. [Data] SINH TỔ HỢP
 * [Mã câu hỏi (qCode): juC3u7C6]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một chuỗi gồm tập hợp số nguyên
 * và một số nguyên K với định dạng: "mảng; số nguyên K".
 * b. Sử dụng thuật toán sinh tổ hợp để tạo ra tất cả các tổ hợp kích thước K
 * của tập hợp đã cho.
 * Ví dụ: [1, 2, 3, 4] với K = 2 → danh sách tổ hợp [[1, 2], [1, 3], [1, 4], [2,
 * 3], [2, 4], [3, 4]].
 * c. Triệu gọi phương thức submitData để gửi danh sách các tổ hợp đã sinh được
 * (ArrayList<ArrayList<Integer>>) trở lại server.
 * d. Kết thúc chương trình client.
 * Chú ý: Output là ArrayList<ArrayList<Integer>>, không phải String!
 */
