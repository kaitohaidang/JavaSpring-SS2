# Thiết kế Kiến trúc RESTful API: Hệ thống Quản lý Task và User

## 1. Quản lý Người dùng (Users)

| Chức năng | HTTP Method | Endpoint | Mô tả | Dữ liệu gửi đi (Body/Params) |
| :--- | :--- | :--- | :--- | :--- |
| Lấy danh sách người dùng | `GET` | `/api/v1/users` | Trả về danh sách toàn bộ users. | Không |
| Tạo mới người dùng | `POST` | `/api/v1/users` | Thêm một user mới vào hệ thống. | JSON: `{ "name": "...", "email": "..." }` |
| Cập nhật vai trò | `PATCH` | `/api/v1/users/{id}` | Cập nhật vai trò (role) của user theo ID. | JSON: `{ "role": "admin" }` |
| Xóa người dùng | `DELETE` | `/api/v1/users/{id}` | Xóa một user khỏi hệ thống theo ID. | Không |

---

## 2. Quản lý Công việc (Tasks)

| Chức năng | HTTP Method | Endpoint | Mô tả | Dữ liệu gửi đi (Body/Params) |
| :--- | :--- | :--- | :--- | :--- |
| Lấy danh sách công việc | `GET` | `/api/v1/tasks` | Trả về danh sách toàn bộ tasks. | Không |
| Tạo mới công việc | `POST` | `/api/v1/tasks` | Tạo một task mới. | JSON: `{ "title": "...", "priority": "..." }` |
| Cập nhật trạng thái | `PATCH` | `/api/v1/tasks/{id}` | Sửa trạng thái của task theo ID. | JSON: `{ "status": "completed" }` |
| Xóa công việc | `DELETE` | `/api/v1/tasks/{id}` | Xóa một task khỏi hệ thống theo ID. | Không |
| Gắn task cho user | `PATCH` | `/api/v1/tasks/{id}` | Gán/Đổi user thực hiện công việc. | JSON: `{ "userId": 1 }` |

---

## 3. Các chức năng Lọc (Filtering) và Mối quan hệ (Nested Routes)

| Chức năng | HTTP Method | Endpoint | Mô tả |
| :--- | :--- | :--- | :--- |
| Tìm Task ưu tiên cao | `GET` | `/api/v1/tasks?priority=high` | Sử dụng Query Parameter để lọc danh sách task. |
| Liệt kê Task của 1 User | `GET` | `/api/v1/users/{userId}/tasks` | Nested route: Lấy toàn bộ công việc thuộc về user có id là `{userId}`. |
| Lọc Task của 1 User | `GET` | `/api/v1/users/{userId}/tasks?priority=high` | Kết hợp Nested route và Query Param: Tìm task ưu tiên cao được giao cho `{userId}`. |

---

