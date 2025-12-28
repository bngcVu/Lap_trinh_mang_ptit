package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class DayConKhongLapDaiNhat {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B22DCCN634;HyHAk4P5";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        int ans = 0;
        String strMax = "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[256];
            String tmp = "";
            for (int j = i; j < s.length(); j++) {
                if (cnt[s.charAt(j)] == 1)
                    break;
                else {
                    cnt[s.charAt(j)] = 1;
                    tmp += s.charAt(j);
                    if (tmp.length() > strMax.length()) {
                        strMax = tmp;
                        ans = tmp.length();
                    }
                }
            }
        }
        res = String.format("%s;%d", strMax, ans);
        System.out.println(res);
        out.write(res.getBytes());
        out.flush();
    }
}
/*
 * ##### BÀI 19. DÃY CON LIÊN TIẾP KHÔNG LẶP DÀI NHẤT
 * [Mã câu hỏi (qCode): HyHAk4P5].
 * Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206
 * (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một
 * chương trình client thực hiện kết nối tới server sử dụng các luồng byte
 * (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:
 * 
 * a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ:
 * "B16DCCN999;10048F28".
 * 
 * b. Nhận chuỗi ký tự s từ server. Ví dụ: "abcabcbb"
 * 
 * c. Tìm và gửi lên server chuỗi con dài nhất từ chuỗi nhận được mà không có ký
 * tự lặp lại theo format "longestsubstring;length". Ví dụ: "abc;3".
 * 
 * d. Đóng kết nối và kết thúc chương trình.
 * 
 * Chú ý:
 * 1. Ràng buộc: 10 ≤ len(s) ≤ 1000
 * 2. Nếu có nhiều xâu con liên tiếp đều có chung độ dài lớn nhất và thoả mãn
 * không lặp lại, chỉ ghi nhận xâu con liên tiếp có vị trí xuất hiện bé nhất
 * trong xâu ban đầu.
 */
