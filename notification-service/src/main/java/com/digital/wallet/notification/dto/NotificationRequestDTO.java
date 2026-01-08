package com.digital.wallet.notification.dto;

public class NotificationRequestDTO {

    private Long userId;
    private Double amount;
    private String email;
    private String message;

    public NotificationRequestDTO() {}

	public NotificationRequestDTO(Long userId, Double amount, String email, String message) {
		
		this.userId = userId;
		this.amount = amount;
		this.email = email;
		this.message = message;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
