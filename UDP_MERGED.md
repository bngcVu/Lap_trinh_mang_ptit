# NGÂN HÀNG CÂU HỎI THI MÔN LẬP TRÌNH MẠNG – PHẦN UDP

---

## PHẦN 1 - ĐỀ ÔN TẬP BỔ SUNG UDP
*Cập nhật lần cuối: Ngày 24 tháng 10 năm 2025*

---

##### BÀI 1. TỔNG HAI SỐ NGUYÊN LỚN
[Mã câu hỏi (qCode): 2sIjAYaU].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode".
Ví dụ: ";B15DCCN010;D3F9A7B8"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;a;b", với:
•	requestId là chuỗi ngẫu nhiên duy nhất.
•	a và b là chuỗi thể hiện hai số nguyên lớn (hơn hoặc bằng 100 chữ số).
Ví dụ: "X1Y2Z3;9876543210;123456789"

c. Tính tổng và hiệu của hai số a và b, gửi thông điệp lên server theo định dạng "requestId;sum;difference".Ví dụ: 
Nếu nhận được "X1Y2Z3;9876543210,123456789", tổng là 9999999999 và hiệu là 9753086421. Kết quả gửi lại sẽ là "X1Y2Z3;9999999999,9753086421".

d. Đóng socket và kết thúc chương trình

Chú ý: Yêu cầu sử dụng BigInter, tính a – b chứ không tính |a – b|

---

##### BÀI 2. SẮP XẾP THEO TỪ ĐIỂN NGƯỢC
[Mã câu hỏi (qCode): 9UfU4Vky].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: ";B15DCCN009;EF56GH78"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;data", với:
•	requestId là chuỗi ngẫu nhiên duy nhất.
•	data là một chuỗi ký tự chứa nhiều từ, được phân cách bởi dấu cách.
Ví dụ: "EF56GH78;The quick brown fox"

c. Sắp xếp các từ trong chuỗi theo thứ tự từ điển ngược (z đến a) và gửi thông điệp lên server theo định dạng "requestId;word1,word2,...,wordN".
Ví dụ: Với data = "The quick brown fox", kết quả là: "EF56GH78;quick,fox,brown,The"

d. Đóng socket và kết thúc chương trình

Chú ý: Khi so sánh theo thứ tự từ điển thì không phân biệt chữ hoa chữ thường, đưa tất cả về cùng 1 kiểu rồi mới so sánh thì mới AC.

---

##### BÀI 3. CHUẨN HOÁ THÔNG TIN SÁCH
[Mã câu hỏi (qCode): LFACr5Bi].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2209. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản sau:
Đối tượng trao đổi là thể hiện của lớp UDP.Book được mô tả:
-	Tên đầy đủ lớp: UDP.Book
-	Các thuộc tính: id (String), title (String), author (String), isbn (String), publishDate (String)
-	Hàm khởi tạo:
        public Book(String id, String title, String author, String isbn, String publishDate)
-	Trường dữ liệu: private static final long serialVersionUID = 20251107L
Thực hiện:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B23DCCN005;eQkvAeId"

b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Book từ server. Trong đó, các thuộc tính id, title, author, isbn, và publishDate đã được thiết lập sẵn.

c. Thực hiện:
        1. Chuẩn hóa title: Với mỗi từ, viết hoa chữ cái đầu tiên, viết thường các chữ cái còn lại.
        2. Chuẩn hóa author theo định dạng "Họ, Tên". 
- Trong đó họ được hiểu là từ đầu tiên của tác giả, tất cả các từ còn lại là tên.
- Họ: Viết hoa tất cả các chữ cái
- Tên: Với mỗi từ, viết hoa chữ cái đầu tiên, viết thường các chữ cái còn lại, giữa mỗi từ chỉ có đúng một dấu cách
        3. Chuẩn hóa mã ISBN theo định dạng "978-3-16-148410-0"
        4. Chuyển đổi publishDate từ yyyy-mm-dd sang mm/yyyy.

d. Gửi lại đối tượng đã được chuẩn hóa về server với cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Book đã được sửa đổi.

e. Đóng socket và kết thúc chương trình.

