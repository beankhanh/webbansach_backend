package vn.khanh.webbansach_backend.service.Sach;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.khanh.webbansach_backend.HinhAnh.HinhAnhService;
import vn.khanh.webbansach_backend.dao.SachRepository;
import vn.khanh.webbansach_backend.dao.TheLoaiRepository;
import vn.khanh.webbansach_backend.entity.HinhAnh;
import vn.khanh.webbansach_backend.entity.Sach;
import vn.khanh.webbansach_backend.entity.TheLoai;
import vn.khanh.webbansach_backend.util.Base64ToMultipartFileConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SachServiceImpl implements SachService{

    @Autowired
    private SachRepository sachRepository;

    @Autowired
    private TheLoaiRepository theLoaiRepository;
    @Autowired
    private HinhAnhService hinhAnhService;

    private final ObjectMapper objectMapper;
    public SachServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public ResponseEntity<?> save(JsonNode bookJson) {
        try {
            Sach sach = objectMapper.treeToValue(bookJson, Sach.class);

            // Nếu có giảm giá
            if (sach.getPhanTramGiamGia() != 0) {
                int giaBan = (int) ((int) sach.getGiaNiemYet() - Math.round(sach.getGiaNiemYet() / sach.getPhanTramGiamGia()));
                sach.setGiaBan(giaBan);
            }

            // Lưu thể loại của sách
            List<Integer> idListTheLoai = objectMapper.readValue(bookJson.get("maTheLoai").traverse(), new TypeReference<List<Integer>>() {
            });
            List<TheLoai> listTheLoai = new ArrayList<>();
            for (int idTheLoai : idListTheLoai) {
                Optional<TheLoai> genre = theLoaiRepository.findById(idTheLoai);
                listTheLoai.add(genre.get());
            }
            sach.setDanhSachTheLoai(listTheLoai);

            // Lưu trước để lấy id sách đặt tên cho ảnh
            Sach newBook = sachRepository.save(sach);

            // Lưu dữ liệu ảnh cho sách
            String icon = formatStringByJson(String.valueOf((bookJson.get("icon"))));

            HinhAnh hinhAnhIcon = new HinhAnh();
            hinhAnhIcon.setSach(newBook);
            hinhAnhIcon.setDuLieuAnh(icon);
            hinhAnhIcon.setIcon(true);
            MultipartFile multipartFile = Base64ToMultipartFileConverter.convert(icon);
            String urlHinhAnh = hinhAnhService.uploadImage(multipartFile, "Book_" + newBook.getMaSach());
            hinhAnhIcon.setDuongDan(urlHinhAnh);

            List<HinhAnh> danhSachHinhAnh = new ArrayList<>();
            danhSachHinhAnh.add(hinhAnhIcon);

            // Lưu những ảnh có liên quan
            String dataRelatedImg = formatStringByJson(String.valueOf((bookJson.get("relatedImg"))));
            List<String> arrDataRelatedImg = objectMapper.readValue(bookJson.get("relatedImg").traverse(), new TypeReference<List<String>>() {
            });

            for (int i = 0; i < arrDataRelatedImg.size(); i++) {
                String img = arrDataRelatedImg.get(i);
                HinhAnh image = new HinhAnh();
                image.setSach(newBook);
                image.setDuLieuAnh(img);
                image.setIcon(false);
                MultipartFile relatedImgFile = Base64ToMultipartFileConverter.convert(img);
                String imgURL = hinhAnhService.uploadImage(relatedImgFile, "Book_" + newBook.getMaSach() + "." + i);
                image.setDuongDan(imgURL);
                danhSachHinhAnh.add(image);
            }

            newBook.setDanhSachHinhAnh(danhSachHinhAnh);
            // Cập nhật lại ảnh
            sachRepository.save(newBook);

            return ResponseEntity.ok("Success!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<?> update(JsonNode bookJson) {
        return null;
    }

    @Override
    public long getTotalBook() {
        return 0;
    }
    private String formatStringByJson(String json) {
        return json.replaceAll("\"", "");
    }
}
