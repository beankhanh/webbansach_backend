package vn.khanh.webbansach_backend.entity;

import lombok.Data;

import java.util.List;

@Data
public class TheLoai {
    private int maTheLoai;
    public String tenTheLoai;
    private List<Sach> sach;
}
