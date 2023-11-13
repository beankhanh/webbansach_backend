package vn.khanh.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="hinh_thuc_thanh_toan")
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_hinh_thuc_thanh_toan")
    private int maHinhThucThanhToan;
    @Column(name="ten_hinh_thuc_thanh_toan")
    private String tenHinhThucThanhToan;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name="chi_phi_thanh_toan")
    private double chiPhiThanhToan;
    @OneToMany(mappedBy = "hinhThucThanhToan",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    private List<DonHang> danhSachDonHang;
}
