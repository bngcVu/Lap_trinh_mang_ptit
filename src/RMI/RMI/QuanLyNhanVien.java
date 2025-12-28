package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Employee;

public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Employee employee = (Employee) sv.requestObject("B22DCCN634", "7fSWnlHB");
        System.out.println(employee);
        int tongCS = 0, x = employee.getExperienceYears(), y = employee.getExperienceYears();
        while (x > 0) {
            tongCS += x % 10;
            x /= 10;
        }
        int soUoc = 0;
        for (int i = 1; i <= y; i++) {
            if (y % i == 0)
                soUoc++;
        }
        double factor = (double) (employee.getExperienceYears() + tongCS + soUoc) / 100.0;
        double Final = (employee.getBaseSalary()) * (1 + factor);
        employee.setFinalSalary(Final);
        System.out.println(employee);
        sv.submitObject("B22DCCN634", "7fSWnlHB", employee);
    }
}
/*
 * ##### BÀI 28. [Object] BÀI TOÁN QUẢN LÝ NHÂN VIÊN
 * [Mã câu hỏi (qCode): 7fSWnlHB]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý thông tin nhân viên.
 * Lớp Employee gồm các thuộc tính: id String, name String, baseSalary double,
 * experienceYears int, finalSalary double.
 * Trường dữ liệu: private static final long serialVersionUID = 20241119L;
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestObject để nhận đối tượng Employee ngẫu nhiên
 * từ server.
 * b. Tính toán finalSalary dựa trên baseSalary và experienceYears:
 * - Tách experienceYears thành tổng các chữ số (ví dụ: 14 → 1+4=5)
 * - Tính số lượng ước số nguyên của experienceYears (ví dụ: 12 có 6 ước số:
 * 1,2,3,4,6,12)
 * - factor = (Số năm làm việc + tổng các chữ số + số lượng ước số) / 100.0
 * - finalSalary = baseSalary * (1 + factor)
 * c. Cập nhật giá trị finalSalary trong đối tượng Employee.
 * d. Triệu gọi phương thức submitObject để gửi đối tượng Employee đã được xử lý
 * trở lại server.
 */
