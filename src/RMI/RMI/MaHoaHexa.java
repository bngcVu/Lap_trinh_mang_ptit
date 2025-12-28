package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ByteService;

public class MaHoaHexa {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "pK0IZNnt");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println();
        String res = "";
        for (byte x : a)
            res += String.format("%02x", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B22DCCN634", "pK0IZNnt", ans);
    }
}
/*
 * ##### BÀI 26. [Byte] MÃ HOÁ HEXA
 * [Mã câu hỏi (qCode): pK0IZNnt]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa ByteService: requestData, submitData.
 * Interface ByteService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân
 * (byte[]) từ server.
 * b. Chuyển đổi mảng dữ liệu nhị phân thành một chuỗi biểu diễn hex. Mỗi byte
 * sẽ được chuyển thành hai ký tự hex tương ứng.
 * Ví dụ: mảng [72, 101, 108, 108, 111] → chuỗi hex "48656c6c6f" (tương ứng
 * "Hello" trong ASCII).
 * c. Triệu gọi phương thức submitData để gửi chuỗi biểu diễn hex đã chuyển đổi
 * thành mảng byte trở lại server.
 * d. Kết thúc chương trình client.
 */
