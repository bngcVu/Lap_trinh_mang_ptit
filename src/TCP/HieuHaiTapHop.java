package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class HieuHaiTapHop {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B22DCCN634;vYbP7vOA";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s1 = br.readLine();
        System.out.println(s1);
        String s2 = br.readLine();
        System.out.println(s2);
        String ans = "";
        int[] cnt = new int[10005];
        for (char x : s2.toCharArray())
            cnt[x]++;
        for (char x : s1.toCharArray()) {
            if (cnt[x] == 0)
                ans += x;
        }
        System.out.println(ans);
        bw.write(ans);
        bw.newLine();
        bw.flush();
    }
}
/*
 * ##### BÀI 14. HIỆU CỦA HAI TẬP KÝ TỰ
 * [Mã câu hỏi (qCode): wWTzyRuY]. [Loại bỏ các ký tự trong chuỗi thứ nhất mà
 * xuất hiện trong chuỗi thứ hai] Một chương trình server cho phép kết nối qua
 * giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu
 * cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server
 * sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản sau:
 * 
 * a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng
 * "studentCode;qCode". Ví dụ: "B15DCCN999;DE0C2BF0"
 * 
 * b. Nhận lần lượt hai chuỗi ngẫu nhiên từ server
 * 
 * c. Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai,
 * yêu cầu giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi thứ nhất đã được xử
 * lý lên server.
 * 
 * d. Đóng kết nối và kết thúc chương trình
 */
