package UDP.UDP;

import java.net.*;

public class HieuHaiTapTu {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        String code = ";B22DCCN634;JQCO3izC";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String[] sTmp = st.trim().split(";");
        String rI = sTmp[0];
        String s1 = sTmp[1], s2 = sTmp[2];
        String ans = "";
        int[] cnt = new int[10005];
        for (char x : s2.toCharArray())
            cnt[x]++;
        for (char x : s1.toCharArray()) {
            if (cnt[x] == 0)
                ans += x;
        }
        System.out.println(ans);
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
 * ##### BÀI 20. HIỆU CỦA HAI TẬP KÝ TỰ
 * [Mã câu hỏi (qCode): JQCO3izC]. Loại bỏ ký tự đặc biệt và ký tự trùng giữ
 * nguyên thứ tự xuất hiện.
 * Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208. Yêu
 * cầu là xây dựng một chương trình client trao đổi thông tin với server theo
 * kịch bản:
 * 
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * 
 * b. Nhận thông điệp là một chuỗi từ server theo định dạng
 * "requestId;str1;str2".
 * • requestId là chuỗi ngẫu nhiên duy nhất
 * • str1, str2 lần lượt là chuỗi thứ nhất và chuỗi thứ hai
 * 
 * c. Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai,
 * giữ nguyên thứ tự xuất hiện.
 * Gửi thông điệp là một chuỗi lên server theo định dạng "requestId;strOutput".
 * 
 * d. Đóng socket và kết thúc chương trình.
 */