Test ví dụ:
Input
Request ID: kEfAIDHb
Book{id=kEfAIDHb, title=wAsSegd NCAxhCY hPaSVlUJC YRUyI, author=cFPISv tlpiAvv TzfHf hSgRO vhorbuZXe RtKAxjdPK, isbn=2485368573116, publishDate=2007-05-16}
Output
Book{id=kEfAIDHb, title=Wassegd Ncaxhcy Hpasvlujc Yruyi, author=CFPISV, Tlpiavv Tzfhf Hsgro Vhorbuzxe Rtkaxjdpk, isbn=248-5-36-857311-6, publishDate=05/2007}

---

##### BÀI 4. QUẢN LÝ THÔNG TIN NHÂN VIÊN
[Mã câu hỏi (qCode): ySsumsIE].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2209. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản sau:
Đối tượng trao đổi là thể hiện của lớp UDP.Employee được mô tả:
-	Tên đầy đủ lớp: UDP.Employee
-	Các thuộc tính: id (String), name (String), salary (double), hireDate (String)
-	Hàm khởi tạo:
        public Employee(String id, String name, double salary, String hireDate)
-	Trường dữ liệu: private static final long serialVersionUID = 20261107L
Thực hiện:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B23DCCN006;ITleSdqV"

b. Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Employee từ server. Trong đó, các thuộc tính id, name, salary và hireDate đã được thiết lập sẵn.

c. Thực hiện:
- Chuẩn hóa name: viết hoa chữ cái đầu của mỗi từ, ví dụ "john doe" thành "John Doe".
- Tăng salary: tăng x% lương, với x bằng tổng các chữ số của năm sinh.
- Chuyển đổi hireDate từ định dạng yyyy-mm-dd sang dd/mm/yyyy. Ví dụ: "2023-07-15" thành "15/07/2023".
- Gửi lại đối tượng đã được chuẩn hóa về server với cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Employee đã được sửa đổi.

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 5. PHẦN TỬ LỚN NHẤT CỦA DÃY CON
[Mã câu hỏi (qCode): iv00Hrq6].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B21DCCN795;ylrhZ6UM".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n;k;z1,z2,...,zn", trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    n là số phần tử của mảng.
    k là kích thước cửa sổ trượt (k < n).
    z1 đến zn là n phần tử là số nguyên của mảng.

c. Thực hiện tìm giá trị lớn nhất trong mỗi cửa sổ trượt với kích thước k trên mảng số nguyên nhận được, và gửi thông điệp lên server theo định dạng "requestId;max1,max2,...,maxm", trong đó max1 đến maxm là các giá trị lớn nhất tương ứng trong mỗi cửa sổ.
Ví dụ: "requestId;5;3;1,5,2,3,4"
Kết quả: "requestId;5,5,4"

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 6. SẮP XẾP THEO VỊ TRÍ BAN ĐẦU
[Mã câu hỏi (qCode): aKZwZxWk].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với:
--- requestId là chuỗi ngẫu nhiên duy nhất.
---string là một chuỗi chứa các chuỗi con bị thay đổi vị trí. Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"

c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý: "M6dpWTE,aWXlSzDwe,PHupvPc,veM3xgA1g,IPFfgEanY,PR3gH8ahN,UEEKHLIt"

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 7. TỔNG HAI SỐ NHỊ PHÂN
[Mã câu hỏi (qCode): lIQVug9S].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN000;XbYdNZ3".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;b1,b2", trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    b1 là số nhị phân thứ nhất
    b2 là số nhị phân thứ hai.
Ví dụ: requestId;0100011111001101,1101000111110101

c. Thực hiện tính tổng hai số nhị phân nhận được, chuyển về dạng thập phân và gửi lên server theo định dạng "requestId;sum"
Kết quả: requestId;72130 

d. Đóng socket và kết thúc chương trình.

---

## PHẦN 2 - MẪU ĐỀ ÔN TẬP BÀI KIỂM TRA SỐ 2 – UDP
*Thời gian làm bài: 60 phút. Đề thi gồm có 04 bài. Cập nhật lần cuối: 06/10/2024*

Lưu ý:
1. Sinh viên truy cập địa chỉ sau và đăng nhập để làm bài: http://203.162.10.109/
2. Địa chỉ IP để thiết lập giao thức cho các bài cũng chính là 203.162.10.109

---

