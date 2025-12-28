package WebService;

import vn.medianews.*;
import java.util.*;

public class DonHang2 {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "CuW1L0ev";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Order> a = (List<Order>) port.requestListOrder(msv, qCode);
        for (Order x : a)
            System.out.println(x);
        HashMap<String, Float> mp = new HashMap<>();
        for (Order x : a) {
            String maKH = x.getCustomerId();
            float giaTri = x.getAmount();
            if (!mp.containsKey(maKH))
                mp.put(maKH, giaTri);
            else
                mp.put(maKH, mp.get(maKH) + giaTri);
        }
        float maxGiaTri = 0;
        String maKHmax = "";
        for (String maKH : mp.keySet()) {
            float giaTri = mp.get(maKH);
            if (giaTri > maxGiaTri) {
                maxGiaTri = giaTri;
                maKHmax = maKH;
            }
        }
        List<Order> ans = new java.util.ArrayList<>();
        for (Order x : a) {
            if (x.getCustomerId().equals(maKHmax))
                ans.add(x);
        }
        port.submitListOrder(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 24. BÀI TOÁN QUẢN LÝ ĐƠN HÀNG - 2
 * [Mã câu hỏi (qCode): CuW1L0ev]. Một dịch vụ web ObjectService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestListOrder với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng Order từ
 * server.
 * • customerId: kiểu String, đại diện cho mã khách hàng.
 * • amount: kiểu float, đại diện cho giá trị của đơn hàng.
 * • status: kiểu String, đại diện cho trạng thái của đơn hàng.
 * b. Thực hiện lọc và chỉ giữ lại các hóa đơn của khách hàng có tổng giá trị
 * đơn hàng cao nhất
 * c. Triệu gọi phương thức submitListOrder để gửi danh sách hóa đơn của khách
 * hàng có tổng giá trị đơn hàng cao nhất.
 * d. Kết thúc chương trình client.
 */
