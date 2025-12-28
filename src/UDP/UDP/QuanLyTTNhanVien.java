package UDP.UDP;

import UDP.Employee;
import java.io.*;
import java.net.*;
import java.util.*;

public class QuanLyTTNhanVien {
    public static String chuanHoa1(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String chuanHoaTen(String s) {
        String[] tmp = s.trim().split("\\s+");
        String ans = "";
        for (String x : tmp)
            ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }

    public static String chuanhoaNgay(String s) {
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[2] + "/" + part[1] + "/" + part[0];
    }

    public static double tangLuong(String ngay, double luongCu) {
        ngay = ngay.replace("/", " ");
        String[] part = ngay.split("\\s+");
        int tong = 0;
        for (char c : part[2].toCharArray())
            tong += c - '0';
        double luongMoi = luongCu * (1 + tong / 100.0);
        return luongMoi;
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        String code = ";B22DCCN634;ySsumsIE";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee emp = (Employee) ois.readObject();
        System.out.println(emp);
        emp.setName(chuanHoaTen(emp.getName()));
        emp.setHireDate(chuanhoaNgay(emp.getHireDate()));
        emp.setSalary(tangLuong(emp.getHireDate(), emp.getSalary()));
        System.out.println(emp);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(emp);
        oos.flush();
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
 * ##### BÀI 4. QUẢN LÝ THÔNG TIN NHÂN VIÊN
 * [Mã câu hỏi (qCode): ySsumsIE]. Một chương trình server cho phép giao tiếp
 * qua giao thức UDP tại cổng 2209.
 * Đối tượng trao đổi là thể hiện của lớp UDP.Employee được mô tả:
 * - Tên đầy đủ lớp: UDP.Employee
 * - Các thuộc tính: id (String), name (String), salary (double), hireDate
 * (String)
 * - Hàm khởi tạo: public Employee(String id, String name, double salary, String
 * hireDate)
 * - Trường dữ liệu: private static final long serialVersionUID = 20261107L
 * 
 * Thực hiện:
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại
 * chứa một đối tượng Employee.
 * c. Thực hiện:
 * - Chuẩn hóa name: viết hoa chữ cái đầu của mỗi từ.
 * - Tăng salary: tăng x% lương, với x bằng tổng các chữ số của năm sinh.
 * - Chuyển đổi hireDate từ định dạng yyyy-mm-dd sang dd/mm/yyyy.
 * d. Gửi lại đối tượng đã được chuẩn hóa về server.
 */