##### BÀI 8. GIÁ TRỊ NHỎ NHẤT – GIÁ TRỊ LỚN NHẤT [DataType]
[Mã câu hỏi (qCode): uWKK8u3W].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;DC73CA2E"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;a1,a2,...,a50"
requestId là chuỗi ngẫu nhiên duy nhất
a1 -> a50 là 50 số nguyên ngẫu nhiên

c. Thực hiện tìm giá trị lớn nhất và giá trị nhỏ nhất thông điệp trong a1 -> a50 và gửi thông điệp lên lên server theo định dạng "requestId;max,min"

d. Đóng socket và kết thúc chương trình

---

##### BÀI 9. SẢN PHẨM [Object]
[Mã câu hỏi (qCode): kZqFKEDL].  Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể:
a. Tên sản phẩm bị đổi ngược từ đầu tiên và từ cuối cùng, ví dụ: "lenovo thinkpad T520" bị chuyển thành "T520 thinkpad lenovo"
b. Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2209. Yêu cầu là xây dựng một chương trình client giao tiếp với server để gửi/nhận các sản phẩm theo mô tả dưới đây:

a. Đối tượng trao đổi là thể hiện của lớp Product được mô tả như sau
• Tên đầy đủ của lớp: UDP.Product
• Các thuộc tính: id String, code String, name String, quantity int
• Một hàm khởi tạo có đầy đủ các thuộc tính được liệt kê ở trên
• Trường dữ liệu: private static final long serialVersionUID = 20161107;

b. Giao tiếp với server theo kịch bản
• Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;EE29C059"
• Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Product từ server. Trong đối tượng này, các thuộc tính id, name và quantity đã được thiết lập giá trị.
• Sửa các thông tin sai của đối tượng về tên và số lượng như mô tả ở trên và gửi đối tượng vừa được sửa đổi lên server theo cấu trúc:
08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Product đã được sửa đổi.
• Đóng socket và kết thúc chương trình.

---

##### BÀI 10. CHUẨN HOÁ XÂU KÝ TỰ [String]
[Mã câu hỏi (qCode): tmczgSLy].  Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;5B35BCC1"

b. Nhận thông điệp từ server theo định dạng "requestId;data"
requestId là một chuỗi ngẫu nhiên duy nhất
data là chuỗi dữ liệu cần xử lý

c. Xử lý chuẩn hóa chuỗi đã nhận thành theo nguyên tắc
i. Ký tự đầu tiên của từng từ trong chuỗi là in hoa
ii. Các ký tự còn lại của chuỗi là in thường
Gửi thông điệp chứa chuỗi đã được chuẩn hóa lên server theo định dạng "requestId;data"

d. Đóng socket và kết thúc chương trình

---

##### BÀI 11. NHỎ THỨ HAI VÀ LỚN THỨ 2 [DataType]
[Mã câu hỏi (qCode): oQifsr90].
Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN004;99D9F604"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;z1,z2,...,z50"
requestId là chuỗi ngẫu nhiên duy nhất
z1 -> z50 là 50 số nguyên ngẫu nhiên

c. Thực hiện tính số lớn thứ hai và số nhỏ thứ hai của thông điệp trong z1 -> z50 và gửi thông điệp lên server theo định dạng "requestId;secondMax,secondMin"

d. Đóng socket và kết thúc chương trình

---

## PHẦN 3 - BỘ ĐỀ ÔN THI LẬP TRÌNH MẠNG – PHẦN UDP
*(Phần này sẽ lọc theo các MSV từ 001 đến hết. Cập nhật lần cuối: 01/12/2024)*

---

##### BÀI 12. TÌM SỐ CÒN THIẾU
[Mã câu hỏi (qCode): wAKCZwjj].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;73457A17"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n;A1,A2,...An" , với - requestId là chuỗi ngẫu nhiên duy nhất - n là một số ngẫu nhiên nhỏ hơn 100. - A1, A2 ... Am (m <= n) là các giá trị ngẫu nhiên nhỏ hơn hoặc bằng n và có thể trùng nhau.
Ex: requestId;10;2,3,5,6,5

c. Tìm kiếm các giá trị còn thiếu và gửi lên server theo định dạng "requestId;B1,B2,...,Bm"
Ex: requestId;1,4,7,8,9,10

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 13. ĐẾM SỐ LẦN XUẤT HIỆN
[Mã câu hỏi (qCode): vSgxl3HQ].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu xây dựng chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi một thông điệp chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;9F8C2D3A".

