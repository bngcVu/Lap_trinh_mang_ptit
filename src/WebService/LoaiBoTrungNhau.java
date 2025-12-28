package WebService;

import vn.medianews.*;
import java.util.*;

public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "E2Axwwf3";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        int[] cnt = new int[10005];
        for (int x : a)
            cnt[x]++;
        List<Integer> ans = new java.util.ArrayList<>();
        for (int x : a) {
            if (cnt[x] > 0) {
                ans.add(x);
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 26. LOẠI BỎ SỐ TRÙNG NHAU
 * [Mã câu hỏi (qCode): E2Axwwf3]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên
 * (List<Integer>) từ server.
 * b. Với mảng số nguyên nhận được, xóa tất cả các phần tử trùng lặp, giữ lại
 * lần xuất hiện đầu tiên của mỗi phần tử.
 * c. Triệu gọi phương thức submitDataIntArray để gửi mảng kết quả đã loại bỏ
 * các phần tử trùng lặp trở lại server.
 * Ví dụ: [1, 2, 2, 3, 4, 3, 5] → [1, 2, 3, 4, 5]
 * d. Kết thúc chương trình client.
 */
