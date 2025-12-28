package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ByteService;

public class ChuyenDoiBatPhan {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "HhPAxeDw");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println();
        String res = "";
        for (byte x : a)
            res += String.format("%03o", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B22DCCN634", "HhPAxeDw", ans);
    }
}
/*
 * ##### BÀI 11. [Byte] CHUYỂN ĐỔI HỆ BÁT PHÂN
 * [Mã câu hỏi (qCode): HhPAxeDw]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa ByteService: requestData, submitData.
 * Interface ByteService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân
 * (byte[]) từ server.
 * b. Chuyển đổi mỗi byte trong mảng dữ liệu thành chuỗi biểu diễn số bát phân
 * (octal). Mỗi byte sẽ được chuyển thành chuỗi số bát phân gồm ba chữ số.
 * Ví dụ: mảng [72, 101, 108] → 72="110", 101="145", 108="154" → chuỗi octal
 * "110145154".
 * Chuyển chuỗi bát phân này trở lại thành mảng byte[] để gửi về server.
 * c. Triệu gọi phương thức submitData để gửi mảng byte[] chứa chuỗi bát phân
 * trở lại server.
 * d. Kết thúc chương trình client.
 */
