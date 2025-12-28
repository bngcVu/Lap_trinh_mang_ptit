package TCP.TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class SapXepTheoDoDai {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B22DCCN634;we3kcWxZ";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        String[] tmp = s.trim().split("\\s+");
        ArrayList<String> a = new ArrayList<>();
        for (String x : tmp)
            a.add(x);
        int n = a.size();
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        String ans = "";
        for (int i = 0; i < n - 1; i++)
            ans += a.get(i) + ", ";
        ans += a.get(n - 1);
        System.out.println(ans);
        bw.write(ans);
        bw.newLine();
        bw.flush();
    }
}
/*
 * ##### BÀI 6. SẮP XẾP THEO ĐỘ DÀI
 * [Mã câu hỏi (qCode): we3kcWxZ]. Một chương trình server cho phép kết nối qua
 * giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu
 * cầu là 5 giây). Yêu cầu là xây dựng một chương trình client tương tác với
 * server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản
 * sau:
 * 
 * a. Gửi một chuỗi chứa mã sinh viên và mã câu hỏi với định dạng
 * "studentCode;qCode". Ví dụ: "B15DCCN999;C1234567"
 * 
 * b. Nhận từ server một chuỗi chứa nhiều từ, các từ được phân tách bởi khoảng
 * trắng. Ví dụ: "hello world this is a test example"
 * 
 * c. Sắp xếp các từ trong chuỗi theo độ dài, thứ tự xuất hiện. Gửi danh sách
 * các từ theo từng nhóm về server theo định dạng:
 * "a, is, this, test, hello, world, example".
 * 
 * d. Đóng kết nối và kết thúc chương trình.
 */