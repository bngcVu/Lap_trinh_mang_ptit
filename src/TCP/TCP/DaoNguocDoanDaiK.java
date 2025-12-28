package TCP.TCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class DaoNguocDoanDaiK {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B22DCCN634;dCNDHojG";
        out.writeUTF(code);
        out.flush();
        int k = in.readInt(); System.out.println(k);
        String s = in.readUTF(); System.out.println(s);
        ArrayList<Integer>a = new ArrayList<>();
        String []tmp = s.trim().split(",");
        for(String x: tmp) a.add(Integer.parseInt(x.trim()));
        ArrayList<Integer>res = new ArrayList<>();
        int n = a.size();
        for(int i = 0;i<n;i+=k){
            int j = Math.min(i + k - 1, n - 1);
            for(int o = j; o >= i; o--) res.add(a.get(o)); 
        }
        String ans = "";
        for(int i = 0;i<n;i++){
            ans+=String.format("%d", res.get(i));
            if(i!=n-1) ans+=",";
        }
        System.out.println(ans);
        out.writeUTF(ans);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
/*
##### BÀI 2. ĐẢO NGƯỢC ĐOẠN DÀI K
[Mã câu hỏi (qCode): dCNDHojG].  Một chương trình server cho phép kết nối qua TCP tại cổng 2207 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu xây dựng chương trình client thực hiện giao tiếp với server sử dụng luồng data (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B10DCCN003;C6D7E8F9"

b. Nhận lần lượt:
•	Một số nguyên k là độ dài đoạn.
•	Chuỗi chứa mảng số nguyên, các phần tử được phân tách bởi dấu phẩy ",".
Ví dụ: Nhận k = 3 và "1,2,3,4,5,6,7,8".

c. Thực hiện chia mảng thành các đoạn có độ dài k và đảo ngược mỗi đoạn, sau đó gửi mảng đã xử lý lên server. Ví dụ: Với k = 3 và mảng "1,2,3,4,5,6,7,8", kết quả là "3,2,1,6,5,4,8,7". Gửi chuỗi kết quả "3,2,1,6,5,4,8,7" lên server.

d. Đóng kết nối và kết thúc chương trình
*/