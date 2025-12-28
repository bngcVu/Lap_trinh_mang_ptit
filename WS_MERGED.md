# BỘ ĐỀ ÔN THI LẬP TRÌNH MẠNG – PHẦN WEB SERVICE

---

## PHẦN 1 - ĐỀ KIỂM TRA PHẦN WEB SERVICE
*Cập nhật lần cuối: 14/12/2024*
*Địa chỉ thi: http://203.162.10.109/Webcms*

---

##### BÀI 1. PHÂN TÍCH RA THỪA SỐ NGUYÊN TỐ
[Mã câu hỏi (qCode): TwZpbqUg]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.

b. Thực hiện phân tích số nguyên nhận được thành các thừa số nguyên tố của nó và lưu các thừa số này vào một chuỗi kết quả.

c. Triệu gọi phương thức submitDataStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi các thừa số nguyên tố đã tính được trở lại server.
Ví dụ: Nếu số nguyên trong danh sách là 28 sẽ phân tích thành các thừa số nguyên tố "2, 2, 7".

d. Kết thúc chương trình client.

---

##### BÀI 2. SẮP XẾP CHUỖI THEO SỐ NGUYÊN ÂM
[Mã câu hỏi (qCode): mDN1MFUJ]. Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.

a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng chuỗi (List<String>) từ server.

b. Sắp xếp các chuỗi trong mảng theo số lượng nguyên âm tăng dần. Nếu hai chuỗi có cùng số lượng nguyên âm, giữ nguyên thứ tự xuất hiện ban đầu của chúng trong mảng.

c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String> data) để gửi mảng chuỗi đã sắp xếp trở lại server.
Ví dụ: ["apple", "kiwi", "banana", "pear"] → ["apple", "kiwi", "pear", "banana"]

d. Kết thúc chương trình client.

---

##### BÀI 3. BÀI TOÁN QUẢN LÝ SINH VIÊN
[Mã câu hỏi (qCode): 2RjVBzv0]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestListStudentY với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng StudentY từ server. Mỗi đối tượng Student có các thuộc tính:
• studentId: kiểu String, đại diện cho mã sinh viên.
• name: kiểu String, đại diện cho tên sinh viên.
• subject: kiểu String, đại diện cho tên môn học.
• score: kiểu float, đại diện cho điểm số của sinh viên trong môn học.

b. Thực hiện: Lọc và giữ lại sinh viên có điểm số cao nhất theo từng môn học

c. Triệu gọi phương thức submitListStudentY(String studentCode, String qCode, List<StudentY> studentYs) để gửi danh sách sinh viên đạt điểm cao nhất theo từng môn học trở lại server. (Lưu ý bảo toàn vị trí xuất hiện của sinh viên trong danh sách ban đầu)

d. Kết thúc chương trình client.

---

##### BÀI 4. ĐẾM SỐ LẦN XUẤT HIỆN
[Mã câu hỏi (qCode): TU4ULIgh]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.

b. Với mảng số nguyên nhận được, thực hiện đếm số lần xuất hiện của từng phần tử trong mảng và lưu kết quả vào một chuỗi theo định dạng: giá trị của phần tử, số lần xuất hiện tương ứng của nó.

c. Triệu gọi phương thức submitDataStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi kết quả chứa cặp giá trị [phần tử, tần suất] của từng phần tử đã tính được trở lại server.
Ví dụ: [1, 2, 2, 3, 3, 3] → ["1, 1", "2, 2", "3, 3"]

> [!NOTE]
> Bài này chú ý sắp xếp dãy tăng dần.

d. Kết thúc chương trình client.

---

##### BÀI 5. BÀI TOÁN QUẢN LÝ SẢN PHẨM
[Mã câu hỏi (qCode): itT8hvxF]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestProductY với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một đối tượng ProductY từ server. Đối tượng này có các thuộc tính:
• price (giá gốc): float, đại diện cho giá của sản phẩm.
• taxRate (thuế): float, đại diện cho phần trăm thuế áp dụng trên giá gốc.
• discount (chiết khấu): float, đại diện cho phần trăm chiết khấu áp dụng trên giá gốc.

b. Thực hiện:
• Tính toán giá cuối cùng của sản phẩm (finalPrice) theo công thức: finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100)
• Cập nhật thuộc tính finalPrice trong đối tượng Product với giá trị đã tính toán.

