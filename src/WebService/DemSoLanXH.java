package WebService;

import vn.medianews.*;
import java.util.*;

public class DemSoLanXH {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "TU4ULIgh";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        Collections.sort(a);
        System.out.println(a);
        int[] cnt = new int[10005];
        for (int x : a)
            cnt[x]++;
        List<String> ans = new java.util.ArrayList<>();
        for (int x : a) {
            if (cnt[x] > 0) {
                String tmp = String.format("%d, %d", x, cnt[x]);
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        for (String x : ans) {
            System.out.println(x);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 4. ĐẾM SỐ LẦN XUẤT HIỆN
 * [Mã câu hỏi (qCode): TU4ULIgh]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên
 * (List<Integer>) từ server.
 * b. Với mảng số nguyên nhận được, thực hiện đếm số lần xuất hiện của từng phần
 * tử trong mảng và lưu kết quả vào một chuỗi theo định dạng: giá trị của phần
 * tử, số lần xuất hiện tương ứng của nó.
 * c. Triệu gọi phương thức submitDataStringArray để gửi danh sách chuỗi kết quả
 * chứa cặp giá trị [phần tử, tần suất] của từng phần tử đã tính được trở lại
 * server.
 * Ví dụ: [1, 2, 2, 3, 3, 3] → ["1, 1", "2, 2", "3, 3"]
 * Chú ý: Sắp xếp dãy tăng dần trước khi đếm.
 * d. Kết thúc chương trình client.
 */
