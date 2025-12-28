package WebService;

import vn.medianews.*;
import java.util.*;

public class NhomTuTheoNguyenAm {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "32He7sZg";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (dem(s1) != dem(s2))
                    return dem(s1) - dem(s2);
                return s1.compareTo(s2);
            }
        });
        List<String> ans = new java.util.ArrayList<>();
        String gr = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (dem(a.get(i)) == dem(a.get(i - 1)))
                gr += ", " + a.get(i);
            else {
                ans.add(gr);
                gr = a.get(i);
            }
        }
        ans.add(gr);
        port.submitCharacterStringArray(msv, qCode, ans);
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
 * ##### BÀI 20. NHÓM CÁC TỪ THEO CÙNG SỐ NGUYÊN ÂM
 * [Mã câu hỏi (qCode): 32He7sZg]. Một dịch vụ web CharacterService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng chuỗi (String[])
 * từ server.
 * b. Phân loại các từ trong mảng chuỗi thành các nhóm có cùng số lượng nguyên
 * âm. Tạo một chuỗi cho mỗi nhóm, trong đó liệt kê các từ cách nhau bằng dấu
 * phẩy, và sắp xếp các từ theo thứ tự từ điển trong mỗi nhóm.
 * c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng chuỗi kết quả
 * trở lại server.
 * Ví dụ: ["apple", "banana", "pear", "grape", "kiwi"] → ["apple, banana",
 * "grape, kiwi, pear"]
 * Sắp xếp theo nguyên tắc: Số nguyên âm tăng dần theo từng nhóm.
 * d. Kết thúc chương trình client.
 */
