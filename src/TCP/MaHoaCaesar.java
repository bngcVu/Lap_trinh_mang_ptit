package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class MaHoaCaesar {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B22DCCN634;doW5fnkq";
        out.writeUTF(code);
        out.flush();
        String s = in.readUTF();
        int k = in.readInt();
        System.out.println(s + " " + k);
        String ans = "";
        for (char x : s.toCharArray()) {
            if (Character.isLetter(x)) {
                char base = Character.isUpperCase(x) ? 'A' : 'a';
                x = (char) (((x - base - k + 26) % 26) + base);
            }
            ans += x;
        }
        System.out.println(ans);
        out.writeUTF(ans);
        out.flush();
    }
}
/*
 * ##### BÀI 13. MÃ HOÁ CAESAR
 * [Mã câu hỏi (qCode): doW5fnkq]. Mật mã caesar, còn gọi là mật mã dịch chuyển,
 * để giải mã thì mỗi ký tự nhận được sẽ được thay thế bằng một ký tự cách nó
 * một đoạn s. Ví dụ: với s = 3 thì ký tự "A" sẽ được thay thế bằng ký tự "D".
 * Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ
 * trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng
 * chương trình client tương tác với server trên, sử dụng các luồng byte
 * (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:
 * 
 * a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng
 * "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7"
 * 
 * b. Nhận lần lượt chuỗi đã bị mã hóa caesar và giá trị dịch chuyển s nguyên
 * 
 * c. Thực hiện giải mã ra thông điệp ban đầu và gửi lên Server
 * 
 * d. Đóng kết nối và kết thúc chương trình.
 * 
 * Giải: Lời giải đúng của bài này là:
 * • Các ký tự không phải là chữ thì giữ nguyên không thay đổi
 * • Các ký tự là chữ hoa, chữ thường thì được TRỪ LÙI tương ứng theo chữ cái đó
 */
