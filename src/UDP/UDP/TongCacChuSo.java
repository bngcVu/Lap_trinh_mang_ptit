package UDP.UDP;

import java.net.*;

public class TongCacChuSo {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        String code = ";B22DCCN634;0Iend7Pp";
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
        int tong = 0;
        for (char x : s.toCharArray())
            tong += (x - '0');
        String res = String.format("%s;%d", rI, tong);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
 * ##### BÀI 21. TỔNG CÁC CHỮ SỐ
 * [Mã câu hỏi (qCode): 0Iend7Pp]. Một chương trình server cho phép giao tiếp
 * qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng chương trình client trao
 * đổi thông tin với server theo kịch bản:
 * 
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * 
 * b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;num",
 * với:
 * - requestId là chuỗi ngẫu nhiên duy nhất.
 * - num là một số nguyên lớn.
 * 
 * c. Tính tổng các chữ số trong num và gửi lại tổng này về server theo định
 * dạng "requestId;sumDigits".
 * 
 * d. Đóng socket và kết thúc chương trình.
 */
