package UDP.UDP;

import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class SapXepTuDienNguoc {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        String code = ";B22DCCN634;9UfU4Vky";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        ArrayList<String> a = new ArrayList<>();
        for (int i = 1; i < tmp1.length; i++)
            a.add(tmp1[i]);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.toLowerCase().compareTo(s1.toLowerCase());
            }
        });
        String res = rqID + ";";
        for (String x : a)
            res += x + ",";
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
/*
 * ##### BÀI 2. SẮP XẾP THEO TỪ ĐIỂN NGƯỢC
 * [Mã câu hỏi (qCode): 9UfU4Vky]. Một chương trình server cho phép giao tiếp
 * qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client
 * trao đổi thông tin với server theo kịch bản:
 * 
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * "studentCode;qCode".
 * 
 * b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;data",
 * với:
 * • requestId là chuỗi ngẫu nhiên duy nhất.
 * • data là một chuỗi ký tự chứa nhiều từ, được phân cách bởi dấu cách.
 * 
 * c. Sắp xếp các từ trong chuỗi theo thứ tự từ điển ngược (z đến a) và gửi
 * thông điệp lên server theo định dạng "requestId;word1,word2,...,wordN".
 * 
 * d. Đóng socket và kết thúc chương trình
 * 
 * Chú ý: Khi so sánh theo thứ tự từ điển thì không phân biệt chữ hoa chữ
 * thường.
 */
