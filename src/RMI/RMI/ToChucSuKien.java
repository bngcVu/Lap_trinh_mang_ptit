package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Event;

public class ToChucSuKien {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Event event = (Event) sv.requestObject("B22DCCN634", "FKrGvwLM");
        System.out.println(event);
        String ans = "";
        int x = event.getExpectedAttendance();
        if (x >= 1000)
            ans = "L";
        else if (x >= 500 && x <= 999)
            ans = "M";
        else
            ans = "S";
        String[] tmp = event.getEventName().trim().split("\\s+");
        ans += Character.toUpperCase(tmp[0].charAt(0));
        ans += Character.toUpperCase(tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1));
        String tmp1 = event.getEventDate();
        tmp1 = tmp1.replace("-", " ");
        String[] tmp2 = tmp1.trim().split("\\s+");
        ans += tmp2[2] + tmp2[1];
        event.setEventCode(ans);
        System.out.println(event);
        sv.submitObject("B22DCCN634", "FKrGvwLM", event);
    }
}
/*
 * ##### BÀI 24. [Object] TỔ CHỨC SỰ KIỆN
 * [Mã câu hỏi (qCode): FKrGvwLM]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để quản lý thông tin các sự kiện.
 * Lớp Event gồm các thuộc tính: id String, eventName String, eventDate String,
 * expectedAttendance int, eventCode String.
 * Trường dữ liệu: private static final long serialVersionUID = 20241131L;
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestObject để nhận đối tượng Event ngẫu nhiên từ
 * server.
 * b. Tạo mã eventCode cho sự kiện:
 * - Nếu expectedAttendance >= 1000, thêm "L"; 500-999 thêm "M"; < 500 thêm "S".
 * - Thêm chữ cái đầu và cuối của eventName, tất cả viết hoa.
 * - Thêm ngày và tháng từ eventDate (theo định dạng "ddMM").
 * Ví dụ: "Charity Run", ngày "2024-05-12", 1200 người → eventCode "LCR1205".
 * c. Cập nhật giá trị eventCode trong đối tượng Event.
 * d. Triệu gọi phương thức submitObject để gửi đối tượng Event đã được xử lý
 * trở lại server.
 */
