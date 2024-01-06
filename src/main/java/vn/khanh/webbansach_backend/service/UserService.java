package vn.khanh.webbansach_backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import vn.khanh.webbansach_backend.entity.NguoiDung;

public interface UserService extends UserDetailsService {
    public NguoiDung findByUsername(String tenDangNhap);

}
