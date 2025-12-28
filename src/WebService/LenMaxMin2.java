package WebService;

import vn.medianews.*;
import java.util.*;

public class LenMaxMin2 {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "sGJc3iD5";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        String Max = a.get(0), Min = a.get(0);
        for (String x : a) {
            if (x.length() > Max.length())
                Max = x;
            if (x.length() < Min.length())
                Min = x;
        }
        String ans = Max + ";" + Min;
        port.submitCharacterString(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 18. TỪ DÀI NHẤT VÀ TỪ NGẮN NHẤT – 2
 * [Mã câu hỏi (qCode): sGJc3iD5]. Một dịch vụ web CharacterService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách chuỗi
 * (List<String>) từ server.
 * b. Xác định từ có độ dài lớn nhất và từ có độ dài nhỏ nhất trong mảng chuỗi.
 * Nếu có nhiều từ có cùng độ dài lớn nhất hoặc nhỏ nhất, chọn từ xuất hiện đầu
 * tiên trong mảng.
 * c. Tạo một chuỗi mới theo định dạng: "Longest;Shortest".
 * d. Triệu gọi phương thức submitCharacterString để gửi chuỗi kết quả đã xử lý
 * trở lại server.
 * Ví dụ: ["apple", "banana", "fig", "pineapple"] → "pineapple;fig"
 * e. Kết thúc chương trình client.
 */
