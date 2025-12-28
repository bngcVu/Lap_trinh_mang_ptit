# NGÂN HÀNG CÂU HỎI THI MÔN LẬP TRÌNH MẠNG – PHẦN TCP

---

## PHẦN 1 - ĐỀ KIỂM TRA PHẦN TCP 
*Bổ sung ngày 24/10/2025*

---

#### DataStream

##### BÀI 1. ĐỔI CHIỀU VÀ BIẾN THIÊN
[Mã câu hỏi (qCode): oNGj55wV].  Một chương trình server cho phép kết nối qua TCP tại cổng 807 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu xây dựng chương trình client thực hiện giao tiếp với server sử dụng luồng data (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B10DCCN002;B4C5D6E7"

b. Nhận chuỗi chứa mảng số nguyên từ server, các phần tử được phân tách bởi dấu phẩy ",". Ví dụ: "1,3,2,5,4,7,6"

c. Tính số lần đổi chiều và tổng độ biến thiên trong dãy số.
- Đổi chiều: Khi dãy chuyển từ tăng sang giảm hoặc từ giảm sang tăng 
- Độ biến thiên: Tổng giá trị tuyệt đối của các hiệu số liên tiếp
Gửi lần lượt lên server: số nguyên đại diện cho số lần đổi chiều, sau đó là số nguyên đại diện cho tổng độ biến thiên. Ví dụ: Với mảng "1,3,2,5,4,7,6", số lần đổi chiều: 5 lần, Tổng độ biến thiên 11  Gửi lần lượt số nguyên 5 và 11 lên server.

d. Đóng kết nối và kết thúc chương trình.

---

##### BÀI 2. ĐẢO NGƯỢC ĐOẠN DÀI K
[Mã câu hỏi (qCode): dCNDHojG].  Một chương trình server cho phép kết nối qua TCP tại cổng 2207 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu xây dựng chương trình client thực hiện giao tiếp với server sử dụng luồng data (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B10DCCN003;C6D7E8F9"

b. Nhận lần lượt:
•	Một số nguyên k là độ dài đoạn.
•	Chuỗi chứa mảng số nguyên, các phần tử được phân tách bởi dấu phẩy ",".
Ví dụ: Nhận k = 3 và "1,2,3,4,5,6,7,8".

c. Thực hiện chia mảng thành các đoạn có độ dài k và đảo ngược mỗi đoạn, sau đó gửi mảng đã xử lý lên server. Ví dụ: Với k = 3 và mảng "1,2,3,4,5,6,7,8", kết quả là "3,2,1,6,5,4,8,7". Gửi chuỗi kết quả "3,2,1,6,5,4,8,7" lên server.

d. Đóng kết nối và kết thúc chương trình

---

#### Byte Stream

##### BÀI 3. TỔNG GẤP ĐÔI TRUNG BÌNH
[Mã câu hỏi (qCode): TL9Pol9D].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B16DCCN999;D45EFA12"

b. Nhận dữ liệu từ server là một chuỗi các số nguyên được phân tách bởi ký tự ",".
Ví dụ: "10,5,15,20,25,30,35"

c. Xác định hai số trong dãy có tổng gần nhất với gấp đôi giá trị trung bình của toàn bộ dãy. Gửi thông điệp lên server theo định dạng "num1,num2".
Ví dụ: Với dãy "10,5,15,20,25,30,35", gấp đôi giá trị trung bình là 40, hai số có tổng gần nhất là 15 và 25. Gửi lên server chuỗi "15,25".

d. Đóng kết nối và kết thúc chương trình.

---

##### BÀI 4. TỔNG CÁC SỐ NGUYÊN TỐ
[Mã câu hỏi (qCode): ZRFRsEcM].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B16DCCN999;C89DAB45"

b. Nhận dữ liệu từ server là một chuỗi các số nguyên được phân tách bởi ký tự ",".
Ví dụ: "8,4,2,10,5,6,1,3"

c. Tính tổng của tất cả các số nguyên tố trong chuỗi và gửi kết quả lên server.
Ví dụ: Với dãy "8,4,2,10,5,6,1,3", các số nguyên tố là 2, 5, 3, tổng là 10. Gửi lên server chuỗi "10".

d. Đóng kết nối và kết thúc chương trình.

---

##### BÀI 5. VỊ TRÍ CÂN BẰNG TỔNG
[Mã câu hỏi (qCode): zmNHK0Y7].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B16DCCN999;E56FAB67"

b. Nhận dữ liệu từ server là một chuỗi các số nguyên được phân tách bởi ký tự ",".
Ví dụ: " 3,7,2,5,8,1"

c. Tìm vị trí mà độ lệch của tổng bên trái và tổng bên phải là nhỏ nhất -> Gửi lên server vị trí đó, tổng trái, tổng phải và độ lệch. Ví dụ: với dãy " 3,7,2,5,8,1", vị trí 3 có độ lệch nhỏ nhất = 3 → Kết quả gửi server: "3,12,9,3"

d. Đóng kết nối và kết thúc chương trình.

---

#### Character Stream

##### BÀI 6. SẮP XẾP THEO ĐỘ DÀI 
[Mã câu hỏi (qCode): we3kcWxZ].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản sau:

a. Gửi một chuỗi chứa mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;C1234567"

b. Nhận từ server một chuỗi chứa nhiều từ, các từ được phân tách bởi khoảng trắng. Ví dụ: "hello world this is a test example"

c. Sắp xếp các từ trong chuỗi theo độ dài, thứ tự xuất hiện. Gửi danh sách các từ theo từng nhóm về server theo định dạng: "a, is, this, test, hello, world, example".

d. Đóng kết nối và kết thúc chương trình.

---

##### BÀI 7. NÉN RLE
[Mã câu hỏi (qCode): ji3fQD3Q].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản sau:

a. Gửi một chuỗi chứa mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode".
Ví dụ: "B15DCCN999;1D08FX21"

b. Nhận từ server một chuỗi chứa nhiều từ, các từ được phân tách bởi khoảng trắng.
Ví dụ: "hello world programming is fun"

c. Thực hiện đảo ngược từ và mã hóa RLE để nén chuỗi ("aabb" nén thành "a2b2"). Gửi chuỗi đã được xử lý lên server. Ví dụ: "ol2eh dlrow gnim2argorp si nuf".

d. Đóng kết nối và kết thúc chương trình

---

#### Object Stream

##### BÀI 8. ĐỊA CHỈ KHÁCH HÀNG
[Mã câu hỏi (qCode): XtWjagNp].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 809 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng đối tượng (ObjectOutputStream/ObjectInputStream) để gửi/nhận và chuẩn hóa thông tin địa chỉ của khách hàng.
Biết rằng lớp TCP.Address có các thuộc tính (id int, code String, addressLine String, city String, postalCode String) và trường dữ liệu private static final long serialVersionUID = 20180801L.

a. Gửi đối tượng là một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;A1B2C3D4"

b. Nhận một đối tượng là thể hiện của lớp TCP.Address từ server. Thực hiện chuẩn hóa thông tin addressLine bằng cách:
•	Chuẩn hóa addressLine: Viết hoa chữ cái đầu mỗi từ, in thường các chữ còn lại, loại bỏ ký tự đặc biệt và khoảng trắng thừa (ví dụ: "123 nguyen!!! van cu" → "123 Nguyen Van Cu") 
•	Chuẩn hóa postalCode: Chỉ giữ lại số và ký tự "-" ví dụ: "123-456"

c. Gửi đối tượng đã được chuẩn hóa thông tin địa chỉ lên server.

d. Đóng kết nối và kết thúc chương trình.

---

##### BÀI 9. HỆ CƠ SỐ 8 VÀ 16
[Mã câu hỏi (qCode): 0LTGyX4p].  Một chương trình server cho phép kết nối qua TCP tại cổng 2207 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu xây dựng chương trình client thực hiện giao tiếp với server sử dụng luồng data (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B10DCCN001;A1B2C3D4"

b. Nhận một số nguyên hệ thập phân từ server. Ví dụ: 255

c. Chuyển đổi số nguyên nhận được sang hai hệ cơ số 8 và 16. Gửi lần lượt chuỗi kết quả lên server. Ví dụ: Với số 255 hệ thập phân, kết quả gửi lên sẽ là một chuỗi dạng "377;FF"

d. Đóng kết nối và kết thúc chương trình.

---

##### BÀI 10. DÃY SỐ COLLAZT
[Mã câu hỏi (qCode): BDF0CKv5].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s).
Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"

b. Nhận dữ liệu từ server là một số nguyên n nhỏ hơn 400. Ví dụ: 7

c. Thực hiện các bước sau đây để sinh ra chuỗi từ số nguyên n ban đầu và gửi lên server.
Gọi n là số hiện tại, n1 là số tiếp theo. Ta có:
•	Nếu n là số chẵn  n1 = n / 2;
•	Nếu n là số lẻ  n1 = 3n + 1
Lặp lại quá trình trên cho đến khi n = 1, tại đó dừng thuật toán.
Kết quả là một dãy số liên tiếp, bắt đầu từ n ban đầu, kết thúc tại 1 và độ dài của chuỗi theo format "chuỗi kết quả; độ dài"  Ví dụ: kết quả với n = 7 thì dãy: 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1; 17

d.	Đóng kết nối và kết thúc chương trình.

---

##### BÀI 11. HỆ CƠ SỐ 2 VÀ 16
[Mã câu hỏi (qCode): UsLuWWET].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu sinh viên xây dựng chương trình client để tương tác với server, sử dụng các luồng data (DataInputStream và DataOutputStream) để trao đổi thông tin theo thứ tự sau:

a. Gửi mã sinh viên và mã câu hỏi: Chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7".

b. Nhận một số nguyên hệ thập phân từ server. Ví dụ:: 15226.

c. Chuyển đổi số nguyên nhận được sang hệ nhị phân và thập lục phân, ghép thành chuỗi và gửi lên server. Ví dụ: 15226 sẽ thành "11101101111010;3B7A"

d. Đóng kết nối: Kết thúc chương trình sau khi gửi kết quả chuyển đổi.

---

##### BÀI 12. HỆ CƠ SỐ 2
[Mã câu hỏi (qCode): hNO8EoAz].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu sinh viên xây dựng chương trình client để tương tác với server, sử dụng các luồng data (DataInputStream và DataOutputStream) để trao đổi thông tin theo thứ tự sau:

a. Gửi mã sinh viên và mã câu hỏi: Chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7".

b. Nhận một số nguyên hệ thập phân từ server. Ví dụ: 45

c. Chuyển đổi số nguyên nhận được sang hệ nhị phân và gửi chuỗi kết quả này lại cho server. Ví dụ: 45 sẽ thành chuỗi "101101"

d. Đóng kết nối và kết thúc chương trình.

---

## PHẦN 2 - NGÂN HÀNG CÂU HỎI THI (Tiếp)
*Cập nhật lần cuối: Thứ 5, ngày 23/10/2025*

---

##### BÀI 13. MÃ HOÁ CAESAR
[Mã câu hỏi (qCode): doW5fnkq]. Mật mã caesar, còn gọi là mật mã dịch chuyển, để giải mã thì mỗi ký tự nhận được sẽ được thay thế bằng một ký tự cách nó một đoạn s. Ví dụ: với s = 3 thì ký tự "A" sẽ được thay thế bằng ký tự "D".
Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng chương trình client tương tác với server trên, sử dụng các luồng byte (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:

a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7"

b.	Nhận lần lượt chuỗi đã bị mã hóa caesar và giá trị dịch chuyển s nguyên

c.	Thực hiện giải mã ra thông điệp ban đầu và gửi lên Server

d.	Đóng kết nối và kết thúc chương trình.

Giải: Lời giải đúng của bài này là:
•	Các ký tự không phải là chữ thì giữ nguyên không thay đổi
•	Các ký tự là chữ hoa, chữ thường thì được TRỪ LÙI tương ứng theo chữ cái đó
 
---

##### BÀI 14. HIỆU CỦA HAI TẬP KÝ TỰ
[Mã câu hỏi (qCode): wWTzyRuY]. [Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai] Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản sau:

a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;DE0C2BF0"

b.	Nhận lần lượt hai chuỗi ngẫu nhiên từ server

c.	Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai, yêu cầu giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi thứ nhất đã được xử lý lên server.

d.	Đóng kết nối và kết thúc chương trình

---

##### BÀI 15. SẢN PHẨM
[Mã câu hỏi (qCode): PoFyczA9]. Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể:

a)	Tên sản phẩm bị đổi ngược từ đầu tiên và từ cuối cùng, ví dụ: "lenovo thinkpad T520" bị chuyển thành "T520 thinkpad lenovo"

b)	Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899

Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2209 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng đối tượng (ObjectInputStream / ObjectOutputStream) để gửi/nhận và sửa các thông tin bị sai của sản phẩm. Chi tiết dưới đây:

a)	Đối tượng trao đổi là thể hiện của lớp Product917 được mô tả như sau
•	Tên đầy đủ của lớp: TCP.Product917
•	Các thuộc tính: id int, code String, name String, quantity int
•	Hàm khởi tạo đầy đủ các thuộc tính được liệt kê ở trên
•	Trường dữ liệu: private static final long serialVersionUID = 917;

