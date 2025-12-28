package RMI.RMI;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MaHoaCaesar2 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "i0EVI2TB");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println("");
        int doDich = a.length;
        for (int i = 0; i < a.length; i++)
            a[i] += doDich;
        for (byte x : a)
            System.out.print(x + " ");
        sv.submitData("B22DCCN634", "i0EVI2TB", a);
    }
}
/*
 * ##### BÀI 21. [Byte] MÃ HOÁ CAESAR – 2
 * [Mã câu hỏi (qCode): i0EVI2TB]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa ByteService: requestData, submitData.
 * Interface ByteService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân
 * (byte[]) từ server, đại diện cho một chuỗi văn bản ASCII.
 * b. Thực hiện mã hóa Caesar cho mảng dữ liệu nhị phân bằng cách dịch chuyển
 * mỗi byte trong mảng đi một số bước cố định trong bảng mã ASCII.
 * Số bước dịch chuyển là số ký tự ASCII trong mảng dữ liệu.
 * Ví dụ: mảng [72, 101, 108, 108, 111] ("Hello"), độ dịch 5 → kết quả [77, 105,
 * 113, 113, 116] ("Mlqqt").
 * c. Triệu gọi phương thức submitData để gửi mảng dữ liệu đã được mã hóa trở
 * lại server.
 * d. Kết thúc chương trình client.
 */
