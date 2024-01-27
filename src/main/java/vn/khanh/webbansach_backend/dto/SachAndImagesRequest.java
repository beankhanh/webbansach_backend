package vn.khanh.webbansach_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.khanh.webbansach_backend.entity.HinhAnh;
import vn.khanh.webbansach_backend.entity.Sach;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SachAndImagesRequest {
    private Sach sach;
    private List<HinhAnh> hinhAnhList;

    // Getters and setters
}