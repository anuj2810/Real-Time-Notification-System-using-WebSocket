package com.realtime.notifications.repo;

import com.realtime.notifications.dto.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, Long> {
}
