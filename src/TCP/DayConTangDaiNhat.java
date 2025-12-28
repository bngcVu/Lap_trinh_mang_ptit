package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class DayConTangDaiNhat {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B22DCCN634;XGIm2Fc7";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        ArrayList<Integer> a = new ArrayList<>();
        String[] tmp = s.trim().split(",");
        for (String x : tmp)
            a.add(Integer.parseInt(x));
        int n = a.size();
        int[] f = new int[n], trace = new int[n];
        Arrays.fill(trace, -1);
        for (int i = 0; i < n; i++)
            f[i] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a.get(j) < a.get(i) && f[i] < f[j] + 1) {
                    f[i] = Integer.max(f[i], f[j] + 1);
                    trace[i] = j;
                }
            }
        }
        int maxLength = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] > maxLength) {
                maxLength = f[i];
                endIndex = i;
            }
        }
        ArrayList<Integer> lis = new ArrayList<>();
        while (endIndex != -1) {
            lis.add(0, a.get(endIndex));
            endIndex = trace[endIndex];
        }
        String ans = String.format("%d", lis.get(0));
        for (int i = 1; i < lis.size(); i++)
            ans += String.format(",%d", lis.get(i));
        ans += String.format(";%d", lis.size());
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
/*
 * ##### BÀI 17. DÃY CON LIÊN TIẾP TĂNG DÀI NHẤT
 * [Mã câu hỏi (qCode): RnPqP3f7].
 * Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ
 * trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng
 * chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu
 * (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:
 * 
 * a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ:
 * "B16DCCN999;76B68B3B".
 * 
 * b. Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách
 * bởi ký tự ",". Ví dụ: 5,10,20,25,50,40,30,35.
 * 
 * c. Tìm chuỗi con tăng dần dài nhất và gửi độ dài của chuỗi đó lên server. Ví
 * dụ: 5,10,20,25 có độ dài 4.
 * 
 * d. Đóng kết nối và kết thúc chương trình.
 */
