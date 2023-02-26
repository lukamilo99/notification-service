package raf.rs.notificationservice.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import raf.rs.notificationservice.dto.NotificationDto;
import raf.rs.notificationservice.factory.NotificationContentFactory;
import raf.rs.notificationservice.mapper.NotificationMapper;
import raf.rs.notificationservice.repository.NotificationRepository;
import raf.rs.notificationservice.service.NotificationService;

@Service
public class EmailService implements NotificationService {

    @Value("${spring.mail.username}")
    private String sender;
    private JavaMailSender javaMailSender;
    private ObjectMapper objectMapper;
    private NotificationMapper notificationMapper;
    private NotificationRepository notificationRepository;

    public EmailService(JavaMailSender javaMailSender, ObjectMapper objectMapper, NotificationMapper notificationMapper, NotificationRepository notificationRepository) {
        this.javaMailSender = javaMailSender;
        this.objectMapper = objectMapper;
        this.notificationMapper = notificationMapper;
        this.notificationRepository = notificationRepository;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    @Override
    public void sendNotification(String userInfo) {

        try {
            NotificationDto notificationDto = objectMapper.readValue(userInfo, NotificationDto.class);
            String content = NotificationContentFactory.createNotificationContent(notificationDto);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(notificationDto.getReceiverEmail());
            mailMessage.setText(content);
            mailMessage.setSubject(notificationDto.getNotificationType());

            javaMailSender.send(mailMessage);
            notificationRepository.save(notificationMapper.dtoToNotification(notificationDto));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
