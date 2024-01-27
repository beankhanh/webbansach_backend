package vn.khanh.webbansach_backend.config;

import com.cloudinary.Cloudinary;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    private final String CLOUD_NAME = "beankhanh";
    private final String API_KEY = "516529897757758";
   private final String API_SECRET = "os9XJ9UJZfB58snLLnubofbSpPw";

    //    Config cloudinary (Nơi để chứa ảnh)
    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("api_secret", API_SECRET);
        return new Cloudinary(config);
    }
}
