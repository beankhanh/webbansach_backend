package vn.khanh.webbansach_backend.service.email;

public interface EmailService {
    public void sendMessage(String from, String to, String subject, String text);
}

