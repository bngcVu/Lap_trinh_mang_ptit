package TCP.TCP;

import java.io.*;
import java.net.*;
import TCP.Address;

public class DiaChi {
    public static String chuanHoa0(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String chuanHoa1(String s) {
        String ans = "";
        String[] tmp = s.trim().split("\\s+");
        for (String x : tmp)
            ans += chuanHoa0(loaiBo1(x)) + " ";
        return ans;
    }

    public static String loaiBo1(String s) {
        String ans = "";
        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x) || Character.isDigit(x))
                ans += String.format("%c", x);
        }
        return ans;
    }

    public static String loaiBo2(String s) {
        String ans = "";
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x) || x == '-')
                ans += String.format("%c", x);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String code = "B22DCCN634;AjecapMw";
        out.writeObject(code);
        out.flush();
        Address ad = (Address) in.readObject();
        System.out.println(ad);
        ad.setAddressLine(chuanHoa1(ad.getAddressLine()));
        ad.setPostalCode(loaiBo2(ad.getPostalCode()));
        System.out.println(ad);
        out.writeObject(ad);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
/*
 * ##### BÀI 8. ĐỊA CHỈ KHÁCH HÀNG
 * [Mã câu hỏi (qCode): XtWjagNp]. Một chương trình server cho phép kết nối qua
 * giao thức TCP tại cổng 809 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu
 * là 5 giây). Yêu cầu là xây dựng một chương trình client tương tác với server
 * sử dụng các luồng đối tượng (ObjectOutputStream/ObjectInputStream) để
 * gửi/nhận và chuẩn hóa thông tin địa chỉ của khách hàng.
 * Biết rằng lớp TCP.Address có các thuộc tính (id int, code String, addressLine
 * String, city String, postalCode String) và trường dữ liệu private static
 * final long serialVersionUID = 20180801L.
 * 
 * a. Gửi đối tượng là một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng
 * "studentCode;qCode". Ví dụ: "B15DCCN999;A1B2C3D4"
 * 
 * b. Nhận một đối tượng là thể hiện của lớp TCP.Address từ server. Thực hiện
 * chuẩn hóa thông tin addressLine bằng cách:
 * • Chuẩn hóa addressLine: Viết hoa chữ cái đầu mỗi từ, in thường các chữ còn
 * lại, loại bỏ ký tự đặc biệt và khoảng trắng thừa (ví dụ:
 * "123 nguyen!!! van cu" → "123 Nguyen Van Cu")
 * • Chuẩn hóa postalCode: Chỉ giữ lại số và ký tự "-" ví dụ: "123-456"
 * 
 * c. Gửi đối tượng đã được chuẩn hóa thông tin địa chỉ lên server.
 * 
 * d. Đóng kết nối và kết thúc chương trình.
 */
