package vn.khanh.webbansach_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.khanh.webbansach_backend.dao.NguoiDungRepository;
import vn.khanh.webbansach_backend.entity.NguoiDung;
import vn.khanh.webbansach_backend.entity.ThongBao;

@Service
public class TaiKhoanService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    public ResponseEntity<?> dangKyNguoiDung(NguoiDung nguoiDung){
        if(nguoiDungRepository.existsByTenDangNhap(nguoiDung.getTenDangNhap())){
            return ResponseEntity.badRequest().body(new ThongBao("Tên đăng nhập đã tồn tại"));
        }
        if(nguoiDungRepository.existsByEmail(nguoiDung.getEmail())){
            return ResponseEntity.badRequest().body(new ThongBao("Tên Email đã tồn tại"));
        }
        String encryptPassword = passwordEncoder.encode(nguoiDung.getMatKhau());
        nguoiDung.setMatKhau(encryptPassword);
        NguoiDung nguoiDung1=nguoiDungRepository.save(nguoiDung);
        return ResponseEntity.ok("Đăng ký thành công");
    }
}