c. Triệu gọi phương thức submitProductY(String studentCode, String qCode, ProductY object) để gửi đối tượng ProductY với giá cuối cùng đã được tính toán trở lại server.
Ví dụ: price = 100.0, taxRate = 10.0, discount = 5.0 → finalPrice = 104.5

d. Kết thúc chương trình client.

---

##### BÀI 6. PHẦN TỬ LỚN THỨ K VÀ NHỎ THỨ K
[Mã câu hỏi (qCode): WpaUTFMu]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên (List<Integer>) từ server. Phần tử đầu tiên của mảng này là giá trị K.

b. Với mảng số nguyên nhận được, sử dụng giá trị K (phần tử đầu tiên của mảng) để xác định phần tử lớn thứ K và nhỏ thứ K trong các phần tử còn lại của mảng (loại bỏ phần tử đầu tiên khi tính toán).

c. Triệu gọi phương thức submitDataIntArray(String studentCode, String qCode, List<Integer> data) để gửi mảng kết quả chứa: phần tử lớn thứ K, phần tử nhỏ thứ K đã tìm được trở lại server.
Ví dụ: [3, 5, 1, 4, 2] → K=3, kết quả [2, 4]

d. Kết thúc chương trình client.

---

##### BÀI 7. SẮP XẾP CHUỖI THEO ĐỘ DÀI CHUỖI
[Mã câu hỏi (qCode): mpu9xCxR]. Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.

a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng chuỗi (List<String>) từ server.

b. Sắp xếp mảng theo độ dài của từ theo thứ tự tăng dần độ dài của từ.

c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String>) để gửi mảng chuỗi đã sắp xếp trở lại server.
Ví dụ: ["apple", "banana", "fig", "pineapple"] → ["fig", "apple", "banana", "pineapple"]

d. Kết thúc chương trình client.

---

##### BÀI 8. BÀI TOÁN PHÂN LOẠI HỌC LỰC SINH VIÊN
[Mã câu hỏi (qCode): qNfIMvid]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestListStudent với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách đối tượng Student từ server. Mỗi đối tượng Student có các thuộc tính:
• name: kiểu String, đại diện cho tên của sinh viên.
• score: kiểu float, đại diện cho điểm trung bình của sinh viên.

b. Thực hiện tạo danh sách phân nhóm các sinh viên dựa trên điểm trung bình theo các mức sau: A: điểm từ 8.0 trở lên; B: điểm từ 6.5 đến dưới 8.0; C: điểm từ 5.0 đến dưới 6.5; D: điểm dưới 5.0

c. Triệu gọi phương thức submitListStudent(String studentCode, String qCode, List<Student> students) để gửi danh sách sinh viên thuộc nhóm A và D.

d. Kết thúc chương trình client.

---

##### BÀI 9. LIỆT KÊ CÁC ƯỚC SỐ CỦA MỘT SỐ TỰ NHIÊN
[Mã câu hỏi (qCode): nhFjYg0F]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getDataDouble với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một số thập phân (double) từ server.

b. Lấy phần nguyên của số thập phân nhận được. Liệt kê tất cả các ước số của phần nguyên này và đếm số lượng ước số. Kết quả sẽ là một danh sách số nguyên, trong đó phần tử đầu tiên là số lượng ước số và các phần tử tiếp theo là các ước số theo thứ tự tăng dần.

c. Triệu gọi phương thức submitDataIntArray(String studentCode, String qCode, List<Integer> data) để gửi mảng kết quả chứa số lượng ước số và danh sách các ước trở lại server.
Ví dụ: 12.6758 → [6, 1, 2, 3, 4, 6, 12]

d. Kết thúc chương trình client.

---

##### BÀI 10. BÀI TOÁN QUẢN LÝ NHÂN VIÊN
[Mã câu hỏi (qCode): vewbvojZ]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestListEmployeeY với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách đối tượng EmployeeY từ server. Mỗi đối tượng Employee có các thuộc tính:
• name: kiểu String, đại diện cho tên của nhân viên.
• startDate: kiểu Date, đại diện cho ngày bắt đầu làm việc của nhân viên.

b. Sắp xếp danh sách Employee theo thứ tự thâm niên từ cao đến thấp (người có ngày bắt đầu làm việc sớm nhất sẽ đứng đầu danh sách). Nếu hai nhân viên có cùng ngày bắt đầu làm việc, giữ nguyên thứ tự ban đầu của họ trong danh sách.

