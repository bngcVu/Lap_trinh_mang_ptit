package WebService;

import vn.medianews.*;
import java.util.*;

public class LonNhoThuK {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "WpaUTFMu";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        int k = a.get(0);
        a.remove(0);
        System.out.println(a + " " + k);
        Collections.sort(a);
        int nhoThuK = a.get(k - 1), lonThuK = a.get(a.size() - k);
        List<Integer> ans = new java.util.ArrayList<>(Arrays.asList(lonThuK, nhoThuK));
        port.submitDataIntArray(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 6. PHẦN TỬ LỚN THỨ K VÀ NHỎ THỨ K
 * [Mã câu hỏi (qCode): WpaUTFMu]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên
 * (List<Integer>) từ server. Phần tử đầu tiên của mảng này là giá trị K.
 * b. Với mảng số nguyên nhận được, sử dụng giá trị K (phần tử đầu tiên của
 * mảng) để xác định phần tử lớn thứ K và nhỏ thứ K trong các phần tử còn lại
 * của mảng (loại bỏ phần tử đầu tiên khi tính toán).
 * c. Triệu gọi phương thức submitDataIntArray để gửi mảng kết quả chứa: phần tử
 * lớn thứ K, phần tử nhỏ thứ K đã tìm được trở lại server.
 * Ví dụ: [3, 5, 1, 4, 2] → K=3, kết quả [2, 4]
 * d. Kết thúc chương trình client.
 */
