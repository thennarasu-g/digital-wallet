package com.digital.wallet.notification.dto;

public class NotificationResponseDTO {

    private Long id;
    private String message;
    private Double amount;
    private String createdAt;

    public NotificationResponseDTO(Long id, String message,
                                   Double amount, String createdAt) {
        this.id = id;
        this.message = message;
        this.amount = amount;
        this.createdAt = createdAt;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
    
}