b)	Tương tác với server theo kịch bản
1)	Gửi đối tượng là chuỗi chứa mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;5AD2B818"
2)	Receive một đối tượng là thể hiện của lớp Product917 từ server
3)	Sửa các thông tin sai của sản phẩm về tên và số lượng. Gửi đối tượng vừa được sửa sai lên server
4)	Đóng socket và kết thúc chương trình

---

##### BÀI 16. KHÁCH HÀNG
[Mã câu hỏi (qCode): 6Tw3qHNF]. Thông tin khách hàng cần thay đổi định dạng lại cho phù hợp với khu vực, cụ thể:

a.	Tên khách hàng cần được chuẩn hóa theo định dạng mới. Ví dụ: nguyen van hai duong 
DUONG, Nguyen Van Hai

b.	Ngày sinh của khách hàng hiện đang ở dạng mm-dd-yyyy, cần được chuyển thành định dạng dd/mm/yyyy. Ví dụ: 10-11-2012  11/10/2012

c.	Tài khoản khách hàng là các chữ cái in thường được sinh tự động từ họ tên khách hàng. Ví dụ: nguyen van hai duong  nvhduong

Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2209 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng đối tượng (ObjectInputStream / ObjectOutputStream) thực hiện gửi/nhận đối tượng khách hàng và chuẩn hóa. Cụ thể:

