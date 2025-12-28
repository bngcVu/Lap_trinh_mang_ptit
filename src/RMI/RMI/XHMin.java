package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class XHMin {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "L7A2NPQU");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println("");
        int[] cnt = new int[10005];
        for (byte x : a)
            cnt[x]++;
        byte ptuMin = a[0];
        int slMin = cnt[a[0]];
        for (byte x : a) {
            if (cnt[x] < slMin) {
                ptuMin = x;
                slMin = cnt[x];
            }
        }
        System.out.println(ptuMin + " " + slMin);
        byte[] res = { ptuMin, (byte) slMin };
        sv.submitData("B22DCCN634", "L7A2NPQU", res);
    }
}
/*
 * ##### BÀI 7. [Byte] PHẦN TỬ XUẤT HIỆN ÍT LẦN NHẤT
 * [Mã câu hỏi (qCode): L7A2NPQU]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
 * Giao diện từ xa:
 * public interface ByteService extends Remote {
 * public byte[] requestData(String studentCode, String qCode) throws
 * RemoteException;
 * public void submitData(String studentCode, String qCode, byte[] data) throws
 * RemoteException;
 * }
 * Interface ByteService được viết trong package RMI.
 * Đối tượng cài đặt giao diện từ xa ByteService được đăng ký với RegistryServer
 * với tên: RMIByteService.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân
 * (byte[]) từ server.
 * b. Tìm phần tử có số lần xuất hiện ít nhất trong mảng, nếu có nhiều phần tử
 * có cùng số lần xuất hiện ít nhất, chỉ cần trả về phần tử đầu tiên xuất hiện
 * trong các phần tử đó.
 * Ví dụ: Nếu mảng dữ liệu là [1, 2, 3, 2, 1], chương trình sẽ tìm ra phần tử
 * xuất hiện ít nhất là 3.
 * c. Triệu gọi phương thức submitData để gửi mảng byte kết quả chứa phần tử có
 * số lần xuất hiện ít nhất và số lần xuất hiện trở lại server.
 * d. Kết thúc chương trình client.
 */