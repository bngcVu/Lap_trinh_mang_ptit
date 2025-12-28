package WebService;

import vn.medianews.*;
import java.util.*;

public class TimSoLonNhat {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "RiRH8wfk";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        List<String> a1 = new java.util.ArrayList<>();
        for (int x : a)
            a1.add(x + "");
        Collections.sort(a1);
        String ans = "";
        for (String x : a1)
            ans += x + ans;
        port.submitDataString(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 13. TÌM SỐ LỚN NHẤT
 * [Mã câu hỏi (qCode): RiRH8wfk]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên (int[]) từ
 * server.
 * Ví dụ:
 * 7602,9136,1090,34319,7830,6179,10584,20166,28199,30250,32179,22544,3222,10320
 * ,30590,19279
 * b. Thực hiện tìm số lớn nhất có thể tạo được từ a,b,c,d...
 * c. Triệu gọi phương thức submitDataString để gửi kết quả tổng đã tính được
 * trở lại server.
 * Ví dụ:
 * 91367830760261793431932223217930590302502819922544201661927910901058410320
 * d. Kết thúc chương trình client.
 */
