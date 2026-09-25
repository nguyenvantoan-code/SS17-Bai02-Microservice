# Bài Tập 2: Triển khai Lazy Loading với @Cacheable

## 1. Mục tiêu
- Áp dụng Lazy Loading, chỉ truy vấn Database một lần.
- Đánh dấu annotation `@Cacheable(value = "restaurantMenu", key = "#id")`.
- Phân biệt Cache Hit và Cache Miss.

## 2. Chi tiết thực hiện
- Phương thức `getMenuByRestaurantId(Long id)` có chứa block `Thread.sleep(3000)` để mô phỏng một câu query JOIN nhiều bảng rất chậm chạp.
- Lần đầu API được gọi (Ví dụ `id=101`), hệ thống chưa có dữ liệu trong Cache (Cache Miss). Ứng dụng in ra log `--- Thực hiện truy vấn DB cho restaurantId: 101 ---` và mất khoảng 3 giây để trả kết quả. 
- Sau đó, dữ liệu được ghi vào bộ nhớ đệm (Cache) theo phương pháp Lazy Loading.
- Ở những lần gọi kế tiếp cùng tham số `id=101`, hệ thống nhận thấy dữ liệu đã có trong Cache (Cache Hit). Kết quả lập tức được trả về (< 20ms) mà không in ra dòng log truy vấn DB nào.

## 3. Ảnh chụp chứng minh
*(Đính kèm ảnh kết quả Postman cho thấy chênh lệch thời gian giữa 2 lần query, và ảnh log console)*
