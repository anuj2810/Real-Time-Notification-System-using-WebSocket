package com.realtime.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationDto {
    private String message;
    private Long channelId;
}