c. Triệu gọi phương thức submitListEmployeeY(String studentCode, String qCode, List<EmployeeY> data) để gửi danh sách nhân viên đã sắp xếp trở lại server.

d. Kết thúc chương trình client.

---

##### BÀI 11. TỪ DÀI NHẤT VÀ TỪ NGẮN NHẤT
[Mã câu hỏi (qCode): 9n2rfqST]. Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.

a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server. Chuỗi này có thể chứa các từ và khoảng trắng.

b. Xử lý chuỗi nhận được để tìm từ có độ dài lớn nhất và từ có độ dài nhỏ nhất trong chuỗi. Nếu có nhiều từ có cùng độ dài lớn nhất hoặc nhỏ nhất, chọn từ xuất hiện đầu tiên trong chuỗi.

c. Tạo một chuỗi mới theo định dạng: "[từ lớn nhất]; [từ nhỏ nhất]".

d. Triệu gọi phương thức submitCharacterString(String studentCode, String qCode, String data) để gửi chuỗi kết quả đã xử lý trở lại server. Ví dụ: "this is a sample test" → "sample; a"

e. Kết thúc chương trình client.

---

##### BÀI 12. BÀI TOÁN QUẢN LÝ KHÁCH HÀNG
[Mã câu hỏi (qCode): aYiLQ3wo]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestListCustomerY với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng CustomerY từ server. Mỗi đối tượng CustomerY có các thuộc tính:
• customerId: kiểu String, đại diện cho mã khách hàng.
• lastTransactionDate: kiểu Date, đại diện cho ngày giao dịch gần nhất của khách hàng.

b. Lọc và giữ lại các khách hàng chưa có giao dịch nào trong vòng 6 tháng qua (so với ngày hiện tại).

c. Triệu gọi phương thức submitListCustomerY(String studentCode, String qCode, List<CustomerY> customerYs) để gửi danh sách các khách hàng không hoạt động trong 6 tháng trở lại server.

d. Kết thúc chương trình client.

---

##### BÀI 13. TÌM SỐ LỚN NHẤT
[Mã câu hỏi (qCode): RiRH8wfk]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên (int[]) từ server.
Ví dụ: 7602,9136,1090,34319,7830,6179,10584,20166,28199,30250,32179,22544,3222,10320,30590,19279

b. Thực hiện tìm số lớn nhất có thể tạo được từ a,b,c,d...

c. Triệu gọi phương thức submitDataString(String studentCode, String qCode, String data) để gửi kết quả tổng đã tính được trở lại server.
Ví dụ: 91367830760261793431932223217930590302502819922544201661927910901058410320

d. Kết thúc chương trình client.

---

##### BÀI 14. CHUẨN HOÁ CHUỖI
[Mã câu hỏi (qCode): sBQjqANT]. Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.

a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server. Chuỗi có thể chứa các từ được phân tách bằng dấu cách hoặc dấu gạch dưới.

b. Chuyển đổi chuỗi đã nhận được sang ba định dạng khác nhau:
• PascalCase: Mỗi từ bắt đầu bằng chữ in hoa, không có khoảng cách giữa các từ.
• camelCase: Từ đầu tiên viết thường, các từ tiếp theo viết hoa chữ cái đầu và viết liền nhau.
• snake_case: Các từ được viết thường và nối với nhau bằng dấu gạch dưới.

c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String>) để gửi mảng kết quả chứa ba chuỗi đã định dạng trở lại server, theo thứ tự: PascalCase, camelCase, snake_case.
Ví dụ: "hello world example" → ["HelloWorldExample", "helloWorldExample", "hello_world_example"]

d. Kết thúc chương trình client.

---

##### BÀI 15. LỌC KÝ TỰ
[Mã câu hỏi (qCode): rT6Ql5GH]. Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.

a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server. Chuỗi có thể chứa các ký tự đặc biệt và khoảng trắng.

b. Tạo một chuỗi mới từ chuỗi nhận được bằng cách:
• Loại bỏ tất cả các ký tự đặc biệt, số, chỉ các ký tự chữ cái.
• Đảo ngược chuỗi kết quả sau khi đã loại bỏ các ký tự đặc biệt.

c. Triệu gọi phương thức submitCharacterString(String studentCode, String qCode, String cleanedAndReversedString) để gửi chuỗi đã được làm sạch và đảo ngược trở lại server.
Ví dụ: "hello@ world! 2024" → "helloworld" → "dlrowolleh"

d. Kết thúc chương trình client.

