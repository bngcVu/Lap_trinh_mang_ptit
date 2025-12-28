package RMI.RMI;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SapXepChanLe {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "A7hytb1V");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println("");
        byte[] res = new byte[a.length];
        int idx = 0;
        for (byte x : a) {
            if (x % 2 == 0)
                res[idx++] = x;
        }
        for (byte x : a) {
            if (x % 2 == 1)
                res[idx++] = x;
        }
        for (byte x : res)
            System.out.print(x + " ");
        sv.submitData("B22DCCN634", "A7hytb1V", res);
    }
}
/*
 * ##### BÀI 22. [Byte] SẮP XẾP CHẴN LẺ
 * [Mã câu hỏi (qCode): A7hytb1V]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa ByteService: requestData, submitData.
 * Interface ByteService được viết trong package RMI.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân
 * (byte[]) từ server.
 * b. Thực hiện phân chia mảng byte[] thành hai phần: phần đầu chứa các byte có
 * giá trị chẵn và phần sau chứa các byte có giá trị lẻ, duy trì thứ tự xuất
 * hiện của các phần tử trong từng nhóm.
 * Ví dụ: mảng [1, 2, 3, 4, 5] → sau phân chia chẵn-lẻ: [2, 4, 1, 3, 5]
 * c. Triệu gọi phương thức submitData để gửi mảng byte[] đã được phân chia
 * chẵn-lẻ trở lại server.
 * d. Kết thúc chương trình client.
 */
