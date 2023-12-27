package vn.khanh.webbansach_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.khanh.webbansach_backend.entity.NguoiDung;
import vn.khanh.webbansach_backend.service.TaiKhoanService;

@RequestMapping("/tai-khoan")
@RestController
public class DangKyController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/dang-ky")
    public ResponseEntity<?> dangKyTaiKhoan(@Validated @RequestBody NguoiDung nguoiDung){
        ResponseEntity<?> response = taiKhoanService.dangKyNguoiDung(nguoiDung);
        return response;
    }
}
