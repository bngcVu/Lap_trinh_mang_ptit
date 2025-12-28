package UDP.UDP;

import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;

public class TongSoNguyenLon {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        String code = ";B22DCCN634;2sIjAYaU";
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
        BigInteger a = new BigInteger(tmp1[1]), b = new BigInteger(tmp1[2]);
        BigInteger tong = a.add(b), hieu = a.subtract(b);
        String res = String.format("%s;%s,%s", rqID, tong.toString(), hieu.toString());
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
/*
 * ##### BÀI 1. TỔNG HAI SỐ NGUYÊN LỚN
 * [Mã câu hỏi (qCode): 2sIjAYaU]. Một chương trình server cho phép giao tiếp
 * qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client
 * trao đổi thông tin với server theo kịch bản:
 * 
 * a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng
 * ";studentCode;qCode".
 * 
 * b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;a;b",
 * với:
 * • requestId là chuỗi ngẫu nhiên duy nhất.
 * • a và b là chuỗi thể hiện hai số nguyên lớn (hơn hoặc bằng 100 chữ số).
 * 
 * c. Tính tổng và hiệu của hai số a và b, gửi thông điệp lên server theo định
 * dạng "requestId;sum;difference".
 * 
 * d. Đóng socket và kết thúc chương trình
 * 
 * Chú ý: Yêu cầu sử dụng BigInteger, tính a – b chứ không tính |a – b|
 */
