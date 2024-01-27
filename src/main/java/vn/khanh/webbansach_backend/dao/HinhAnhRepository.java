package vn.khanh.webbansach_backend.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khanh.webbansach_backend.entity.HinhAnh;
import vn.khanh.webbansach_backend.entity.Sach;

import java.util.List;

@RepositoryRestResource(path = "hinh-anh")
public interface HinhAnhRepository extends JpaRepository<HinhAnh,Integer> {
    List<HinhAnh> findHinhAnhBySach(Sach sach);
    @Modifying
    @Transactional
    @Query("DELETE FROM HinhAnh i WHERE i.isIcon = false AND i.sach.maSach = :maSach")
    public void deleteHinhAnhWithFalseIconBySachId(@Param("maSach") int maSach);
}
