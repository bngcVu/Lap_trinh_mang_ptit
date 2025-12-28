package UDP.UDP;

import UDP.Book;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChuanHoaThongTinSach {
    public static String chuanHoa1(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String chuanhoaTitle(String s) {
        String[] tmp = s.trim().split("\\s+");
        String ans = "";
        for (String x : tmp)
            ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }

    public static String chuanhoaISBN(String s) {
        return String.format("%s-%s-%s-%s-%s", s.substring(0, 3), s.substring(3, 4), s.substring(4, 6),
                s.substring(6, 12), s.substring(12));
    }

    public static String chuanhoaAuthor(String s) {
        String[] tmp = s.trim().split("\\s+");
        String ans = tmp[0].toUpperCase() + ", ";
        for (int i = 1; i < tmp.length; i++)
            ans += chuanHoa1(tmp[i]) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }

    public static String chuanhoaNgay(String s) {
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[1] + "/" + part[0];
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        String code = ";B22DCCN634;LFACr5Bi";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte[] buffer = new byte[2048];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();
        System.out.println(book);
        book.setTitle(chuanhoaTitle(book.getTitle()));
        book.setAuthor(chuanhoaAuthor(book.getAuthor()));
        book.setIsbn(chuanhoaISBN(book.getIsbn()));
        book.setPublishDate(chuanhoaNgay(book.getPublishDate()));
        System.out.println(book);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
 * ##### BÀI 3. CHUẨN HOÁ THÔNG TIN SÁCH
 * [Mã câu hỏi (qCode): LFACr5Bi]. Một chương trình server cho phép giao tiếp
 * qua giao thức UDP tại cổng 2209.
 * Đối tượng trao đổi là thể hiện của lớp UDP.Book được mô tả:
 * - Tên đầy đủ lớp: UDP.Book
 * - Các thuộc tính: id (String), title (String), author (String), isbn
 * (String), publishDate (String)
 * - Hàm khởi tạo: public Book(String id, String title, String author, String
 * isbn, String publishDate)
 * - Trường dữ liệu: private static final long serialVersionUID = 20251107L
 * 
 * Thực hiện:
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại
 * chứa một đối tượng Book.
 * c. Thực hiện:
 * 1. Chuẩn hóa title: Với mỗi từ, viết hoa chữ cái đầu tiên, viết thường các
 * chữ cái còn lại.
 * 2. Chuẩn hóa author theo định dạng "Họ, Tên". Họ viết hoa tất cả, Tên viết
 * hoa chữ cái đầu mỗi từ.
 * 3. Chuẩn hóa mã ISBN theo định dạng "978-3-16-148410-0"
 * 4. Chuyển đổi publishDate từ yyyy-mm-dd sang mm/yyyy.
 * d. Gửi lại đối tượng đã được chuẩn hóa về server.
 */
