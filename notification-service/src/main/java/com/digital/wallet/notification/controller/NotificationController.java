package com.digital.wallet.notification.controller;

import com.digital.wallet.notification.dto.NotificationRequestDTO;
import com.digital.wallet.notification.dto.NotificationResponseDTO;
import com.digital.wallet.notification.service.NotificationService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public String send(@RequestBody NotificationRequestDTO request) {
        service.sendNotification(request);
        return "Notification saved and email sent";
    }

    @GetMapping("/{userId}")
    public List<NotificationResponseDTO> history(@PathVariable Long userId) {
        return service.getHistory(userId);
    }
}
