package vn.khanh.webbansach_backend.entity;

import lombok.Data;

@Data
public class SuDanhGia {
    private long maDanhGia;
    private Sach sach;
    private float diemDanhGia;
    private String nhanXet;
    private NguoiDung nguoiDung;
}