b. Nhận một thông điệp từ server theo định dạng "requestId;data", với:
    requestId là chuỗi ngẫu nhiên duy nhất.
    data là một chuỗi ký tự liên tiếp cần xử lý. Ví dụ: "requestId;aaabbbccdaa"

c. Xử lý chuỗi bằng cách đếm số lượng ký tự và gom chúng lại theo định dạng "số_lần_ký_tự".
Gửi kết quả về server theo định dạng: "requestId;processedData"
Ví dụ: Với chuỗi "aaabbbccdaa", kết quả sẽ là: "requestId;5a3b2c1d"

d. Đóng socket và kết thúc chương trình.

Dựa theo log xử lý, đề bài nên sửa là: Đếm số lần xuất hiện các ký tự trong cả xâu, liệt kê theo thứ tự xuất hiện

---

##### BÀI 14. LỌC KÝ TỰ
[Mã câu hỏi (qCode): GfeNSBMT].  [Loại bỏ ký tự đặc biệt, số, trùng và giữ nguyên thứ tự xuất hiện]
Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208 . Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;06D6800D"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;strInput"
• requestId là chuỗi ngẫu nhiên duy nhất
• strInput là chuỗi thông điệp cần xử lý

c. Thực hiện loại bỏ ký tự đặc biệt, số, ký tự trùng và giữ nguyên thứ tự xuất hiện của chúng.
Gửi thông điệp lên server theo định dạng "requestId;strOutput", trong đó strOutput là chuỗi đã được xử lý ở trên

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 15. MÃ HOÁ CAESAR
[Mã câu hỏi (qCode): J5SE2YXc].  Mật mã caesar, còn gọi là mật mã dịch chuyển, để giải mã thì mỗi ký tự nhận được sẽ được thay thế bằng một ký tự cách nó một đoạn s. Ví dụ: với s = 3 thì ký tự "A" sẽ được thay thế bằng ký tự "D".
Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu xây dựng chương trình client trao đổi thông tin với server theo kịch bản mô tả dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;825EE3A7"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;strEncode;s".
• requestId là chuỗi ngẫu nhiên duy nhất
• strEncode là chuỗi thông điệp bị mã hóa
• s là số nguyên chứa giá trị độ dịch của mã

c. Giải mã tìm thông điệp ban đầu và gửi lên server theo định dạng "requestId;strDecode"

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 16. KÝ TỰ XUẤT HIỆN NHIỀU LẦN NHẤT
[Mã câu hỏi (qCode): CvlqJmaa].  Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client tương tác với server kịch bản dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;EE29C059"

b. Nhận thông điệp từ server theo định dạng "requestId; data"
requestId là một chuỗi ngẫu nhiên duy nhất
data là chuỗi dữ liệu đầu vào cần xử lý
Ex: "requestId;Qnc8d5x78aldSGWWmaAAjyg3"

c. Tìm kiếm ký tự xuất hiện nhiều nhất trong chuỗi và gửi lên server theo định dạng "requestId;ký tự xuất hiện nhiều nhất: các vị trí xuất hiện ký tự đó"
ví dụ: "requestId;8:4,9,"

d. Đóng socket và kết thúc chương trình

---

##### BÀI 17. KHÁCH HÀNG
[Mã câu hỏi (qCode): 4MpxJ947].  Thông tin khách hàng được yêu cầu thay đổi định dạng lại cho phù hợp với khu vực, cụ thể:
a. Tên khách hàng cần được chuẩn hóa theo định dạng mới. Ví dụ: nguyen van hai duong -> DUONG, Nguyen Van Hai
b. Ngày sinh của khách hàng đang ở dạng mm-dd-yyyy, cần được chuyển thành định dạng dd/mm/yyyy. Ví dụ: 10-11-2012 → 11/10/2012
c. Tài khoản khách hàng được tạo từ các chữ cái in thường được sinh tự động từ họ tên khách hàng. Ví dụ: nguyen van hai duong → nvhduong

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2209. Yêu cầu là xây dựng một chương trình client giao tiếp với server theo mô tả sau:

a. Đối tượng trao đổi là thể hiện của lớp UDP.Customer được mô tả như sau
• Tên đầy đủ của lớp: UDP.Customer
• Các thuộc tính: id String, code String, name String, , dayOfBirth String, userName String
• Một Hàm khởi tạo với đầy đủ các thuộc tính được liệt kê ở trên
• Trường dữ liệu: private static final long serialVersionUID = 20151107;

