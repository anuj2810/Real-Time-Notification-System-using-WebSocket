package com.developersuraj.realtimenotifications.repo;

import com.developersuraj.realtimenotifications.dto.Channel;
import com.developersuraj.realtimenotifications.dto.Subscription;
import com.developersuraj.realtimenotifications.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface SubscriptionRepo extends MongoRepository<Subscription, Long> {

    List<Subscription> findByChannelId(Long channelId);
}
