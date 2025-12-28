package WebService;

import vn.medianews.*;
import java.util.*;

public class TongCacSo {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "hnVAHv3I";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        int tong = 0;
        for (int x : a)
            tong += x;
        System.out.println(tong);
        port.submitDataInt(msv, qCode, tong);
    }
}
/*
 * ##### BÀI 27. TỔNG CÁC SỐ TRONG MẢNG
 * [Mã câu hỏi (qCode): hnVAHv3I]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên
 * (List<Integer>) từ server.
 * b. Thực hiện tính toán tổng của tất cả các phần tử trong mảng số nguyên nhận
 * được.
 * c. Triệu gọi phương thức submitDataInt để gửi kết quả tổng đã tính được trở
 * lại server.
 * Ví dụ: [1, 2, 3, 4, 5] → 15
 * d. Kết thúc chương trình client.
 */
