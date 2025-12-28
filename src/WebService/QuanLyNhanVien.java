package WebService;

import vn.medianews.*;
import java.util.*;

public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception {
        String msv = "B22DCCN634", qCode = "vewbvojZ";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<EmployeeY> a = port.requestListEmployeeY(msv, qCode);
        for (EmployeeY x : a)
            System.out.println(x);
        Collections.sort(a, new Comparator<EmployeeY>() {
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        System.out.println();
        for (EmployeeY x : a)
            System.out.println(x);
        port.submitListEmployeeY(msv, qCode, a);
    }
}
/*
 * ##### BÀI 10. BÀI TOÁN QUẢN LÝ NHÂN VIÊN
 * [Mã câu hỏi (qCode): vewbvojZ]. Một dịch vụ web ObjectService.wsdl tại URL
 * http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestListEmployeeY với tham số đầu vào là mã sinh
 * viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách đối tượng
 * EmployeeY từ server.
 * • name: kiểu String, đại diện cho tên của nhân viên.
 * • startDate: kiểu Date, đại diện cho ngày bắt đầu làm việc của nhân viên.
 * b. Sắp xếp danh sách Employee theo thứ tự thâm niên từ cao đến thấp (người có
 * ngày bắt đầu làm việc sớm nhất sẽ đứng đầu danh sách).
 * c. Triệu gọi phương thức submitListEmployeeY để gửi danh sách nhân viên đã
 * sắp xếp trở lại server.
 * d. Kết thúc chương trình client.
 */
