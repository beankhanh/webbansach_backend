package vn.khanh.webbansach_backend.entity;

import lombok.Data;

import java.util.List;
@Data
public class Quyen {
    private int maQuyen;
    private String tenQuyen;
    private List<NguoiDung> danhSachNguoiDung;
}
