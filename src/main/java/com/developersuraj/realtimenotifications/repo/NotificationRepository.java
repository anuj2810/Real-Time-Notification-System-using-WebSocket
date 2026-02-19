package com.developersuraj.realtimenotifications.repo;

import com.developersuraj.realtimenotifications.dto.Nofitication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Nofitication, Long> {
}
