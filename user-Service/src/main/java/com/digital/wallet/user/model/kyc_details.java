package com.digital.wallet.user.model;

import java.time.LocalDateTime;

import com.digital.wallet.user.enums.Kyc_status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class kyc_details {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    private String userIdKyc;
	private String document_type;
	private Long document_id;
	@Enumerated(EnumType.STRING)
	private Kyc_status kyc_status;
	private LocalDateTime verified_at;
	private LocalDateTime created_at;
	public kyc_details(String object,String document_type,Long document_id,Kyc_status kyc_status,LocalDateTime verified_at,LocalDateTime created_at) {
        this.userIdKyc=object;
		this.document_type=document_type;
		this.document_id=document_id;
		this.kyc_status=kyc_status;
		this.setVerified_at(verified_at);
		this.setCreated_at(created_at);
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public LocalDateTime getVerified_at() {
		return verified_at;
	}
	public void setVerified_at(LocalDateTime verified_at) {
		this.verified_at = verified_at;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	public Long getDocument_id() {
		return document_id;
	}
	public void setDocument_id(Long document_id) {
		this.document_id = document_id;
	}
	
    public kyc_details() {}
	public String getUser_id() {
		return userIdKyc;
	}
	public void setUser_id(String userIdKyc) {
		this.userIdKyc = userIdKyc;
	}
	public Kyc_status getKyc_status() {
		return kyc_status;
	}
	public void setKyc_status(Kyc_status kyc_status) {
		this.kyc_status=kyc_status;
	}
	
	
	

}
