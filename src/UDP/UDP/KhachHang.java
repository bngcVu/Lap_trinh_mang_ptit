package UDP.UDP;

import UDP.Customer;
import java.io.*;
import java.net.*;

public class KhachHang {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        String code = ";B17DCAT176;OH7rzusB";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer customer = (Customer) ois.readObject();
        System.out.println(customer);
        String[] tenTmp = customer.getName().split("\\s+");
        String tenMoi = "";
        tenMoi += tenTmp[tenTmp.length - 1].toUpperCase() + ", ";
        for (int i = 0; i < tenTmp.length - 1; i++)
            tenMoi += Character.toUpperCase(tenTmp[i].charAt(0)) + tenTmp[i].substring(1).toLowerCase() + " ";
        customer.setName(tenMoi.trim());
        String[] nsTmp = customer.getDayOfBirth().split("-");
        String nsMoi = nsTmp[1] + "/" + nsTmp[0] + "/" + nsTmp[2];
        customer.setDayOfBirth(nsMoi);
        String userMoi = "";
        for (int i = 0; i < tenTmp.length - 1; i++)
            userMoi += Character.toLowerCase(tenTmp[i].charAt(0));
        userMoi += tenTmp[tenTmp.length - 1].toLowerCase();
        customer.setUserName(userMoi);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        oos.flush();
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
 * ##### BÀI 17. KHÁCH HÀNG
 * [Mã câu hỏi (qCode): 4MpxJ947]. Thông tin khách hàng được yêu cầu thay đổi
 * định dạng lại cho phù hợp với khu vực:
 * a. Tên khách hàng cần được chuẩn hóa theo định dạng mới. Ví dụ: nguyen van
 * hai duong -> DUONG, Nguyen Van Hai
 * b. Ngày sinh của khách hàng đang ở dạng mm-dd-yyyy, cần được chuyển thành
 * định dạng dd/mm/yyyy. Ví dụ: 10-11-2012 → 11/10/2012
 * c. Tài khoản khách hàng được tạo từ các chữ cái in thường được sinh tự động
 * từ họ tên khách hàng. Ví dụ: nguyen van hai duong → nvhduong
 * 
 * Đối tượng trao đổi là thể hiện của lớp UDP.Customer:
 * - Tên đầy đủ của lớp: UDP.Customer
 * - Các thuộc tính: id String, code String, name String, dayOfBirth String,
 * userName String
 * - Hàm khởi tạo với đầy đủ các thuộc tính
 * - Trường dữ liệu: private static final long serialVersionUID = 20151107;
 * 
 * Client giao tiếp với server tại cổng 2209:
 * - Gửi thông điệp mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * - Nhận thông điệp: 08 byte đầu chứa requestId, các byte còn lại chứa đối
 * tượng Customer.
 * - Thay đổi thông tin các thuộc tính như yêu cầu và gửi lại đối tượng đã sửa
 * đổi.
 */