package WebService;

import vn.medianews.*;
import java.util.*;

public class PTichTSNT {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "TwZpbqUg";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<String> ans = new java.util.ArrayList<>();
        for (int x : a) {
            String tmp = "";
            for (int i = 2; i * i <= x; i++) {
                while (x % i == 0) {
                    x /= i;
                    tmp += String.format("%d, ", i);
                }
            }
            if (x > 1)
                tmp += String.format("%d, ", x);
            tmp = tmp.trim();
            tmp = tmp.substring(0, tmp.length() - 1);
            ans.add(tmp);
            System.out.println(tmp);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 1. PHÂN TÍCH RA THỪA SỐ NGUYÊN TỐ
 * [Mã câu hỏi (qCode): TwZpbqUg]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên
 * (List<Integer>) từ server.
 * b. Thực hiện phân tích số nguyên nhận được thành các thừa số nguyên tố của nó
 * và lưu các thừa số này vào một chuỗi kết quả.
 * c. Triệu gọi phương thức submitDataStringArray để gửi danh sách chuỗi các
 * thừa số nguyên tố đã tính được trở lại server.
 * Ví dụ: Nếu số nguyên trong danh sách là 28 sẽ phân tích thành các thừa số
 * nguyên tố "2, 2, 7".
 * d. Kết thúc chương trình client.
 */
