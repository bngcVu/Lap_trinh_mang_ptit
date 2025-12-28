package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class LocKyTu {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B22DCCN634;TuTa8p7";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        int[] cnt = new int[10005];
        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x))
                cnt[x]++;
        }
        String ans = "";
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                ans += x;
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        bw.write(ans);
        bw.newLine();
        bw.flush();
    }
}
/*
 * ##### BÀI 18. LỌC KÝ TỰ
 * [Mã câu hỏi (qCode): mhUhFT2v]. [Loại bỏ ký tự đặc biệt, trùng và giữ nguyên
 * thứ tự xuất hiện] Một chương trình server cho phép kết nối qua giao thức TCP
 * tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu
 * cầu là xây dựng một chương trình client tương tác tới server sử dụng các
 * luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản dưới đây:
 * 
 * a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng
 * "studentCode;qCode". Ví dụ: "B15DCCN999;7D6265E3"
 * 
 * b. Nhận một chuỗi ngẫu nhiên từ server
 * 
 * c. Loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của
 * ký tự. Gửi chuỗi đã được xử lý lên server.
 * 
 * d. Đóng kết nối và kết thúc chương trình
 */
