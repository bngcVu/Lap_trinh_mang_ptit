package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.ProductX;

public class XuLySanPham2 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        ProductX product = (ProductX) sv.requestObject("B22DCCN634", "PY43T66m");
        System.out.println(product);
        int tong = 0;
        for (char x : product.getDiscountCode().toCharArray()) {
            if (Character.isDigit(x))
                tong += Character.getNumericValue(x);
        }
        product.setDiscount(tong);
        System.out.println(product);
        sv.submitObject("B22DCCN634", "PY43T66m", product);
    }
}
/*
 * ##### BÀI 8. [Object] SẢN PHẨM – 2
 * [Mã câu hỏi (qCode): PY43T66m]. Một chương trình RMI Server cung cấp các mã
 * khuyến mãi sản phẩm ngẫu nhiên cho sinh viên.
 * Giao diện từ xa:
 * public interface ObjectService extends Remote {
 * public Serializable requestObject(String studentCode, String qAlias) throws
 * RemoteException;
 * public void submitObject(String studentCode, String qAlias, Serializable
 * object) throws RemoteException;
 * }
 * Lớp ProductX gồm các thuộc tính: id String, code String, discountCode String,
 * discount int.
 * Trường dữ liệu: private static final long serialVersionUID = 20171107;
 * 
 * Yêu cầu:
 * 1. Triệu gọi phương thức requestObject để nhận về đối tượng ProductX.
 * 2. Tính tổng các chữ số nằm trong chuỗi mã giảm giá (discountCode) để ra giá
 * trị được khuyến mãi của sản phẩm và cập nhật giá trị của khuyến mãi
 * (discount).
 * 3. Triệu gọi phương thức submitObject với tham số là đối tượng Product đã
 * được cập nhật đầy đủ thông tin giá trị khuyến mãi.
 * 4. Kết thúc chương trình.
 */
