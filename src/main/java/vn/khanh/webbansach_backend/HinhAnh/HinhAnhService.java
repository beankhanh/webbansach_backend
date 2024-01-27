package vn.khanh.webbansach_backend.HinhAnh;

import org.springframework.web.multipart.MultipartFile;
import vn.khanh.webbansach_backend.entity.HinhAnh;

import java.util.List;

public interface HinhAnhService {
    String uploadImage(MultipartFile multipartFile, String name);
    void deleteImage(String imgUrl);
}
