package RMI.RMI;

import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Product;

public class XuLySanPham1 {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product product = (Product) sv.requestObject("B22DCCN634", "dx3nt4Ij");
        System.out.println(product);
        product.setCode(product.getCode().toUpperCase());
        product.setExportPrice(product.getImportPrice() * 1.2f);
        System.out.println("Normalized product: " + product);
        sv.submitObject("B22DCCN634", "dx3nt4Ij", product);
    }
}
/*
 * ##### BÀI 4. [Object] SẢN PHẨM – 1
 * [Mã câu hỏi (qCode): dx3nt4Ij]. Một chương trình RMI Server cung cấp giao
 * diện cho phép triệu gọi từ xa.
 * Giao diện từ xa:
 * public interface ObjectService extends Remote {
 * public Serializable requestObject(String studentCode, String qAlias) throws
 * RemoteException;
 * public void submitObject(String studentCode, String qAlias, Serializable
 * object) throws RemoteException;
 * }
 * Lớp Product gồm các thông tin: id String, code String, importPrice double,
 * exportPrice double.
 * Trường dữ liệu: private static final long serialVersionUID = 20151107L;
 * 
 * Yêu cầu:
 * a. Triệu gọi phương thức requestObject để lấy về đối tượng sản phẩm cần chuẩn
 * hóa.
 * b. Thực hiện chuẩn hóa đối tượng theo nguyên tắc:
 * - Chuyển mã sản phẩm thành in hoa.
 * - Cập nhật giá xuất (exportPrice) bằng giá nhập (importPrice) + 20%
 * c. Triệu gọi phương thức submitObject để gửi dữ liệu đã chuẩn hóa.
 * d. Kết thúc chương trình client.
 */
