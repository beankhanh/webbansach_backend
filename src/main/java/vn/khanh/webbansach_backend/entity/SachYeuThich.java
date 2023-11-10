package vn.khanh.webbansach_backend.entity;

import lombok.Data;

@Data
public class SachYeuThich {
    private int maSachYeuThich;
    private Sach sach;
    private NguoiDung nguoiDung;
}
