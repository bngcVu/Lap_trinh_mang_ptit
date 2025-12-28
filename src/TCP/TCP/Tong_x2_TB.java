package TCP.TCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Tong_x2_TB{
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B22DCCN634;TL9Pol9D";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        ArrayList<Integer>a = new ArrayList<>();
        String []a1 = s.trim().split(",");
        for(String x: a1) a.add(Integer.parseInt(x));
        Collections.sort(a);
        int tong = 0, n = a.size();
        for(int i = 0;i<n;i++) tong+=a.get(i);
        float tbc = (float)tong/n;
        float kcach = Float.MAX_VALUE, mucTieu = 2 * tbc;
        int so1 = 0, so2 = 0;
        for(int i = 0;i<n;i++){
            for(int j = i + 1;j<n;j++){
                int sum = a.get(i) + a.get(j);
                float hieu = Math.abs(sum - mucTieu);
                if (hieu < kcach) {
                    kcach = hieu;
                    so1 = a.get(i);
                    so2 = a.get(j);
                }
            }
        }
        String ans = String.format("%d,%d", so1, so2);
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
/*
##### BÀI 3. TỔNG GẤP ĐÔI TRUNG BÌNH
[Mã câu hỏi (qCode): TL9Pol9D].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B16DCCN999;D45EFA12"

b. Nhận dữ liệu từ server là một chuỗi các số nguyên được phân tách bởi ký tự ",".
Ví dụ: "10,5,15,20,25,30,35"

c. Xác định hai số trong dãy có tổng gần nhất với gấp đôi giá trị trung bình của toàn bộ dãy. Gửi thông điệp lên server theo định dạng "num1,num2".
Ví dụ: Với dãy "10,5,15,20,25,30,35", gấp đôi giá trị trung bình là 40, hai số có tổng gần nhất là 15 và 25. Gửi lên server chuỗi "15,25".

d. Đóng kết nối và kết thúc chương trình.
*/