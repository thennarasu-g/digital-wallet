package com.digital.wallet.user.dto;

import java.util.Date;

import com.digital.wallet.user.enums.Status;

public class UserDto {
	private String userId;
	private String userName;
	private String emailId;
	private String password;
	private Long phoneNumber;
	private Status status;
	private Date createdAt;
	private Date updatedAt;
	
	public UserDto(String userId,String userName,String emailId,String password,Long phoneNumber,Status status,Date createdAt,Date updatedAt) {
		this.userName=userName;
		this.emailId=emailId;
		this.password=password;
		this.phoneNumber=phoneNumber;
		this.status=status;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return emailId;
	}
	public void setEmail(String email) {
		this.emailId = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
