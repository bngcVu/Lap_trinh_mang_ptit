package WebService;

import vn.medianews.*;
import java.util.*;

public class SXTheoLen {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "mpu9xCxR";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
}
/*
 * ##### BÀI 7. SẮP XẾP CHUỖI THEO ĐỘ DÀI CHUỖI
 * [Mã câu hỏi (qCode): mpu9xCxR]. Một dịch vụ web CharacterService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng chuỗi
 * (List<String>) từ server.
 * b. Sắp xếp mảng theo độ dài của từ theo thứ tự tăng dần độ dài của từ.
 * c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng chuỗi đã sắp
 * xếp trở lại server.
 * Ví dụ: ["apple", "banana", "fig", "pineapple"] → ["fig", "apple", "banana",
 * "pineapple"]
 * d. Kết thúc chương trình client.
 */