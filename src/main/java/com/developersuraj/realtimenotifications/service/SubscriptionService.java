package com.developersuraj.realtimenotifications.service;

import com.developersuraj.realtimenotifications.dto.Subscription;
import com.developersuraj.realtimenotifications.dto.SubscriptionRequest;
import com.developersuraj.realtimenotifications.repo.SubscriptionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private static long count = 1;

    private final SubscriptionRepo subscriptionRepo;

    public SubscriptionService(SubscriptionRepo subscriptionRepo) {
        this.subscriptionRepo = subscriptionRepo;
    }

    public void subscribe(SubscriptionRequest request) {
        Subscription sub = new Subscription();
        sub.setUserId(request.getUserId());
        sub.setChannelId(request.getChannelId());
        sub.setId(count++);
        subscriptionRepo.save(sub);
    }

    public List<Long> getSubscribers(Long channelId) {
        return subscriptionRepo.findByChannelId(channelId)
                .stream()
                .map(Subscription::getUserId)
                .toList();
    }
}
