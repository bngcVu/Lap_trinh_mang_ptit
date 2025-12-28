package WebService;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import vn.medianews.*;

public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "aYiLQ3wo";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<CustomerY> cus = (List<CustomerY>) port.requestListCustomerY(msv, qCode);
        for (CustomerY x : cus)
            System.out.println(x);
        System.out.println();
        LocalDate today = LocalDate.now();
        List<CustomerY> ans = new ArrayList<>();
        for (CustomerY x : cus) {
            String t = x.getLastTransactionDate().toString();
            t = t.substring(0, 10);
            LocalDate old = LocalDate.parse(t);
            long thang = ChronoUnit.MONTHS.between(old, today);
            if (thang >= 6)
                ans.add(x);
        }
        for (CustomerY x : ans)
            System.out.println(x);
        port.submitListCustomerY(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 12. BÀI TOÁN QUẢN LÝ KHÁCH HÀNG
 * [Mã câu hỏi (qCode): aYiLQ3wo]. Một dịch vụ web ObjectService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestListCustomerY với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng
 * CustomerY từ server.
 * • customerId: kiểu String, đại diện cho mã khách hàng.
 * • lastTransactionDate: kiểu Date, đại diện cho ngày giao dịch gần nhất của
 * khách hàng.
 * b. Lọc và giữ lại các khách hàng chưa có giao dịch nào trong vòng 6 tháng qua
 * (so với ngày hiện tại).
 * c. Triệu gọi phương thức submitListCustomerY để gửi danh sách các khách hàng
 * không hoạt động trong 6 tháng trở lại server.
 * d. Kết thúc chương trình client.
 */
