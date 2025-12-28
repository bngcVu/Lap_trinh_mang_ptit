package WebService;

import vn.medianews.*;
import java.util.*;

public class QuanLySanPham {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "itT8hvxF";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        ProductY product = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(product);
        float price = product.getPrice(), taxRate = product.getTaxRate(), discount = product.getDiscount();
        float finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100);
        product.setFinalPrice(finalPrice);
        System.out.println(product);
        port.submitProductY(msv, qCode, product);
    }
}
/*
 * ##### BÀI 5. BÀI TOÁN QUẢN LÝ SẢN PHẨM
 * [Mã câu hỏi (qCode): itT8hvxF]. Một dịch vụ web ObjectService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestProductY với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một đối tượng ProductY từ
 * server.
 * • price (giá gốc): float, đại diện cho giá của sản phẩm.
 * • taxRate (thuế): float, đại diện cho phần trăm thuế áp dụng trên giá gốc.
 * • discount (chiết khấu): float, đại diện cho phần trăm chiết khấu áp dụng
 * trên giá gốc.
 * b. Tính toán giá cuối cùng của sản phẩm (finalPrice) theo công thức:
 * finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100)
 * c. Triệu gọi phương thức submitProductY để gửi đối tượng ProductY với giá
 * cuối cùng đã được tính toán trở lại server.
 * Ví dụ: price = 100.0, taxRate = 10.0, discount = 5.0 → finalPrice = 104.5
 * d. Kết thúc chương trình client.
 */
