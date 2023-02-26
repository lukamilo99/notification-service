package raf.rs.notificationservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import raf.rs.notificationservice.model.Notification;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, ObjectId> {

    Optional<Notification> getNotificationById(ObjectId id);
    Optional<List<Notification>> getNotificationByUserEmail(String email);

}
