package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Book;

public class QuanLyThuVien1 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Book book = (Book) sv.requestObject("B22DCCN634", "nCOdwcKJ");
        System.out.println(book);
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code += String.format("%c%c", Character.toUpperCase(tmp[0].charAt(0)),
                Character.toUpperCase(tmp[tmp.length - 1].charAt(0)));
        code += String.format("%02d%d%03d", book.getYearPublished() % 100,
                book.getTitle().trim().length(), book.getPageCount());
        book.setCode(code);
        System.out.println(book);
        sv.submitObject("B22DCCN634", "nCOdwcKJ", book);
    }
}
/*
 * ##### BÀI 12. [Object] BÀI TOÁN QUẢN LÝ THƯ VIỆN – 1
 * [Mã câu hỏi (qCode): nCOdwcKJ]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để gán mã code cho sách trong hệ thống quản lý
 * thư viện.
 * Lớp Book gồm các thuộc tính: id String, title String, author String,
 * yearPublished int, pageCount int, code String.
 * Trường dữ liệu: private static final long serialVersionUID = 20241123L;
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestObject để nhận đối tượng Book ngẫu nhiên từ
 * server.
 * b. Tạo mã code cho sách dựa trên:
 * - Lấy chữ cái đầu của họ và tên đầu của tác giả. Ví dụ: "John Doe" → "JD"
 * - Lấy hai chữ số cuối cùng của năm xuất bản. Ví dụ: 1985 → "85"
 * - Lấy tổng số chữ cái trong title
 * - Lấy số chữ số của pageCount (thêm số 0 ở đầu nếu < 3 chữ số)
 * Ví dụ: tác giả "Jane Austen", yearPublished 1813, title 18 ký tự, pageCount
 * 345 → code "JA1318345"
 * c. Cập nhật giá trị code trong đối tượng Book.
 * d. Triệu gọi phương thức submitObject để gửi đối tượng Book đã được xử lý trở
 * lại server.
 */
