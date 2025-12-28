package WebService;

import vn.medianews.*;
import java.util.*;

public class ChuanHoaChuoi {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "sBQjqANT";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        s = s.replace('_', ' ');
        String[] tmp = s.trim().split("\\s+");
        String p = "", c = tmp[0].toLowerCase(), sn = "";
        for (String x : tmp)
            p += chuanhoa(x);
        for (int i = 1; i < tmp.length; i++)
            c += chuanhoa(tmp[i]);
        for (String x : tmp)
            sn += x.toLowerCase() + "_";
        sn = sn.substring(0, sn.length() - 1);
        List<String> ans = new java.util.ArrayList<>();
        ans.add(p);
        ans.add(c);
        ans.add(sn);
        System.out.println(ans);
        port.submitCharacterStringArray(msv, qCode, ans);
    }

    public static String chuanhoa(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}
/*
 * ##### BÀI 14. CHUẨN HOÁ CHUỖI
 * [Mã câu hỏi (qCode): sBQjqANT]. Một dịch vụ web CharacterService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên
 * (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server.
 * b. Chuyển đổi chuỗi đã nhận được sang ba định dạng khác nhau:
 * • PascalCase: Mỗi từ bắt đầu bằng chữ in hoa, không có khoảng cách giữa các
 * từ.
 * • camelCase: Từ đầu tiên viết thường, các từ tiếp theo viết hoa chữ cái đầu
 * và viết liền nhau.
 * • snake_case: Các từ được viết thường và nối với nhau bằng dấu gạch dưới.
 * c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng kết quả theo
 * thứ tự: PascalCase, camelCase, snake_case.
 * Ví dụ: "hello world example" → ["HelloWorldExample", "helloWorldExample",
 * "hello_world_example"]
 * d. Kết thúc chương trình client.
 */
