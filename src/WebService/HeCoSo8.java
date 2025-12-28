package WebService;

import vn.medianews.*;
import java.util.*;

public class HeCoSo8 {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "QBDJ1GGL";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<String> res = new java.util.ArrayList<>();
        for (int n : a) {
            String oct = Integer.toOctalString(n), hex = Integer.toHexString(n).toUpperCase();
            String tmp = oct + "|" + hex;
            res.add(tmp);
        }
        System.out.println(res);
        port.submitDataStringArray(msv, qCode, res);
    }
}
/*
 * ##### BÀI 25. HỆ CƠ SỐ 8 VÀ 16
 * [Mã câu hỏi (qCode): QBDJ1GGL]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên
 * (List<Integer>) từ server.
 * b. Chuyển đổi số nguyên nhận được từ hệ thập phân sang cả hệ cơ số 8 (bát
 * phân) và hệ cơ số 16 (thập lục phân).
 * c. Triệu gọi phương thức submitDataStringArray để gửi danh sách chuỗi kết
 * quả.
 * Ví dụ: 64 → "100|40"
 * Chú ý: Hệ hexa phải viết hoa.
 * d. Kết thúc chương trình client.
 */
