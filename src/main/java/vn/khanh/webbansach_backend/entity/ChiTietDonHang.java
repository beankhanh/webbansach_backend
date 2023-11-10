package vn.khanh.webbansach_backend.entity;

import lombok.Data;

@Data
public class ChiTietDonHang {
    private int maChiTietDonHang;
    private int soLuong;
    private double giaBan;
    private Sach sach;
    private DonHang donHang;
}

