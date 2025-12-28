package RMI.RMI;

import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Student;

public class QuanLySinhVien {
    public static String chuanhoa(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String chuanhoa2(String s) {
        String[] tmp = s.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < tmp.length - 1; i++)
            res += chuanhoa(tmp[i]) + " ";
        res += tmp[tmp.length - 1].toUpperCase();
        return res;
    }

    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Student student = (Student) sv.requestObject("B22DCCN634", "lNV6xzmk");
        System.out.println(student);
        student.setName(chuanhoa2(student.getName()));
        String code = String.format("B%d", student.getEnrollmentYear() % 100);
        String[] tmp = student.getName().split("\\s+");
        code += tmp[tmp.length - 1].toUpperCase() + "_";
        for (int i = 0; i < tmp.length - 1; i++)
            code += Character.toUpperCase(tmp[i].charAt(0));
        student.setCode(code);
        System.out.println(student);
        sv.submitObject("B22DCCN634", "lNV6xzmk", student);
    }
}
/*
 * ##### BÀI 19. [Object] BÀI TOÁN QUẢN LÝ SINH VIÊN
 * [Mã câu hỏi (qCode): lNV6xzmk]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý thông tin sinh viên.
 * Lớp Student gồm các thuộc tính: id String, name String, enrollmentYear int,
 * code String.
 * Trường dữ liệu: private static final long serialVersionUID = 20241130L;
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestObject để nhận đối tượng Student ngẫu nhiên
 * từ server.
 * b. Tạo mã code cho sinh viên:
 * - Bắt đầu bằng ký tự "B".
 * - Kế đến là hai chữ số cuối của enrollmentYear.
 * - Sau đó là TÊN của sinh viên, tất cả viết in hoa.
 * - Kết thúc với các chữ cái đầu tiên của Họ và Họ lót, đều viết in hoa.
 * Ví dụ: "Nguyen Van Tuan" năm 2022 → "B22TUAN_NV"
 * Chuẩn hóa tên: Chữ cái đầu tiên của Tên, Họ, Tên lót phải viết hoa, TÊN cuối
 * phải in hoa.
 * c. Cập nhật giá trị mã (code) và tên (name) trong đối tượng Student.
 * d. Triệu gọi phương thức submitObject để gửi đối tượng Student đã được xử lý
 * trở lại server.
 */
