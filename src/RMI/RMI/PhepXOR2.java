package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class PhepXOR2 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "4BraNTI5");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println();
        String tmp = "PTIT";
        byte[] tmpB = tmp.getBytes();
        byte[] maHoa = new byte[a.length];
        for (int i = 0; i < a.length; i++)
            maHoa[i] = (byte) (a[i] ^ tmpB[i % tmpB.length]);
        for (byte x : maHoa)
            System.out.print(x + " ");
        sv.submitData("B22DCCN634", "4BraNTI5", maHoa);
    }
}
/*
 * ##### BÀI 15. [Byte] PHÉP XOR – 2
 * [Mã câu hỏi (qCode): 4BraNTI5]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa ByteService: requestData, submitData.
 * Interface ByteService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân
 * (byte[]) từ server, đại diện cho một chuỗi văn bản ASCII.
 * b. Thực hiện mã hóa XOR với khóa là chuỗi "PTIT". Thực hiện phép XOR trên
 * từng byte trong mảng dữ liệu với byte tương ứng trong khóa (khóa lặp lại để
 * khớp độ dài).
 * Ví dụ: [72, 101, 108, 108, 111] ("Hello") với khóa "PTIT" → kết quả mã hóa
 * [24, 49, 37, 56, 63].
 * c. Triệu gọi phương thức submitData để gửi mảng dữ liệu đã được mã hóa XOR
 * trở lại server.
 * d. Kết thúc chương trình client.
 */
