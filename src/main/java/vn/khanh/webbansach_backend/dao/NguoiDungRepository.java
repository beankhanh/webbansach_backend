package vn.khanh.webbansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khanh.webbansach_backend.entity.NguoiDung;
@RepositoryRestResource(path = "nguoi-dung")
public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {
    boolean existsByTenDangNhap(String tenDangNhap);
    boolean existsByEmail(String email);
    NguoiDung findByTenDangNhap(String tenDangNhap);
    NguoiDung findByEmail(String email);
}
