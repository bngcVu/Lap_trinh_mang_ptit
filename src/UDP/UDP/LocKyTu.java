package UDP.UDP;

import java.net.*;

public class LocKyTu {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        String code = ";B22DCCN634;EbTMtFBH";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String[] sTmp = s1.trim().split(";");
        String rI = sTmp[0];
        String s = sTmp[1];
        int[] cnt = new int[10005];
        for (char x : s.toCharArray()) {
            if (Character.isAlphabetic(x))
                cnt[x]++;
        }
        String res = "";
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                res += x;
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
 * ##### BÀI 14. LỌC KÝ TỰ
 * [Mã câu hỏi (qCode): GfeNSBMT]. Loại bỏ ký tự đặc biệt, số, trùng và giữ
 * nguyên thứ tự xuất hiện.
 * Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208. Yêu
 * cầu là xây dựng một chương trình client trao đổi thông tin với server theo
 * kịch bản:
 * 
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * 
 * b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;strInput"
 * • requestId là chuỗi ngẫu nhiên duy nhất
 * • strInput là chuỗi thông điệp cần xử lý
 * 
 * c. Thực hiện loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự
 * xuất hiện của chúng.
 * Gửi thông điệp lên server theo định dạng "requestId;strOutput", trong đó
 * strOutput là chuỗi đã được xử lý.
 * 
 * d. Đóng socket và kết thúc chương trình.
 */
