package com.digital.wallet.notification.service;

import com.digital.wallet.notification.dto.NotificationRequestDTO;
import com.digital.wallet.notification.dto.NotificationResponseDTO;
import com.digital.wallet.notification.entity.Notification;
import com.digital.wallet.notification.repository.NotificationRepository;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository repository;
    private final JavaMailSender mailSender;

    public NotificationService(NotificationRepository repository,
                               JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    public void sendNotification(NotificationRequestDTO dto) {

        Notification notification = new Notification();
        notification.setUserId(dto.getUserId());
        notification.setMessage(dto.getMessage());
        notification.setAmount(dto.getAmount());
        notification.setCreatedAt(LocalDateTime.now());

        repository.save(notification);

        if (dto.getEmail() != null) {
            sendEmail(dto.getEmail(), dto.getAmount());
        }
    }

    private void sendEmail(String toEmail, Double amount) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(toEmail);
        mail.setSubject("Transaction Alert");
        mail.setText("Transaction of ₹" + amount + " completed successfully.");

        mailSender.send(mail);
    }

    public List<NotificationResponseDTO> getHistory(Long userId) {

        return repository.findByUserId(userId)
                .stream()
                .map(n -> new NotificationResponseDTO(
                        n.getId(),
                        n.getMessage(),
                        n.getAmount(),
                        n.getCreatedAt() != null
                                ? n.getCreatedAt().toString()
                                : "N/A"   // prevents crash
                ))
                .collect(Collectors.toList());
    }

}
