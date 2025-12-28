package RMI.RMI;

import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ByteService;

public class NenRLE {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "2uG0lQGi");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println();
        int cnt = 1;
        ArrayList<Byte> res = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1])
                cnt++;
            else {
                res.add(a[i - 1]);
                res.add((byte) cnt);
                cnt = 1;
            }
        }
        res.add(a[a.length - 1]);
        res.add((byte) cnt);
        byte[] ans = new byte[res.size()];
        int idx = 0;
        for (byte x : res)
            ans[idx++] = x;
        for (byte x : ans)
            System.out.print(x + " ");
        sv.submitData("B22DCCN634", "2uG0lQGi", ans);
    }
}
/*
 * ##### BÀI 27. [Byte] NÉN RLE
 * [Mã câu hỏi (qCode): 2uG0lQGi]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa ByteService: requestData, submitData.
 * Interface ByteService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu byte từ server.
 * b. Thực hiện nén dữ liệu sử dụng thuật toán Run-Length Encoding (RLE) bằng
 * cách ghi nhận mỗi byte và số lần lặp liên tiếp của nó.
 * Kết quả nén là một mảng mới biểu diễn các cặp (byte, số lần lặp).
 * Ví dụ: mảng [10, 10, 10, 20, 20, 30, 30, 30, 30] → kết quả nén RLE [10, 3,
 * 20, 2, 30, 4].
 * c. Triệu gọi phương thức submitData để gửi mảng dữ liệu đã được nén RLE trở
 * lại server.
 * d. Kết thúc chương trình client.
 */
