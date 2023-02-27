package raf.rs.notificationservice.factory;

import raf.rs.notificationservice.dto.NotificationDto;

public class NotificationContentFactory {

    private static final String USER_SERVICE_URL = "http://localhost:8085/m1/user/auth";
    private static final String RENT_SERVICE_URL = "http://localhost:8085/m2/car/auth";

    public static String createNotificationContent(NotificationDto notificationDto){
        String type = notificationDto.getNotificationType();
        StringBuilder builder = new StringBuilder();

        switch (type) {
            case "CONFIRM_REGISTRATION" -> {
                builder.append(notificationDto.getReceiverFirstname()).append(" ").append(notificationDto.getReceiverLastname())
                        .append(", please confirm registration!\n\n");
                builder.append(USER_SERVICE_URL).append("/confirm-registration?token=").append(notificationDto.getToken());
            }
            case "CONFIRM_RESERVATION" -> {
                builder.append(notificationDto.getReceiverFirstname()).append(" ").append(notificationDto.getReceiverLastname())
                        .append(", please confirm reservation!\n\n");
                builder.append(RENT_SERVICE_URL).append("/confirm-reservation?token=").append(notificationDto.getToken());
            }
            case "CANCEL_RESERVATION" -> {
                builder.append(notificationDto.getReceiverFirstname()).append(" ").append(notificationDto.getReceiverLastname())
                        .append(", please confirm cancellation!\n\n");
                builder.append(RENT_SERVICE_URL).append("/confirm-cancellation?token=").append(notificationDto.getToken());
            }
        }
        return builder.toString();
    }
}
