package vn.khanh.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name="sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_sach")
    private int maSach;

    @Column(name = "ten_sach", length = 255)
    private String tenSach;

    @Column(name="tenTacGia", length = 255)
    private String tenTacGia;

    @Column(name="isbn", length = 255)
    private String ISBN;

    @Column(name="mo_ta" , columnDefinition = "text")
    private String moTa;

    @Column(name="gia_niem_yet")
    private double giaNiemYet;

    @Column(name="gia_ban")
    private double giaBan;

    @Column(name="so_luong")
    private int soLuong;

    @Column(name="trung_binh_xep_hang")
    private double trungBinhXepHang;

    @Column(name="phan_tram_giam_gia")
    private double phanTramGiamGia;

    @ManyToMany(
            fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE}
    )
    @JoinTable(
            name = "sach_theloai",
            joinColumns = @JoinColumn(name="ma_sach"),
            inverseJoinColumns = @JoinColumn(name = "ma_the_loai")
    )
    List<TheLoai> danhSachTheLoai;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<HinhAnh> danhSachHinhAnh;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<SuDanhGia> danhSachSuDanhGia;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    List<ChiTietDonHang> danhSachChiTietDonHang;

    @OneToMany(mappedBy = "sach", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<SachYeuThich> danhSachSachYeuThich;
}
