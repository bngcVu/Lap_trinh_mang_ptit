package RMI.RMI;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

public class GiaiMaBase64 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "oeJljCIf");
        String s = new String(a);
        System.out.println(s);
        byte[] ans = Base64.getDecoder().decode(s);
        for (byte x : ans)
            System.out.print(x + " ");
        System.out.println();
        sv.submitData("B22DCCN634", "oeJljCIf", ans);
    }
}
/*
 * ##### [Byte] GIẢI MÃ Base64
 * [Mã câu hỏi (qCode): oeJljCIf]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa ByteService: requestData, submitData.
 * Interface ByteService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân
 * (byte[]) từ server, đại diện cho chuỗi đã mã hóa Base64.
 * b. Thực hiện giải mã Base64 cho chuỗi đầu vào.
 * Ví dụ: Chuỗi "SEVMTE8=" → Giải mã thành "HELLO"
 * c. Triệu gọi phương thức submitData để gửi mảng byte[] đã giải mã trở lại
 * server.
 * d. Kết thúc chương trình client.
 */
