package WebService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import vn.medianews.*;
import java.util.*;

public class QuanLyDuAn {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "R6UOuyyE";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Project> a = (List<Project>) port.requestListProject(msv, qCode);
        for (Project p : a)
            System.out.println(p);
        System.out.println();
        List<Project> send = new java.util.ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Project x : a) {
            String t = x.getDueDate().toString();
            t = t.substring(0, 10);
            LocalDate future = LocalDate.parse(t);
            long ngay = ChronoUnit.DAYS.between(today, future);
            if (ngay <= 15 && ngay >= 0 && x.getCompletionPercentage() >= 80.00)
                send.add(x);
        }
        port.submitListProject(msv, qCode, send);
        for (Project p : send)
            System.out.println(p);
    }
}
/*
 * ##### BÀI 17. BÀI TOÁN QUẢN LÝ DỰ ÁN
 * [Mã câu hỏi (qCode): R6UOuyyE]. Một dịch vụ web ObjectService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestListProject với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng
 * Project từ server.
 * • projectId: kiểu String, đại diện cho mã dự án.
 * • projectName: kiểu String, đại diện cho tên dự án.
 * • completionPercentage: kiểu float, đại diện cho tỷ lệ hoàn thành của dự án
 * (tính theo %).
 * • dueDate: kiểu Date, đại diện cho hạn hoàn thành của dự án.
 * b. Lọc và giữ lại các dự án có completionPercentage từ 80% trở lên và có hạn
 * hoàn thành (dueDate) trong vòng 15 ngày tới (tính từ ngày hiện tại).
 * c. Triệu gọi phương thức submitListProject để gửi danh sách các dự án gần
 * hoàn thành và cần ưu tiên trở lại server.
 * d. Kết thúc chương trình client.
 */
