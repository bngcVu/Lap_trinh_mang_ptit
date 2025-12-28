package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class LonThuK {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "uIKHCTWG");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println();
        byte[] b = Arrays.copyOf(a, a.length);
        int k = a[a.length - 1], pos = 0;
        Arrays.sort(a);
        for (int i = 0; i < b.length; i++) {
            if (b[i] == a[a.length - k]) {
                pos = i;
                break;
            }
        }
        byte[] ans = { (byte) a[a.length - k], (byte) (pos + 1) };
        for (byte x : ans)
            System.out.print(x + " ");
        sv.submitData("B22DCCN634", "uIKHCTWG", ans);
    }
}
/*
 * ##### BÀI 32. [Byte] PHẦN TỬ LỚN THỨ K
 * [Mã câu hỏi (qCode): uIKHCTWG]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa ByteService: requestData, submitData.
 * Interface ByteService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân
 * (byte[]) từ server, cùng với một số nguyên K (phần tử cuối cùng của mảng).
 * b. Tìm phần tử lớn thứ K trong mảng byte[] với K là phần tử cuối cùng của
 * mảng.
 * Ví dụ: mảng [3, 1, 5, 12, 2, 11, 3] với K = 3 → phần tử lớn thứ 3 là 5.
 * c. Triệu gọi phương thức submitData để gửi mảng byte gồm phần tử lớn thứ K và
 * vị trí của K (tính từ 1) trở lại server.
 * d. Kết thúc chương trình client.
 */
