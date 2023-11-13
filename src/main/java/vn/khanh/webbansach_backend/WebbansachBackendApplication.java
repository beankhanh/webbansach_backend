package vn.khanh.webbansach_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "vn.khanh.webbansach_backend.entity")
public class WebbansachBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebbansachBackendApplication.class, args);
	}

}
