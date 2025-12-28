package UDP.UDP;

import UDP.Student;
import java.io.*;
import java.net.*;

public class QLSinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        String code = ";B22DCCN634;QABGDFxd";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student student = (Student) ois.readObject();
        System.out.println(student);
        String name = student.getName();
        String[] words = name.trim().split("\\s+");
        name = "";
        for (String x : words)
            name += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        student.setName(name.trim());
        String email = words[words.length - 1].toLowerCase();
        for (int i = 0; i < words.length - 1; i++)
            email += Character.toLowerCase(words[i].charAt(0));
        email += "@ptit.edu.vn";
        student.setEmail(email);
        System.out.println(student);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
 * ##### BÀI 18. BÀI TOÁN QUẢN LÝ SINH VIÊN
 * [Mã câu hỏi (qCode): QABGDFxd]. Một chương trình server cho phép giao tiếp
 * qua giao thức UDP tại cổng 2209.
 * Đối tượng trao đổi là thể hiện của lớp UDP.Student được mô tả:
 * - Tên đầy đủ lớp: UDP.Student
 * - Các thuộc tính: id String, code String, name String, email String
 * - 02 Hàm khởi tạo:
 * o public Student(String id, String code, String name, String email)
 * o public Student(String code)
 * - Trường dữ liệu: private static final long serialVersionUID = 20171107
 * 
 * Thực hiện:
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại
 * chứa một đối tượng Student.
 * c. Thực hiện:
 * - Chuẩn hóa tên: Chữ cái đầu tiên in hoa, các chữ cái còn lại in thường.
 * - Tạo email ptit.edu.vn từ tên bằng cách lấy tên và các chữ cái bắt đầu của
 * họ và tên đệm. Ví dụ: nguyen van tuan nam → namnvt@ptit.edu.vn.
 * d. Gửi đối tượng đã xử lý lên Server.
 */