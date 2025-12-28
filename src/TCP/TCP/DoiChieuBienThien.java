package TCP.TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class DoiChieuBienThien {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B22DCCN634;oNGj55wV";
        out.writeUTF(code);
        out.flush();
        String s = in.readUTF();
        System.out.println(s);
        ArrayList<Integer> a = new ArrayList<>();
        String[] tmp = s.trim().split(",");
        for (String x : tmp)
            a.add(Integer.parseInt(x.trim()));
        int bienThien = 0, n = a.size();
        for (int i = 0; i < n - 1; i++)
            bienThien += Math.abs(a.get(i) - a.get(i + 1));
        int doiChieu = 0;
        for (int i = 1; i < n - 1; i++) {
            if ((a.get(i) > a.get(i - 1) && a.get(i) > a.get(i + 1))
                    || (a.get(i) < a.get(i - 1) && a.get(i) < a.get(i + 1)))
                doiChieu++;
        }
        out.writeInt(doiChieu);
        System.out.println(doiChieu);
        out.writeInt(bienThien);
        System.out.println(bienThien);
        in.close();
        out.close();
        socket.close();
    }
}
/*
 * ##### BÀI 1. ĐỔI CHIỀU VÀ BIẾN THIÊN
 * [Mã câu hỏi (qCode): oNGj55wV]. Một chương trình server cho phép kết nối qua
 * TCP tại cổng 807 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5
 * giây). Yêu cầu xây dựng chương trình client thực hiện giao tiếp với server sử
 * dụng luồng data (DataInputStream/DataOutputStream) để trao đổi thông tin theo
 * thứ tự:
 * 
 * a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
 * Ví dụ: "B10DCCN002;B4C5D6E7"
 * 
 * b. Nhận chuỗi chứa mảng số nguyên từ server, các phần tử được phân tách bởi
 * dấu phẩy ",". Ví dụ: "1,3,2,5,4,7,6"
 * 
 * c. Tính số lần đổi chiều và tổng độ biến thiên trong dãy số.
 * - Đổi chiều: Khi dãy chuyển từ tăng sang giảm hoặc từ giảm sang tăng
 * - Độ biến thiên: Tổng giá trị tuyệt đối của các hiệu số liên tiếp
 * Gửi lần lượt lên server: số nguyên đại diện cho số lần đổi chiều, sau đó là
 * số nguyên đại diện cho tổng độ biến thiên. Ví dụ: Với mảng "1,3,2,5,4,7,6",
 * số lần đổi chiều: 5 lần, Tổng độ biến thiên 11 Gửi lần lượt số nguyên 5 và 11
 * lên server.
 * 
 * d. Đóng kết nối và kết thúc chương trình.
 */