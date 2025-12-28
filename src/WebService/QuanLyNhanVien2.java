package WebService;

import vn.medianews.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class QuanLyNhanVien2 {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "L8CainEX";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        Employee e = port.requestEmployee(msv, qCode);
        System.out.println(e);
        String bd = e.getStartDate().toString(), kt = e.getEndDate().toString();
        bd = bd.substring(0, 10);
        kt = kt.substring(0, 10);
        LocalDate stDay = LocalDate.parse(bd), enDay = LocalDate.parse(kt);
        long tmp = ChronoUnit.DAYS.between(stDay, enDay);
        int cnt = 0;
        for (int i = 0; i <= tmp; i++) {
            LocalDate curDay = stDay.plusDays(i);
            if (curDay.getDayOfWeek().getValue() <= 5)
                cnt++;
        }
        e.setWorkingDays(cnt);
        System.out.println(e);
        port.submitEmployee(msv, qCode, e);
    }
}
/*
 * ##### BÀI 28. BÀI TOÁN QUẢN LÝ NHÂN VIÊN – 2
 * [Mã câu hỏi (qCode): L8CainEX]. Một dịch vụ web ObjectService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestEmployee với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một đối tượng Employee từ
 * server.
 * • startDate: kiểu Date, đại diện cho ngày bắt đầu công việc của nhân viên.
 * • endDate: kiểu Date, đại diện cho ngày kết thúc công việc của nhân viên.
 * b. Tính toán số ngày làm việc (workingDays) giữa startDate và endDate, loại
 * trừ các ngày cuối tuần (thứ Bảy và Chủ Nhật).
 * c. Triệu gọi phương thức submitEmployee để gửi đối tượng Employee với số ngày
 * làm việc đã được tính toán trở lại server.
 * Ví dụ: startDate = 01-09-2023 (thứ Sáu), endDate = 07-09-2023 (thứ Năm) →
 * workingDays = 5
 * d. Kết thúc chương trình client.
 */
