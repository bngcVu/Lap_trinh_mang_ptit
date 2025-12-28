package WebService;

import vn.medianews.*;
import java.util.*;

public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "YDcPHFgN";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer> a = port.requestCharacter(msv, qCode);
        int timeRot = a.get(0) % (a.size());
        Collections.rotate(a, timeRot);
        port.submitCharacterCharArray(msv, qCode, a);
    }
}
/*
 * ##### BÀI 22. XOAY VÒNG KÝ TỰ
 * [Mã câu hỏi (qCode): YDcPHFgN]. Một dịch vụ web CharacterService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một mảng ký tự
 * (List<Character>) từ server.
 * b. Thực hiện xoay vòng các ký tự trong mảng theo chiều phải, số lần xoay vòng
 * bằng đúng kích thước của mảng ký tự đã nhận được.
 * c. Triệu gọi phương thức submitCharacterCharArray để gửi mảng ký tự đã xoay
 * vòng trở lại server.
 * Ví dụ: ['a', 'b', 'c', 'd'] xoay phải 4 lần → ['b', 'c', 'd', 'a']
 * d. Kết thúc chương trình client.
 */
