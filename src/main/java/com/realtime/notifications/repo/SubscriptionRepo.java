package com.realtime.notifications.repo;

import com.realtime.notifications.dto.Channel;
import com.realtime.notifications.dto.Subscription;
import com.realtime.notifications.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface SubscriptionRepo extends MongoRepository<Subscription, Long> {

    List<Subscription> findByChannelId(Long channelId);
}