---

##### BÀI 16. BÀI TOÁN QUẢN LÝ ĐƠN HÀNG
[Mã câu hỏi (qCode): 46WF6Fg5]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestListOrderY với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng OrderY từ server. Mỗi đối tượng OrderY có các thuộc tính:
• orderId: kiểu String, đại diện cho mã đơn hàng.
• orderDate: kiểu Date, đại diện cho ngày đặt hàng.
• status: kiểu String, đại diện cho trạng thái đơn hàng, với các trạng thái có thể là "pending", "processing", hoặc "completed".
• customerId: kiểu String, đại diện cho mã khách hàng.

b. Lọc ra các đơn hàng có trạng thái là "pending" hoặc "processing" và có ngày đặt hàng (orderDate) trong vòng 30 ngày trở lại từ ngày hiện tại để tạo danh sách các đơn hàng cần được ưu tiên xử lý.

c. Triệu gọi phương thức submitListOrderY(String studentCode, String qCode, List<OrderY> orderYs) để gửi danh sách đơn hàng đã được lọc trở lại server.

d. Kết thúc chương trình client.

---

##### BÀI 17. BÀI TOÁN QUẢN LÝ DỰ ÁN
[Mã câu hỏi (qCode): R6UOuyyE]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestListProject với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng Project từ server. Mỗi đối tượng Project có các thuộc tính:
• projectId: kiểu String, đại diện cho mã dự án.
• projectName: kiểu String, đại diện cho tên dự án.
• completionPercentage: kiểu float, đại diện cho tỷ lệ hoàn thành của dự án (tính theo %).
• dueDate: kiểu Date, đại diện cho hạn hoàn thành của dự án.

b. Lọc và giữ lại các dự án có completionPercentage từ 80% trở lên và có hạn hoàn thành (dueDate) trong vòng 15 ngày tới (tính từ ngày hiện tại).

c. Triệu gọi phương thức submitListProject(String studentCode, String qCode, List<Project> projects) để gửi danh sách các dự án gần hoàn thành và cần ưu tiên trở lại server.

d. Kết thúc chương trình client.

---

##### BÀI 18. TỪ DÀI NHẤT VÀ TỪ NGẮN NHẤT – 2
[Mã câu hỏi (qCode): sGJc3iD5]. Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.

a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách chuỗi (List<String>) từ server.

b. Xác định từ có độ dài lớn nhất và từ có độ dài nhỏ nhất trong mảng chuỗi. Nếu có nhiều từ có cùng độ dài lớn nhất hoặc nhỏ nhất, chọn từ xuất hiện đầu tiên trong mảng.

c. Tạo một chuỗi mới theo định dạng: "Longest;Shortest".

d. Triệu gọi phương thức submitCharacterString(String studentCode, String qCode, String data) để gửi chuỗi kết quả đã xử lý trở lại server. Ví dụ: ["apple", "banana", "fig", "pineapple"] → "pineapple;fig"

e. Kết thúc chương trình client.

---

##### BÀI 19. CHUYỂN ĐỔI SỐ THẬP PHÂN SANG PHÂN SỐ
[Mã câu hỏi (qCode): ny8Fb8BU]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getDataDouble với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một số thập phân (double) từ server.

b. Chuyển đổi số thập phân nhận được thành phân số đơn giản nhất, biểu diễn dưới dạng tử số và mẫu số nguyên (List<Integer>) với phần tử đầu tiên là tử số và phần tử thứ hai là mẫu số.

c. Triệu gọi phương thức submitDataIntArray(String studentCode, String qCode, List<Integer> data) để gửi phân số đơn giản nhất đã chuyển đổi trở lại server.
Ví dụ: 0.75 → [3, 4]

d. Kết thúc chương trình client.

---

##### BÀI 20. NHÓM CÁC TỪ THEO CÙNG SỐ NGUYÊN ÂM
[Mã câu hỏi (qCode): 32He7sZg]. Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.

a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng chuỗi (String[]) từ server.

b. Phân loại các từ trong mảng chuỗi thành các nhóm có cùng số lượng nguyên âm. Tạo một chuỗi cho mỗi nhóm, trong đó liệt kê các từ cách nhau bằng dấu phẩy, và sắp xếp các từ theo thứ tự từ điển trong mỗi nhóm.

