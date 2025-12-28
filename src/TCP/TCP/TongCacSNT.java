package TCP.TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class TongCacSNT {
    public static int check(int n) {
        if (n <= 1)
            return 0;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B22DCCN634;htKatHFO";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        ArrayList<Integer> a = new ArrayList<>();
        String[] a1 = s.trim().split(",");
        for (String x : a1)
            a.add(Integer.parseInt(x));
        int tong = 0;
        for (int x : a) {
            if (check(x) == 1)
                tong += x;
        }
        String ans = String.format("%d", tong);
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
/*
 * ##### BÀI 4. TỔNG CÁC SỐ NGUYÊN TỐ
 * [Mã câu hỏi (qCode): ZRFRsEcM]. Một chương trình server hỗ trợ kết nối qua
 * giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu
 * cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server
 * sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin
 * theo thứ tự:
 * 
 * a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
 * Ví dụ: "B16DCCN999;C89DAB45"
 * 
 * b. Nhận dữ liệu từ server là một chuỗi các số nguyên được phân tách bởi ký tự
 * ",".
 * Ví dụ: "8,4,2,10,5,6,1,3"
 * 
 * c. Tính tổng của tất cả các số nguyên tố trong chuỗi và gửi kết quả lên
 * server.
 * Ví dụ: Với dãy "8,4,2,10,5,6,1,3", các số nguyên tố là 2, 5, 3, tổng là 10.
 * Gửi lên server chuỗi "10".
 * 
 * d. Đóng kết nối và kết thúc chương trình.
 */