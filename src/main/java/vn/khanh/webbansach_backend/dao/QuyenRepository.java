package vn.khanh.webbansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khanh.webbansach_backend.entity.Quyen;
@RepositoryRestResource(path = "quyen")
public interface QuyenRepository extends JpaRepository<Quyen,Integer> {
}
