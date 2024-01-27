package vn.khanh.webbansach_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.khanh.webbansach_backend.dao.NguoiDungRepository;
import vn.khanh.webbansach_backend.entity.NguoiDung;
import vn.khanh.webbansach_backend.entity.ThongBao;
import vn.khanh.webbansach_backend.service.email.EmailService;

import java.util.UUID;

@Service
public class TaiKhoanService {
    @Autowired
    private EmailService emailService;
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
        // Gán và gửi thông tin kích hoạt
        nguoiDung.setMaKichHoat(taoMaKichHoat());
        nguoiDung.setDaKichHoat(false);

        NguoiDung nguoiDung1=nguoiDungRepository.save(nguoiDung);

        // Gửi email cho người dùng để họ kích hoạt
        guiEmailKichHoat(nguoiDung.getEmail(), nguoiDung.getMaKichHoat());
        return ResponseEntity.ok("Đăng ký thành công");
    }
    private String taoMaKichHoat(){
        // Tạo mã ngẫu nhiên
        return UUID.randomUUID().toString();
    }

    private void guiEmailKichHoat(String email, String maKichHoat){
        String subject = "Kích hoạt tài khoản của bạn tại WebBanSach";
        String text = "Vui lòng sử dụng mã sau để kich hoạt cho tài khoản <"+email+">:<html><body><br/><h1>"+maKichHoat+"</h1></body></html>";
        text+="<br/> Click vào đường link để kích hoạt tài khoản: ";
        String url = "http://localhost:3000/kich-hoat/"+email+"/"+maKichHoat;
        text+=("<br/> <a href="+url+">"+url+"</a> ");

        emailService.sendMessage("tunletest1.email@gmail.com", email, subject, text);
    }

    public ResponseEntity<?> kichHoatTaiKhoan(String email, String maKichHoat) {
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);

        if (nguoiDung == null) {
            return ResponseEntity.badRequest().body(new ThongBao("Người dùng không tồn tại!"));
        }

        if (nguoiDung.isDaKichHoat()) {
            return ResponseEntity.badRequest().body(new ThongBao("Tài khoản đã được kích hoạt!"));
        }

        if (maKichHoat.equals(nguoiDung.getMaKichHoat())) {
            nguoiDung.setDaKichHoat(true);
            nguoiDungRepository.save(nguoiDung);
            return ResponseEntity.ok("Kích hoạt tài khoản thành công!");
        } else {
            return ResponseEntity.badRequest().body(new ThongBao("Mã kích hoạt không chính xác!"));
        }
    }
}

