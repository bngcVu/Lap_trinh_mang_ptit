package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Ticket;
import java.util.*;

public class QuanLySuKien {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Ticket ticket = (Ticket) sv.requestObject("B22DCCN634", "Uct8bABt");
        System.out.println(ticket);
        String s = ticket.getEventName().toUpperCase();
        String res = "";
        res += String.format("%c%c", Character.toUpperCase(s.charAt(0)),
                (char) Character.toUpperCase(s.charAt(s.length() - 1)));
        String s1 = ticket.getSaleDate();
        s1 = s1.replace("/", " ");
        String[] tmp = s1.trim().split("\\s+");
        res += tmp[1] + tmp[0];
        Set<Integer> si = new HashSet<>();
        for (char x : s1.toCharArray()) {
            if (Character.isDigit(x))
                si.add(x - '0');
        }
        for (int i = 9; i >= 0; i--) {
            if (!si.contains(i)) {
                res += i;
                break;
            }
        }
        for (int i = 0; i <= 9; i++) {
            if (!si.contains(i)) {
                res += i;
                break;
            }
        }
        ticket.setTicketCode(res);
        System.out.println(ticket);
        sv.submitObject("B22DCCN634", "Uct8bABt", ticket);
    }
}
/*
 * ##### BÀI 29. [Object] QUẢN LÝ VÉ SỰ KIỆN
 * [Mã câu hỏi (qCode): Uct8bABt]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để quản lý thông tin vé.
 * Lớp Ticket gồm các thuộc tính: id String, eventName String, saleDate String,
 * ticketCode String.
 * Trường dữ liệu: private static final long serialVersionUID = 20241133L;
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestObject để nhận đối tượng Ticket ngẫu nhiên từ
 * server.
 * b. Tạo mã ticketCode cho vé:
 * - Bắt đầu với hai chữ cái: Chữ cái đầu tiên và cuối cùng của eventName, viết
 * hoa.
 * - Thêm ngày và tháng từ saleDate (theo định dạng "MMdd")
 * - Kết thúc bằng: Chữ số lớn nhất và nhỏ nhất không xuất hiện trong saleDate.
 * Ví dụ: tên sự kiện "Charity Concert", ngày bán "15/06/2024" → ticketCode
 * "CT061593".
 * c. Cập nhật giá trị ticketCode trong đối tượng Ticket.
 * d. Triệu gọi phương thức submitObject để gửi đối tượng Ticket đã được xử lý
 * trở lại server.
 */
