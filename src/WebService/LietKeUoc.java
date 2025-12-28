package WebService;

import vn.medianews.*;
import java.util.*;

public class LietKeUoc {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "nhFjYg0F";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        int n = (int) port.getDataDouble(msv, qCode);
        System.out.println(n);
        List<Integer> ans = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                ans.add(i);
        }
        ans.add(0, ans.size());
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 9. LIỆT KÊ CÁC ƯỚC SỐ CỦA MỘT SỐ TỰ NHIÊN
 * [Mã câu hỏi (qCode): nhFjYg0F]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getDataDouble với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một số thập phân (double) từ
 * server.
 * b. Lấy phần nguyên của số thập phân nhận được. Liệt kê tất cả các ước số của
 * phần nguyên này và đếm số lượng ước số. Kết quả sẽ là một danh sách số
 * nguyên, trong đó phần tử đầu tiên là số lượng ước số và các phần tử tiếp theo
 * là các ước số theo thứ tự tăng dần.
 * c. Triệu gọi phương thức submitDataIntArray để gửi mảng kết quả chứa số lượng
 * ước số và danh sách các ước trở lại server.
 * Ví dụ: 12.6758 → [6, 1, 2, 3, 4, 6, 12]
 * d. Kết thúc chương trình client.
 */
