package com.developersuraj.realtimenotifications.dto;

import lombok.Data;

@Data
public class SubscriptionRequest {
    private Long userId;
    private Long channelId;
}
