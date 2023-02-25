package raf.rs.notificationservice.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import raf.rs.notificationservice.dto.UserInfoDto;
import raf.rs.notificationservice.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String sender;
    private JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmailNotification(String notificationType, UserInfoDto userInfo) {

        try {

            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(userInfo.getEmail());
            mailMessage.setText("TEST");
            mailMessage.setSubject(notificationType);

            javaMailSender.send(mailMessage);
        }

        catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }
}
