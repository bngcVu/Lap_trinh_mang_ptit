package UDP.UDP;

import java.net.*;

public class DemSoLanXH {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        String code = ";B22DCCN634;pWk1YfFe";
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
        String res = "";
        int[] cnt = new int[10005];
        for (char x : s.toCharArray())
            cnt[x]++;
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                res += String.format("%d%c", cnt[x], x);
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
 * ##### BÀI 13. ĐẾM SỐ LẦN XUẤT HIỆN
 * [Mã câu hỏi (qCode): vSgxl3HQ]. Một chương trình server cho phép giao tiếp
 * qua giao thức UDP tại cổng 2208. Yêu cầu xây dựng chương trình client trao
 * đổi thông tin với server theo kịch bản:
 * 
 * a. Gửi một thông điệp chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * 
 * b. Nhận một thông điệp từ server theo định dạng "requestId;data", với:
 * - requestId là chuỗi ngẫu nhiên duy nhất.
 * - data là một chuỗi ký tự liên tiếp cần xử lý.
 * 
 * c. Xử lý chuỗi bằng cách đếm số lượng ký tự và gom chúng lại theo định dạng
 * "số_lần_ký_tự".
 * Gửi kết quả về server theo định dạng: "requestId;processedData"
 * Ví dụ: Với chuỗi "aaabbbccdaa", kết quả sẽ là: "requestId;5a3b2c1d"
 * 
 * d. Đóng socket và kết thúc chương trình.
 */
