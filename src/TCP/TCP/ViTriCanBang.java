package TCP.TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class ViTriCanBang {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B22DCCN634;zmNHK0Y7";
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
        int n = a.size(), pos = 0, res = Integer.MAX_VALUE, tongTrai = 0, tongPhai = 0;
        for (int i = 1; i < n - 1; i++) {
            int tong1 = 0, tong2 = 0;
            for (int j = 0; j < i; j++)
                tong1 += a.get(j);
            for (int j = i + 1; j < n; j++)
                tong2 += a.get(j);
            int hieu = Math.abs(tong1 - tong2);
            if (hieu < res) {
                res = hieu;
                pos = i;
                tongTrai = tong1;
                tongPhai = tong2;
            }
        }
        String ans = String.format("%d,%d,%d,%d", pos, tongTrai, tongPhai, res);
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
/*
 * ##### BÀI 5. VỊ TRÍ CÂN BẰNG TỔNG
 * [Mã câu hỏi (qCode): zmNHK0Y7]. Một chương trình server hỗ trợ kết nối qua
 * giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu
 * cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server
 * sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin
 * theo thứ tự:
 * 
 * a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
 * Ví dụ: "B16DCCN999;E56FAB67"
 * 
 * b. Nhận dữ liệu từ server là một chuỗi các số nguyên được phân tách bởi ký tự
 * ",".
 * Ví dụ: " 3,7,2,5,8,1"
 * 
 * c. Tìm vị trí mà độ lệch của tổng bên trái và tổng bên phải là nhỏ nhất ->
 * Gửi lên server vị trí đó, tổng trái, tổng phải và độ lệch. Ví dụ: với dãy
 * " 3,7,2,5,8,1", vị trí 3 có độ lệch nhỏ nhất = 3 → Kết quả gửi server:
 * "3,12,9,3"
 * 
 * d. Đóng kết nối và kết thúc chương trình.
 */