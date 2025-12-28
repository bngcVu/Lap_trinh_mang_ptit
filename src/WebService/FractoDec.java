package WebService;

import vn.medianews.*;
import java.util.*;

public class FractoDec {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "ny8Fb8BU";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        double a = port.getDataDouble(msv, qCode);
        a = Math.round(a * 100) / 100.0;
        System.out.println(a);
        int tu, mau = 100;
        tu = (int) (a * 100.0);
        int tmp = gcd(tu, mau);
        tu /= tmp;
        mau /= tmp;
        List<Integer> ans = new java.util.ArrayList<>();
        ans.add(tu);
        ans.add(mau);
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 19. CHUYỂN ĐỔI SỐ THẬP PHÂN SANG PHÂN SỐ
 * [Mã câu hỏi (qCode): ny8Fb8BU]. Một dịch vụ web DataService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/DataService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức getDataDouble với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một số thập phân (double) từ
 * server.
 * b. Chuyển đổi số thập phân nhận được thành phân số đơn giản nhất, biểu diễn
 * dưới dạng tử số và mẫu số nguyên (List<Integer>) với phần tử đầu tiên là tử
 * số và phần tử thứ hai là mẫu số.
 * c. Triệu gọi phương thức submitDataIntArray để gửi phân số đơn giản nhất đã
 * chuyển đổi trở lại server.
 * Ví dụ: 0.75 → [3, 4]
 * d. Kết thúc chương trình client.
 */
