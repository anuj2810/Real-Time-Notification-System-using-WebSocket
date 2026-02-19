package com.developersuraj.realtimenotifications.controller;

import com.developersuraj.realtimenotifications.dto.SubscriptionRequest;
import com.developersuraj.realtimenotifications.service.SubscriptionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscribe")
    public String subscribe(@RequestBody SubscriptionRequest request) {
        subscriptionService.subscribe(request);
        return "User " + request.getUserId() + " subscribed to channel " + request.getChannelId();
    }
}
