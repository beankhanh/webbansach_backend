package vn.khanh.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="chi_tiet_don_hang")
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_chi_tiet_don_hang")
    private Long maChiTietDonHang;
    @Column(name="so_luong")
    private int soLuong;
    @Column(name="gia_ban")
    private double giaBan;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="ma_sach")
    private Sach sach;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="ma_don_hang")
    private DonHang donHang;
}

