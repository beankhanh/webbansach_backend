package vn.khanh.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="su_danh_gia")
public class SuDanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_danh_gia")
    private long maDanhGia;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "ma_sach")
    private Sach sach;
    @Column(name="diem_danh_gia")
    private float diemDanhGia;
    @Column(name="nhan_xet")
    private String nhanXet;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="ma_nguoi_dung")
    private NguoiDung nguoiDung;
}
