package WebService;

import vn.medianews.*;
import java.util.*;

public class QuanLyKhachHang1 {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "lgKj7lIF";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Customer> a = (List<Customer>) port.requestListCustomer(msv, qCode);
        for (Customer x : a)
            System.out.println(x);
        List<Customer> ans = new java.util.ArrayList<>();
        for (Customer x : a) {
            if (x.getTotalSpent() > 5000 && x.getPurchaseCount() >= 5)
                ans.add(x);
        }
        System.out.println();
        for (Customer x : ans)
            System.out.println(x);
        port.submitListCustomer(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 21. BÀI TOÁN QUẢN LÝ KHÁCH HÀNG - 2
 * [Mã câu hỏi (qCode): lgKj7lIF]. Một dịch vụ web ObjectService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestListCustomer với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng
 * Customer từ server.
 * • customerId: kiểu String, đại diện cho mã khách hàng.
 * • location: kiểu String, đại diện cho địa điểm của khách hàng.
 * • purchaseCount: kiểu int, đại diện cho số lần mua hàng của khách hàng.
 * • totalSpent: kiểu float, đại diện cho tổng số tiền đã chi tiêu của khách
 * hàng.
 * b. Lọc và giữ lại các khách hàng tại từng địa điểm (location) có totalSpent
 * lớn hơn 5000 và có purchaseCount từ 5 trở lên.
 * c. Triệu gọi phương thức submitListCustomer để gửi danh sách các khách hàng
 * tiềm năng theo từng địa điểm trở lại server.
 * d. Kết thúc chương trình client.
 */
