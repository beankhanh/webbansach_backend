package vn.khanh.webbansach_backend.entity;

import lombok.Data;

import java.util.List;

@Data
public class HinhThucGiaoHang {
    private int maHinhThucGiaoHang;
    private String tenHinhThucGiaoHang;
    private String moTa;
    private double chiPhiGiaoHang;
    private List<DonHang> danhSachDonHang;
}
