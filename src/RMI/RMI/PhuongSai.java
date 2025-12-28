package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;

public class PhuongSai {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B22DCCN634", "uZMEY3Zg");
        System.out.println(s);
        ArrayList<Double> a = new ArrayList<>();
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        for (String x : tmp)
            a.add(Double.parseDouble(x));
        int n = a.size();
        double tong = 0, tongTmp = 0;
        for (double x : a)
            tong += x;
        double tbc = tong / (double) n;
        for (double x : a)
            tongTmp += (x - tbc) * (x - tbc);
        double pSai = tongTmp / n;
        double doLechChuan = Math.sqrt(pSai);
        System.out.println(pSai);
        System.out.println(doLechChuan);
        String res = String.format("%.2f : %.2f", pSai, doLechChuan);
        System.out.println(res);
        sv.submitData("B22DCCN634", "uZMEY3Zg", res);
    }
}
/*
 * ##### [Data] PHƯƠNG SAI VÀ ĐỘ LỆCH CHUẨN
 * [Mã câu hỏi (qCode): uZMEY3Zg]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu.
 * Giao diện từ xa DataService: requestData, submitData.
 * Interface DataService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một chuỗi chứa dãy số thực với
 * định dạng "số1,số2,số3,...".
 * b. Tính phương sai và độ lệch chuẩn của dãy số.
 * Phương sai = Σ(xi - x̄)² / n; Độ lệch chuẩn = √Phương sai.
 * Ví dụ: Dãy [1, 2, 3, 4, 5] → TB = 3, Phương sai = 2.0, Độ lệch chuẩn = 1.41
 * c. Triệu gọi phương thức submitData để gửi kết quả với định dạng
 * "phương_sai : độ_lệch_chuẩn" (2 chữ số thập phân) trở lại server.
 * d. Kết thúc chương trình client.
 */