c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, String[] data) để gửi mảng chuỗi kết quả trở lại server, trong đó mỗi phần tử là một nhóm từ với cùng số lượng nguyên âm.
Ví dụ: ["apple", "banana", "pear", "grape", "kiwi"] → ["apple, banana", "grape, kiwi, pear"]

> [!NOTE]
> Sắp xếp theo nguyên tắc: Số nguyên âm tăng dần theo từng nhóm.

d. Kết thúc chương trình client.

---

##### BÀI 21. BÀI TOÁN QUẢN LÝ KHÁCH HÀNG - 2
[Mã câu hỏi (qCode): lgKj7lIF]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestListCustomer với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng Customer từ server. Mỗi đối tượng Customer có các thuộc tính:
• customerId: kiểu String, đại diện cho mã khách hàng.
• location: kiểu String, đại diện cho địa điểm của khách hàng.
• purchaseCount: kiểu int, đại diện cho số lần mua hàng của khách hàng.
• totalSpent: kiểu float, đại diện cho tổng số tiền đã chi tiêu của khách hàng.

b. Lọc và giữ lại các khách hàng tại từng địa điểm (location) có totalSpent lớn hơn 5000 và có purchaseCount từ 5 trở lên.

c. Triệu gọi phương thức submitListCustomer(String studentCode, String qCode, List<Customer> customers) để gửi danh sách các khách hàng tiềm năng theo từng địa điểm trở lại server.

d. Kết thúc chương trình client.

---

##### BÀI 22. XOAY VÒNG KÝ TỰ
[Mã câu hỏi (qCode): YDcPHFgN]. Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.

a. Triệu gọi phương thức requestCharacter với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng ký tự (List<Character>) từ server.

b. Thực hiện xoay vòng các ký tự trong mảng theo chiều phải, số lần xoay vòng bằng đúng kích thước của mảng ký tự đã nhận được.

c. Triệu gọi phương thức submitCharacterCharArray(String studentCode, String qCode, List<Character> data) để gửi mảng ký tự đã xoay vòng trở lại server.
Ví dụ: ['a', 'b', 'c', 'd'] xoay phải 4 lần → ['b', 'c', 'd', 'a']

d. Kết thúc chương trình client.

---

##### BÀI 23. CHUYỂN ĐỔI THẬP PHÂN SANG NHỊ PHÂN
[Mã câu hỏi (qCode): 2jS1DTpU]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên (List<Integer>) từ server.

b. Chuyển đổi số nguyên nhận được từ hệ thập phân sang hệ nhị phân và biểu diễn kết quả dưới dạng chuỗi nhị phân.

c. Triệu gọi phương thức submitDataStringArray(String studentCode, String qCode, List<String> data) để gửi chuỗi nhị phân đã chuyển đổi trở lại server. Ví dụ: 10 → "1010"

d. Kết thúc chương trình client.

---

##### BÀI 24. BÀI TOÁN QUẢN LÝ ĐƠN HÀNG - 2
[Mã câu hỏi (qCode): CuW1L0ev]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestListOrder với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng Order từ server.
• customerId: kiểu String, đại diện cho mã khách hàng.
• amount: kiểu float, đại diện cho giá trị của đơn hàng.
• status: kiểu String, đại diện cho trạng thái của đơn hàng.

b. Thực hiện lọc và chỉ giữ lại các hóa đơn của khách hàng có tổng giá trị đơn hàng cao nhất

c. Triệu gọi phương thức submitListOrder(String studentCode, String qCode, List<Order> data) để gửi danh sách hóa đơn của khách hàng có tổng giá trị đơn hàng cao nhất.

d. Kết thúc chương trình client.

---

##### BÀI 25. HỆ CƠ SỐ 8 VÀ 16
[Mã câu hỏi (qCode): QBDJ1GGL]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.

b. Chuyển đổi số nguyên nhận được từ hệ thập phân sang cả hệ cơ số 8 (bát phân) và hệ cơ số 16 (thập lục phân). Biểu diễn kết quả dưới dạng chuỗi cho mỗi hệ cơ số.

c. Triệu gọi phương thức submitDataStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi kết quả.
Ví dụ: 64 → "100|40"

> [!NOTE]
> Bài này chú ý là in ra hệ hexa phải viết hoa.

d. Kết thúc chương trình client.

---

##### BÀI 26. LOẠI BỎ SỐ TRÙNG NHAU
[Mã câu hỏi (qCode): E2Axwwf3]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.

