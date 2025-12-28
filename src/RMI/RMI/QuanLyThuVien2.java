package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.BookX;

public class QuanLyThuVien2 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        BookX book = (BookX) sv.requestObject("B22DCCN634", "CoWosBho");
        System.out.println(book);
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code += tmp[0].charAt(0);
        code += tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1);
        code += String.format("%02d%d%d", book.getYearPublished() % 100,
                book.getGenre().trim().length(), book.getTitle().length() % 10);
        book.setCode(code);
        sv.submitObject("B22DCCN634", "CoWosBho", book);
    }
}
/*
 * ##### BÀI 16. [Object] BÀI TOÁN QUẢN LÝ THƯ VIỆN - 2
 * [Mã câu hỏi (qCode): CoWosBho]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý mã hóa dữ liệu tác phẩm.
 * Lớp BookX gồm các thuộc tính: id String, title String, author String,
 * yearPublished int, genre String, code String.
 * Trường dữ liệu: private static final long serialVersionUID = 20241124L;
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestObject để nhận đối tượng BookX ngẫu nhiên từ
 * server.
 * b. Tạo mã code cho sách dựa trên:
 * - Lấy chữ cái đầu tiên và cuối cùng trong tên tác giả (author).
 * - Lấy hai chữ số cuối cùng của yearPublished.
 * - Số lượng chữ cái trong genre của sách.
 * - Độ dài của title chia lấy dư cho 10.
 * Ví dụ: tác giả "Mark Twain", năm 1884, thể loại "Fiction" 7 ký tự, tiêu đề 24
 * ký tự → code "Mn8474".
 * c. Cập nhật giá trị code trong đối tượng BookX.
 * d. Triệu gọi phương thức submitObject để gửi đối tượng BookX đã được xử lý
 * trở lại server.
 */
