package vn.khanh.webbansach_backend.service.Sach;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import vn.khanh.webbansach_backend.entity.Sach;

import java.util.List;

public interface SachService {
    public ResponseEntity<?> save(JsonNode bookJson);
    public ResponseEntity<?> update(JsonNode bookJson);
    public long getTotalBook();
}
