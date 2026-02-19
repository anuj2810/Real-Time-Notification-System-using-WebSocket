package com.developersuraj.realtimenotifications.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Nofitication {
    @Id
    private Long id;

    private Long userId;
    private String message;
    private boolean delivered;
}