a.	Đối tượng trao đổi là thể hiện của lớp Customer918 được mô tả như sau
•	Tên đầy đủ của lớp: TCP.Customer918
•	Các thuộc tính: id int, code String, name String, dayOfBirth String, userName String
•	Hàm khởi tạo đầy đủ các thuộc tính được liệt kê ở trên
•	Trường dữ liệu: private static final long serialVersionUID = 918;

b.	Tương tác với server theo kịch bản dưới đây:
1)	Gửi đối tượng là một chuỗi gồm mã sinh viên và mã câu hỏi ở định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;F2DA54F3"
2)	Nhận một đối tượng là thể hiện của lớp Customer918 từ server với các thông tin đã được thiết lập
3)	Thay đổi định dạng theo các yêu cầu ở trên và gán vào các thuộc tính tương ứng. Gửi đối tượng đã được sửa đổi lên server
4)	Đóng	socket	và	kết	thúc	chương	trình.

---

##### BÀI 17. DÃY CON LIÊN TIẾP TĂNG DÀI NHẤT
[Mã câu hỏi (qCode): RnPqP3f7].
Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:

a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;76B68B3B".

b.	Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách bởi ký tự ",". Ví dụ: 5,10,20,25,50,40,30,35.

c.	Tìm chuỗi con tăng dần dài nhất và gửi độ dài của chuỗi đó lên server. Ví dụ: 5,10,20,25 có độ dài 4.

