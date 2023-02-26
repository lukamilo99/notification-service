package raf.rs.notificationservice.mapper;

import org.springframework.stereotype.Component;
import raf.rs.notificationservice.dto.NotificationDto;
import raf.rs.notificationservice.model.Notification;
import raf.rs.notificationservice.model.NotificationType;

@Component
public class NotificationMapper {

    public Notification dtoToNotification(NotificationDto dto){
        Notification notification = new Notification();

        notification.setType(NotificationType.valueOf(dto.getNotificationType()));
        notification.setUserEmail(dto.getReceiverEmail());

        return notification;
    }
}
