package raf.rs.notificationservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import raf.rs.notificationservice.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends MongoRepository<Notification, ObjectId> {

    Optional<Notification> getNotificationById(ObjectId id);
    Optional<List<Notification>> getNotificationByUserId(Long id);

}
