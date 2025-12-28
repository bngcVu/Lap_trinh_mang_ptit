package WebService;

import vn.medianews.*;
import java.util.*;

public class DaoNguoc {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "rT6Ql5GH";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        String ans = "";
        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x))
                ans = x + ans;
        }
        System.out.println(ans);
        port.submitCharacterString(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 15. LỌC KÝ TỰ
 * [Mã câu hỏi (qCode): rT6Ql5GH]. Một dịch vụ web CharacterService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server.
 * b. Tạo một chuỗi mới từ chuỗi nhận được bằng cách:
 * • Loại bỏ tất cả các ký tự đặc biệt, số, chỉ giữ lại các ký tự chữ cái.
 * • Đảo ngược chuỗi kết quả sau khi đã loại bỏ các ký tự đặc biệt.
 * c. Triệu gọi phương thức submitCharacterString để gửi chuỗi đã được làm sạch
 * và đảo ngược trở lại server.
 * Ví dụ: "hello@ world! 2024" → "helloworld" → "dlrowolleh"
 * d. Kết thúc chương trình client.
 */
