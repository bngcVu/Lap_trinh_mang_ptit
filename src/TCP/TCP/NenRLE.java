package TCP.TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class NenRLE {
    public static String xauDao(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--)
            res += String.format("%c", s.charAt(i));
        return res;
    }

    public static String RLE(String s) {
        int cnt = 1;
        String ans = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                cnt++;
            else {
                ans += String.format("%c", s.charAt(i - 1));
                if (cnt >= 2)
                    ans += String.format("%d", cnt);
                cnt = 1;
            }
        }
        ans += String.format("%c", s.charAt(s.length() - 1));
        if (cnt >= 2)
            ans += String.format("%d", cnt);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B22DCCN634;ji3fQD3Q";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        String[] tmp = s.trim().split("\\s+");
        ArrayList<String> a = new ArrayList<>();
        for (String word : tmp) {
            String dao = xauDao(word);
            String nen = RLE(dao);
            a.add(nen);
        }
        String res = String.join(" ", a);
        System.out.println(res);
        bw.write(res);
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        socket.close();
    }
}
/*
 * ##### BÀI 7. NÉN RLE
 * [Mã câu hỏi (qCode): ji3fQD3Q]. Một chương trình server cho phép kết nối qua
 * giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu
 * cầu là 5 giây). Yêu cầu là xây dựng một chương trình client tương tác với
 * server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản
 * sau:
 * 
 * a. Gửi một chuỗi chứa mã sinh viên và mã câu hỏi với định dạng
 * "studentCode;qCode".
 * Ví dụ: "B15DCCN999;1D08FX21"
 * 
 * b. Nhận từ server một chuỗi chứa nhiều từ, các từ được phân tách bởi khoảng
 * trắng.
 * Ví dụ: "hello world programming is fun"
 * 
 * c. Thực hiện đảo ngược từ và mã hóa RLE để nén chuỗi ("aabb" nén thành
 * "a2b2"). Gửi chuỗi đã được xử lý lên server. Ví dụ:
 * "ol2eh dlrow gnim2argorp si nuf".
 * 
 * d. Đóng kết nối và kết thúc chương trình
 */
