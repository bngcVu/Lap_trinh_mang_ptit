package UDP.UDP;

import java.net.*;

public class MaHoaCaesar {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        String code = ";B22DCCN634;vNIIU53V";
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
        int doDich = Integer.parseInt(sTmp[2].trim());
        String ans = "";
        for (char x : s.toCharArray()) {
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base + doDich) % 26 + base);
            ans += x;
        }
        ans = rI + ";" + ans;
        System.out.println(ans);
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
 * ##### BÀI 15. MÃ HOÁ CAESAR
 * [Mã câu hỏi (qCode): J5SE2YXc]. Mật mã caesar, còn gọi là mật mã dịch chuyển,
 * để giải mã thì mỗi ký tự nhận được sẽ được thay thế bằng một ký tự cách nó
 * một đoạn s. Ví dụ: với s = 3 thì ký tự "A" sẽ được thay thế bằng ký tự "D".
 * Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207.
 * Yêu cầu xây dựng chương trình client:
 * 
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * 
 * b. Nhận thông điệp là một chuỗi từ server theo định dạng
 * "requestId;strEncode;s".
 * • requestId là chuỗi ngẫu nhiên duy nhất
 * • strEncode là chuỗi thông điệp bị mã hóa
 * • s là số nguyên chứa giá trị độ dịch của mã
 * 
 * c. Giải mã tìm thông điệp ban đầu và gửi lên server theo định dạng
 * "requestId;strDecode"
 * 
 * d. Đóng socket và kết thúc chương trình.
 */