d.	Đóng kết nối và kết thúc chương trình.

---

##### BÀI 18. LỌC KÝ TỰ
[Mã câu hỏi (qCode): mhUhFT2v]. [Loại bỏ ký tự đặc biệt, trùng và giữ nguyên thứ tự xuất hiện] Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản dưới đây:

a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;7D6265E3"

b.	Nhận một chuỗi ngẫu nhiên từ server

c.	Loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi đã được xử lý lên server.

d.	Đóng kết nối và kết thúc chương trình

---

##### BÀI 19. DÃY CON LIÊN TIẾP KHÔNG LẶP DÀI NHẤT
[Mã câu hỏi (qCode): HyHAk4P5].
Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client thực hiện kết nối tới server sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:

a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;10048F28".

b.	Nhận chuỗi ký tự s từ server. Ví dụ: "abcabcbb"

c.	Tìm và gửi lên server chuỗi con dài nhất từ chuỗi nhận được mà không có ký tự lặp lại theo format "longestsubstring;length". Ví dụ: "abc;3".

d.	Đóng kết nối và kết thúc chương trình.

Chú ý:
1.	Ràng buộc: 10 ≤ len(s) ≤ 1000
2.	Nếu có nhiều xâu con liên tiếp đều có chung độ dài lớn nhất và thoả mãn không lặp lại, chỉ ghi nhận xâu con liên tiếp có vị trí xuất hiện bé nhất trong xâu ban đầu.


