package vn.khanh.webbansach_backend.entity;

import lombok.Data;

@Data
public class HinhAnh {
    private int maHinhAnh;
    private String tenHinhAnh;
    private boolean laIcon;
    private String duongDan;
    private String duLieuAnh;
    private Sach sach;
}
