package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;

public class XHMax {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B22DCCN634", "1mPMIkGJ");
        for (byte x : a)
            System.out.print(x + " ");
        System.out.println("");
        int[] cnt = new int[128];
        for (byte x : a)
            cnt[x]++;
        byte ptuMax = a[0];
        int slMax = cnt[ptuMax];
        for (byte x : a) {
            if (cnt[x] > slMax) {
                ptuMax = x;
                slMax = cnt[x];
            }
        }
        System.out.println(ptuMax + " " + slMax);
        byte[] res = { ptuMax, (byte) slMax };
        sv.submitData("B22DCCN634", "1mPMIkGJ", res);
    }
}
/*
 * ##### BÀI 3. [Byte] PHẦN TỬ XUẤT HIỆN NHIỀU LẦN NHẤT
 * [Mã câu hỏi (qCode): 1mPMIkGJ]. Một chương trình RMI Server cung cấp giao
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
 * b. Tìm phần tử xuất hiện nhiều nhất trong mảng byte[]. Nếu có nhiều phần tử
 * có cùng số lần xuất hiện cao nhất, chỉ cần trả về phần tử đầu tiên xuất hiện
 * trong các phần tử đó.
 * Ví dụ: Nếu mảng dữ liệu là [1, 2, 3, 2, 1, 2], phần tử xuất hiện nhiều nhất
 * là 2, với tần suất 3 lần.
 * c. Triệu gọi phương thức submitData để gửi mảng byte chứa phần tử phổ biến
 * nhất và tần suất xuất hiện trở lại server.
 * d. Kết thúc chương trình client.
 */
