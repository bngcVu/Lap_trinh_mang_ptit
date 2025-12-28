package WebService;

import vn.medianews.*;
import java.util.*;

public class DecToBin {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "2jS1DTpU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<String> ans = new java.util.ArrayList<>();
        for (int x : a)
            ans.add(Integer.toBinaryString(x));
        System.out.println(ans);
        port.submitDataStringArray(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 23. CHUYỂN ĐỔI THẬP PHÂN SANG NHỊ PHÂN
 * [Mã câu hỏi (qCode): 2jS1DTpU]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên
 * (List<Integer>) từ server.
 * b. Chuyển đổi số nguyên nhận được từ hệ thập phân sang hệ nhị phân và biểu
 * diễn kết quả dưới dạng chuỗi nhị phân.
 * c. Triệu gọi phương thức submitDataStringArray để gửi chuỗi nhị phân đã
 * chuyển đổi trở lại server.
 * Ví dụ: 10 → "1010"
 * d. Kết thúc chương trình client.
 */
