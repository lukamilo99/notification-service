package raf.rs.notificationservice.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Getter
@Setter
@Document
public class Notification {

    @Id
    private ObjectId id;
    private Long userId;
    private NotificationType type;
    private Date issueDate;
}
