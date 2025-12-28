package UDP.UDP;

import UDP.Product;
import java.io.*;
import java.net.*;

public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        String code = ";B22DCCN634;OX8O73nD ";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for (String x : words)
            tmpx += x + " ";
        product.setName(tmpx.trim());
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for (int i = tmp.length() - 1; i >= 0; i--)
            tmp1 += String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
 * ##### BÀI 9. SẢN PHẨM [Object]
 * [Mã câu hỏi (qCode): kZqFKEDL]. Thông tin sản phẩm vì một lý do nào đó đã bị
 * sửa đổi thành không đúng, cụ thể:
 * a. Tên sản phẩm bị đổi ngược từ đầu tiên và từ cuối cùng, ví dụ:
 * "lenovo thinkpad T520" bị chuyển thành "T520 thinkpad lenovo"
 * b. Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899
 * 
 * Đối tượng trao đổi là thể hiện của lớp UDP.Product:
 * - Tên đầy đủ của lớp: UDP.Product
 * - Các thuộc tính: id String, code String, name String, quantity int
 * - Hàm khởi tạo đầy đủ các thuộc tính
 * - Trường dữ liệu: private static final long serialVersionUID = 20161107;
 * 
 * Giao tiếp với server tại cổng 2209:
 * - Gửi thông điệp mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * - Nhận thông điệp: 08 byte đầu chứa requestId, các byte còn lại chứa đối
 * tượng Product.
 * - Sửa các thông tin sai và gửi lại đối tượng đã sửa đổi.
 */
