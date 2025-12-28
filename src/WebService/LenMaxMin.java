package WebService;

import vn.medianews.*;
import java.util.*;

public class LenMaxMin {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "9n2rfqST";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        String[] tmp = s.trim().split("\\s+");
        int lenMax = tmp[0].length(), lenMin = tmp[0].length();
        String strMax = tmp[0], strMin = tmp[0];
        for (String x : tmp) {
            if (x.length() < lenMin) {
                strMin = x;
                lenMin = x.length();
            }
            if (x.length() > lenMax) {
                strMax = x;
                lenMax = x.length();
            }
        }
        String ans = strMax + ";" + strMin;
        System.out.println(ans);
        port.submitCharacterString(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 11. TỪ DÀI NHẤT VÀ TỪ NGẮN NHẤT
 * [Mã câu hỏi (qCode): 9n2rfqST]. Một dịch vụ web CharacterService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server.
 * b. Xử lý chuỗi nhận được để tìm từ có độ dài lớn nhất và từ có độ dài nhỏ
 * nhất trong chuỗi. Nếu có nhiều từ có cùng độ dài lớn nhất hoặc nhỏ nhất, chọn
 * từ xuất hiện đầu tiên trong chuỗi.
 * c. Tạo một chuỗi mới theo định dạng: "[từ lớn nhất]; [từ nhỏ nhất]".
 * d. Triệu gọi phương thức submitCharacterString để gửi chuỗi kết quả đã xử lý
 * trở lại server.
 * Ví dụ: "this is a sample test" → "sample; a"
 * e. Kết thúc chương trình client.
 */
