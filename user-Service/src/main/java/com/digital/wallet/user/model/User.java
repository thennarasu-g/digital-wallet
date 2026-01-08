package com.digital.wallet.user.model;

import java.time.LocalDateTime;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import com.digital.wallet.user.enums.Kyc_status;
import com.digital.wallet.user.enums.Status;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false, length = 36)
    private String userId;
    
    

    @Column(unique = true, nullable = false, length = 15, comment = "need to be between 3 to 15 characters")
    private String userName;

    @Email
    @Column(unique = true, nullable = false, comment = "should not be longer than 30 characters")
    private String emailId;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$", message = "password must be 8 letters")
    private String password;

    @Column(unique = true, nullable = false, length = 10)
    private Long phoneNumber;

    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Enumerated(EnumType.STRING)
    private Kyc_status kyc_status;
    

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

  
    public User() {}
    public User(String userName, String emailId, String password, Long phoneNumber, Status status,Kyc_status kyc_status, LocalDateTime createdAt, LocalDateTime updatedAt) {
    	
    	this.userName = userName;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.kyc_status=kyc_status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        String ex=UUID.randomUUID().toString();
        this.userId =ex.substring(0,10);
        
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setKyc_status(Kyc_status kyc_status) {
        this.kyc_status = kyc_status;
    }
    public Kyc_status getKyc_status() {
        return kyc_status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
