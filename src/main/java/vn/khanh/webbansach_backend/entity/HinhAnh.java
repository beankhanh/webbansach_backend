package vn.khanh.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="hinh_anh")
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_hinh_anh")
    private int maHinhAnh;

    @Column(name="ten_hinh_anh" , length = 255)
    private String tenHinhAnh;

    @Column(name="la_icon")
    private boolean isIcon;

    @Column(name="duong_dan")
    private String duongDan;

    @Column(name="du_lieu_anh" , columnDefinition = "LONGTEXT")
    @Lob
    private String duLieuAnh;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
    @JoinColumn(name = "ma_sach", nullable = false)
    private Sach sach;
}
