package WebService;

import vn.medianews.*;
import java.util.*;

public class SapXepChuoi {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "x5TIDg1S";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return dem(s1) - dem(s2);
            }
        });
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }

    private static int dem(String str) {
        int cnt = 0;
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1)
                cnt++;
        }
        return cnt;
    }
}
/*
 * ##### BÀI 2. SẮP XẾP CHUỖI THEO SỐ NGUYÊN ÂM
 * [Mã câu hỏi (qCode): mDN1MFUJ]. Một dịch vụ web CharacterService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng chuỗi
 * (List<String>) từ server.
 * b. Sắp xếp các chuỗi trong mảng theo số lượng nguyên âm tăng dần. Nếu hai
 * chuỗi có cùng số lượng nguyên âm, giữ nguyên thứ tự xuất hiện ban đầu của
 * chúng trong mảng.
 * c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng chuỗi đã sắp
 * xếp trở lại server.
 * Ví dụ: ["apple", "kiwi", "banana", "pear"] → ["apple", "kiwi", "pear",
 * "banana"]
 * d. Kết thúc chương trình client.
 */
