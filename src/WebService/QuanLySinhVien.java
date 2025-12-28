package WebService;

import vn.medianews.*;
import java.util.*;

public class QuanLySinhVien {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "2RjVBzv0";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<StudentY> a = (List<StudentY>) port.requestListStudentY(msv, qCode);
        for (StudentY x : a)
            System.out.println(x);
        System.out.println();
        Map<String, Float> hsg = new HashMap<>();
        for (StudentY x : a) {
            String mon = x.getSubject();
            Float diemMon = x.getScore();
            if ((!hsg.containsKey(mon)) || (diemMon > hsg.get(mon)))
                hsg.put(mon, diemMon);
        }
        List<Float> diemMax = new java.util.ArrayList<>(hsg.values());
        List<StudentY> ans = new java.util.ArrayList<>();
        for (StudentY x : a) {
            if (diemMax.contains(x.getScore()))
                ans.add(x);
        }
        port.submitListStudentY(msv, qCode, ans);
    }
}
/*
 * ##### BÀI 3. BÀI TOÁN QUẢN LÝ SINH VIÊN
 * [Mã câu hỏi (qCode): 2RjVBzv0]. Một dịch vụ web ObjectService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestListStudentY với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng
 * StudentY từ server.
 * • studentId: kiểu String, đại diện cho mã sinh viên.
 * • name: kiểu String, đại diện cho tên sinh viên.
 * • subject: kiểu String, đại diện cho tên môn học.
 * • score: kiểu float, đại diện cho điểm số của sinh viên trong môn học.
 * b. Thực hiện: Lọc và giữ lại sinh viên có điểm số cao nhất theo từng môn học
 * c. Triệu gọi phương thức submitListStudentY để gửi danh sách sinh viên đạt
 * điểm cao nhất theo từng môn học trở lại server.
 * d. Kết thúc chương trình client.
 */
