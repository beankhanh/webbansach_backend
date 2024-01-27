package vn.khanh.webbansach_backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanh.webbansach_backend.HinhAnh.HinhAnhService;
import vn.khanh.webbansach_backend.dto.SachAndImagesRequest;
import vn.khanh.webbansach_backend.entity.HinhAnh;
import vn.khanh.webbansach_backend.entity.Sach;
import vn.khanh.webbansach_backend.service.Sach.SachService;

import java.util.List;

@RestController
@RequestMapping("/sach")
public class SachController {
    @Autowired
    private SachService sachService;

    @Autowired
    private HinhAnhService hinhAnhService;

    @PostMapping(path = "/")
    public ResponseEntity<?> save(@RequestBody JsonNode jsonData) {
        try {
            return sachService.save(jsonData);
           //System.out.println(jsonData);
           //return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi r");
            return ResponseEntity.badRequest().build();
        }
    }
}