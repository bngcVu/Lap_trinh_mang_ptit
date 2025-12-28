package UDP.UDP;

import java.net.*;

public class ChuanHoaXauKyTu {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        String code = ";B22DCCN634;NRVwBVvx";
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
        String[] tmpS = s.trim().split("\\s+");
        s = "";
        for (String x : tmpS)
            s += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        String res = rI + ";" + s;
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
 * ##### BÀI 19. CHUẨN HOÁ XÂU KÝ TỰ
 * [Mã câu hỏi (qCode): NRVwBVvx]. Một chương trình server cho phép kết nối qua
 * giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao
 * đổi thông tin với server theo kịch bản:
 * 
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * 
 * b. Nhận thông điệp từ server theo định dạng "requestId;data"
 * - requestId là một chuỗi ngẫu nhiên duy nhất
 * - data là chuỗi dữ liệu cần xử lý
 * 
 * c. Xử lý chuẩn hóa chuỗi đã nhận theo nguyên tắc:
 * i. Ký tự đầu tiên của từng từ trong chuỗi là in hoa
 * ii. Các ký tự còn lại của chuỗi là in thường
 * Gửi thông điệp chứa chuỗi đã được chuẩn hóa lên server theo định dạng
 * "requestId;data"
 * 
 * d. Đóng socket và kết thúc chương trình
 */