b. Client giao tiếp với server theo các bước
• Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;EE29C059"
• Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Customer từ server. Trong đó, các thuộc tính id, code, name,dayOfBirth đã được thiết lập sẵn.
• Yêu cầu thay đổi thông tin các thuộc tính như yêu cầu ở trên và gửi lại đối tượng khách hàng đã được sửa đổi lên server với cấu trúc:
08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Customer đã được sửa đổi.
• Đóng socket và kết thúc chương trình.

---

##### BÀI 18. BÀI TOÁN QUẢN LÝ SINH VIÊN
[Mã câu hỏi (qCode): QABGDFxd].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2209. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản sau:
Đối tượng trao đổi là thể hiện của lớp UDP.Student được mô tả:
• Tên đầy đủ lớp: UDP.Student
• Các thuộc tính: id String,code String, name String, email String
• 02 Hàm khởi tạo:
o public Student(String id, String code, String name, String email)
o public Student(String code)
• Trường dữ liệu: private static final long serialVersionUID = 20171107
Thực hiện:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;EE29C059"

b. Yêu cầu:
Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Student từ server. Trong đó, các thông tin được thiết lập gồm id và name.

c. 
- Chuẩn hóa tên theo quy tắc: Chữ cái đầu tiên in hoa, các chữ cái còn lại in thường và gán lại thuộc tính name của đối tượng
- Tạo email ptit.edu.vn từ tên người dùng bằng cách lấy tên và các chữ cái bắt đầu của họ và tên đệm. Ví dụ: nguyen van tuan nam → namnvt@ptit.edu.vn. Gán giá trị này cho thuộc tính email của đối tượng nhận được
- Gửi thông điệp chứa đối tượng xử lý ở bước c lên Server với cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Customer đã được sửa đổi.

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 19. CHUẨN HOÁ XÂU KÝ TỰ
[Mã câu hỏi (qCode): NRVwBVvx].  Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;5B35BCC1"

b. Nhận thông điệp từ server theo định dạng "requestId;data"
requestId là một chuỗi ngẫu nhiên duy nhất
data là chuỗi dữ liệu cần xử lý

c. Xử lý chuẩn hóa chuỗi đã nhận thành theo nguyên tắc
i. Ký tự đầu tiên của từng từ trong chuỗi là in hoa
ii. Các ký tự còn lại của chuỗi là in thường
Gửi thông điệp chứa chuỗi đã được chuẩn hóa lên server theo định dạng "requestId;data"

d. Đóng socket và kết thúc chương trình

---

##### BÀI 20. HIỆU CỦA HAI TẬP KÝ TỰ
[Mã câu hỏi (qCode): JQCO3izC].  [Loại bỏ ký tự đặc biệt và ký tự trùng giữ nguyên thứ tự xuất hiện]
Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208 . Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản dưới đây:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN001;B34D51E0"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;str1;str2".
• requestId là chuỗi ngẫu nhiên duy nhất
• str1,str2 lần lượt là chuỗi thứ nhất và chuỗi thứ hai

c. Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai, giữ nguyên thứ tự xuất hiện. Gửi thông điệp là một chuỗi lên server theo định dạng "requestId;strOutput", trong đó chuỗi strOutput là chuỗi đã được xử lý ở trên.

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 21. TỔNG CÁC CHỮ SỐ
[Mã câu hỏi (qCode): 0Iend7Pp].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN011;A1F3D5"

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;num", với: - requestId là chuỗi ngẫu nhiên duy nhất. - num là một số nguyên lớn.

c. Tính tổng các chữ số trong num và gửi lại tổng này về server theo định dạng "requestId;sumDigits".

d. Đóng socket và kết thúc chương trình.

---

##### BÀI 22. LIỆT KÊ SỐ NGUYÊN TỐ
[Mã câu hỏi (qCode): 78CCQ6xD].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n, n", với: --- requestId là chuỗi ngẫu nhiên duy nhất. --- n là một số nguyên ngẫu nhiên ≤ 100.

c. Tính và gửi về server danh sách n số nguyên tố đầu tiên theo định dạng "requestId;p1,p2,...,pk", trong đó p1,p2,...,pk là các số nguyên tố.

d. Đóng socket và kết thúc chương trình.
