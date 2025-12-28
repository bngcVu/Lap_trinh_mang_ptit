package RMI.RMI;

import RMI.Order;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;

public class TDMT {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Order order = (Order) sv.requestObject("B22DCCN634", "vLJWvWpf");
        System.out.println(order);
        String x = order.getShippingType().substring(0, 2).toUpperCase();
        String y = order.getCustomerCode().substring(order.getCustomerCode().length() - 3);
        String z = order.getOrderDate().substring(8, 10) + order.getOrderDate().substring(5, 7);
        String orderCode = x + y + z;
        order.setOrderCode(orderCode);
        System.out.println(order);
        sv.submitObject("B22DCCN634", "vLJWvWpf", order);
    }
}
/*
 * ##### [Object] TẠO ĐƠN MUA HÀNG
 * [Mã câu hỏi (qCode): vLJWvWpf]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý thông tin đơn hàng.
 * Lớp Order gồm các thuộc tính: id String, customerCode String, orderDate
 * String, shippingType String, orderCode String.
 * Interface ObjectService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestObject để nhận đối tượng Order ngẫu nhiên từ
 * server.
 * b. Tạo mã orderCode cho đơn hàng:
 * - Lấy 2 ký tự đầu của shippingType (viết hoa).
 * - Lấy 3 ký tự cuối của customerCode.
 * - Lấy ngày và tháng từ orderDate ở định dạng ddMM.
 * Ví dụ: shippingType "Express", customerCode "CUS12345", orderDate
 * "2024-05-12" → orderCode "EX3451205".
 * c. Cập nhật giá trị orderCode trong đối tượng Order.
 * d. Triệu gọi phương thức submitObject để gửi đối tượng Order đã được xử lý
 * trở lại server.
 */