##### BÀI 20. UCLN/BCNN
Mã bài tập i9VhkNb
Một chương trình server được triển khai tại địa chỉ 172.188.19.218 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s), yêu cầu xây dựng chương trình Client thực hiện kết nối tới server tại cổng 1605, sử dụng luồng byte dữ liệu (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:

a/ Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên.

b. Nhận lần lượt hai số nguyên a và b từ server

c. Thực hiện tính toán UCLN, BCNN và gửi lần lượt từng giá trị theo đúng thứ tự trên lên server

d. Đóng kết nối và kết thúc

---

##### BÀI 21. LUỸ THỪA
Mã bài tập nxMRj8z
Một chương trình server tại địa chỉ 172.188.19.218 hỗ trợ kết nối qua giao thức TCP tại cổng 1604 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server trên sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:

a/ Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên.

b. Nhận dữ liệu từ server là một chuỗi gồm hai giá trị nguyên a, b được phân tách với nhau bằng "|" Ex: 2|5

c. Thực hiện tìm giá trị ab và gửi lên server. Ex: 32

d. Đóng kết nối và kết thúc

---

##### BÀI 22. LOẠI BỎ NGUYÊN ÂM
Mã bài tập x8c45mq
Một chương trình server tại địa chỉ 172.188.19.218 cho phép kết nối qua giao thức TCP tại cổng 1606 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng byte (BufferedWriter/BufferedReader) theo kịch bản sau:

a/ Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên.

b. Nhận một chuỗi từ server (Chỉ chứa kí tự thường)

c. Thực hiện loại bỏ các nguyên âm trong chuỗi và gửi kết quả lên server

d. Đóng kết nối và kết thúc.

---

##### BÀI 23. TÊN MIỀN ĐÚNG
Mã bài tập n6Ag5dA
Một chương trình server tại địa chỉ 172.188.19.218 cho phép kết nối qua giao thức TCP tại cổng 1606 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng byte (BufferedWriter/BufferedReader) theo kịch bản sau:

a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "MaSV;MaCauhoi".
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên.

b. Nhận một chuỗi ngẫu nhiên là danh sách các một số tên miền từ server
Ví dụ: giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, TUHuMfn25chmw.vn, HHjE9.com, s2aUrZGdzS.com, 4hXfJe9giAA.edu, 4hJld2m2yiweto.vn, y2L4SQwH.vn

c. Tìm kiếm các tên miền .edu và gửi lên server Ví dụ: MdpIzhxDVtTFTF.edu, 4hXfJe9giAA.edu

d. Đóng kết nối và kết thúc chương trình.

---

##### BÀI 24. TỔNG CÁC SỐ
Mã bài tập PUh9Ki1
Một chương trình server tại địa chỉ 172.188.19.218 hỗ trợ kết nối qua giao thức TCP tại cổng 1604 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server trên sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:

a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên.

b. Nhận dữ liệu từ server là một chuỗi gồm hai giá trị nguyên được phân tách với nhau bằng "|"
Ex: 2|5|9|11

c. Thực hiện tìm giá trị tổng của các số nguyên trong chuỗi và gửi lên server Ex: 27

d. Đóng kết nối và kết thúc

---

##### BÀI 25. TỔNG HIỆU TÍCH
Mã bài tập 1T6hNnZ
Một chương trình server được triển khai tại địa chỉ 172.188.19.218 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình Client thực hiện kết nối tới server tại cổng 1605, sử dụng luồng byte dữ liệu (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:

a/ Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên.

b. Nhận lần lượt hai số nguyên a và b từ server

c. Thực hiện tính toán tổng, hiệu, tích và gửi lần lượt từng giá trị theo đúng thứ tự trên lên server

d. Đóng kết nối và kết thúc

---

##### BÀI 26. ĐẢO NGƯỢC CHUỖI
Một chương trình server tại địa chỉ 172.188.19.218 cho phép kết nối qua giao thức TCP tại cổng 1606 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng byte (BufferedWriter/BufferedReader) theo kịch bản sau:

a/ Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên.

b. Nhận một chuỗi từ server

c. Thực hiện đảo ngược lại chuỗi và gửi lên server

d. Đóng kết nối và kết thúc