b. Với mảng số nguyên nhận được, xóa tất cả các phần tử trùng lặp, giữ lại lần xuất hiện đầu tiên của mỗi phần tử.

c. Triệu gọi phương thức submitDataIntArray(String studentCode, String qCode, List<Integer> data) để gửi mảng kết quả đã loại bỏ các phần tử trùng lặp trở lại server.
Ví dụ: [1, 2, 2, 3, 4, 3, 5] → [1, 2, 3, 4, 5]

d. Kết thúc chương trình client.

---

##### BÀI 27. TỔNG CÁC SỐ TRONG MẢNG
[Mã câu hỏi (qCode): hnVAHv3I]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên (List<Integer>) từ server.

b. Thực hiện tính toán tổng của tất cả các phần tử trong mảng số nguyên nhận được.

c. Triệu gọi phương thức submitDataInt(String studentCode, String qCode, int data) để gửi kết quả tổng đã tính được trở lại server.
Ví dụ: [1, 2, 3, 4, 5] → 15

d. Kết thúc chương trình client.

---

##### BÀI 28. BÀI TOÁN QUẢN LÝ NHÂN VIÊN – 2
[Mã câu hỏi (qCode): L8CainEX]. Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.

a. Triệu gọi phương thức requestEmployee với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một đối tượng Employee từ server.
• startDate: kiểu Date, đại diện cho ngày bắt đầu công việc của nhân viên.
• endDate: kiểu Date, đại diện cho ngày kết thúc công việc của nhân viên.

b. Tính toán số ngày làm việc (workingDays) giữa startDate và endDate, loại trừ các ngày cuối tuần (thứ Bảy và Chủ Nhật). Cập nhật thuộc tính workingDays trong đối tượng Employee với giá trị đã tính toán.

c. Triệu gọi phương thức submitEmployee(String studentCode, String qCode, Employee object) để gửi đối tượng Employee với số ngày làm việc đã được tính toán trở lại server.
Ví dụ: startDate = 01-09-2023 (thứ Sáu), endDate = 07-09-2023 (thứ Năm) → workingDays = 5

d. Kết thúc chương trình client.

---

##### BÀI 29. SẮP XẾP CHẴN LẺ
[Mã câu hỏi (qCode): 0BEtJAT9]. Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.

a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một mảng số nguyên (int[]) từ server.

b. Sắp xếp lại mảng số nguyên nhận được sao cho phần tử chẵn và lẻ xen kẽ nhau. Nếu không thể xen kẽ đều, các phần tử còn lại sẽ nối tiếp ở cuối mảng. Đảm bảo các phần tử chẵn ở vị trí đầu tiên trong mảng sắp xếp.

c. Triệu gọi phương thức submitDataIntArray(String studentCode, String qCode, int[] data) để gửi mảng đã sắp xếp theo thứ tự chẵn-lẻ xen kẽ trở lại server.
Ví dụ: [1, 2, 3, 4, 5, 6] → [2, 1, 4, 3, 6, 5]

d. Kết thúc chương trình client.

---

## PHẦN 2 - ĐỀ DẠNG MỚI (WS + UDP)

---

##### BÀI 30. HỆ THỐNG HỖ TRỢ SẢN PHẨM KHUYẾN MÃI
Một hệ thống hỗ trợ các sản phẩm khuyến mãi cho sinh viên gồm 2 thành phần như sau:

**Thành phần 1 - WebService:**
Triển khai tại địa chỉ http://203.162.10.109:8080/ProductService/ProductS?wsdl cung cấp chức năng cho phép client nhận thông tin sản phẩm khuyến mãi (getProduct) và đặt hàng (Order)

**Thành phần 2 - UDP Server:**
Cung cấp chức năng cho phép client lấy thông tin khuyến mãi theo mã sản phẩm

**Kịch bản giao tiếp:**

a. Triệu gọi phương thức getProduct nhận tham số đầu vào là mã sinh viên để nhận về đối tượng Product với giá trị của id và code được thiết lập

b. Gửi thông điệp là một chuỗi chứa id và code sản phẩm đã nhận được đến UDP server tại cổng 2208 theo định dạng "id;code" để nhận về chuỗi mã giảm giá ngẫu nhiên. Tổng các chữ số trong mã giảm giá này chính là giá trị khuyến mãi của sản phẩm

c. Triệu gọi phương thức order trên WS với tham số đầu vào là đối tượng Product với đầy đủ thông tin cần thiết để đặt sản phẩm

d. Kết thúc chương trình

---
