package raf.rs.notificationservice.service;

import raf.rs.notificationservice.dto.UserInfoDto;

public interface EmailService {

    void sendEmailNotification(String notificationType, UserInfoDto userInfo);
}
