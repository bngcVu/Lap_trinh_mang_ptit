package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;

public class XuLyVanBan {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B22DCCN634", "NFldNPp6");
        System.out.println(s);
        s = s.replace("\"", "");
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] tmp = s.trim().split(",");
        String chan = "", le = "";
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = tmp[i].trim();
            if (i % 2 == 0) {
                if (chan.length() > 0)
                    chan += ", ";
                chan += tmp[i];
            } else {
                if (le.length() > 0)
                    le += ", ";
                le += tmp[i];
            }
        }
        String res = chan + "; " + le;
        System.out.println(res);
        sv.submitCharacter("B22DCCN634", "NFldNPp6", res);
    }
}
/*
 * ##### BÀI 2. [Character] XỬ LÝ XÂU KÝ TỰ
 * [Mã câu hỏi (qCode): NFldNPp6]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa để xử lý chuỗi.
 * Giao diện từ xa:
 * public interface CharacterService extends Remote {
 * public String requestCharacter(String studentCode, String qCode) throws
 * RemoteException;
 * public void submitCharacter(String studentCode, String qCode, String
 * strSubmit) throws RemoteException;
 * }
 * Interface CharacterService được viết trong package RMI.
 * Đối tượng cài đặt giao diện từ xa CharacterService được đăng ký với
 * RegistryServer với tên: RMICharacterService.
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestCharacter để nhận chuỗi JSON ngẫu nhiên từ
 * server.
 * b. Phân tích cú pháp chuỗi JSON và trích xuất các cặp key: value dựa trên vị
 * trí:
 * - Các cặp key: value ở vị trí chẵn sẽ được đưa vào chuỗi đầu tiên.
 * - Các cặp key: value ở vị trí lẻ sẽ được đưa vào chuỗi thứ hai.
 * - Hai chuỗi kết quả sẽ được nối với nhau và phân tách bởi dấu ;
 * Ví dụ: {"name": "Alice", "age": 25, "city": "Wonderland", "country":
 * "Fictionland"}
 * → Kết quả: "name: Alice, city: Wonderland; age: 25, country: Fictionland"
 * c. Triệu gọi phương thức submitCharacter để gửi chuỗi kết quả trở lại server.
 * d. Kết thúc chương trình client.
 */
