package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class TaskRepository {
    private final List<Task> tasks= new ArrayList<>(Arrays.asList(
            new Task(1, "Thiết kế giao diện", "Làm UI/UX cho trang chủ", "high", 1),
            new Task(2, "Viết API đăng nhập", "Tạo API xác thực người dùng", "high", 2),
            new Task(3, "Kiểm thử ứng dụng", "Chạy test case hệ thống", "medium", 3),
            new Task(4, "Viết tài liệu", "Hoàn thiện tài liệu thiết kế", "low", 1),
            new Task(5, "Tối ưu hóa Database", "Tạo index cho bảng User", "high", 2),
            new Task(6, "Cấu hình Server", "Cài đặt môi trường Docker", "medium", 3),
            new Task(7, "Họp dự án", "Họp chốt yêu cầu Sprint 1", "high", 1),
            new Task(8, "Fix lỗi hiển thị", "Sửa lỗi CSS trên thiết bị di động", "low", 2),
            new Task(9, "Triển khai lên Cloud", "Push code lên AWS", "high", 3),
            new Task(10, "Báo cáo tuần", "Viết báo cáo tiến độ", "medium", 1)
    ));
    public List<Task> findAll(){
        return tasks;
    }
}
