package com.digital.wallet.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.wallet.user.model.User;
import com.digital.wallet.user.model.kyc_details;

public interface KycRepository extends JpaRepository<kyc_details,Long>{

	Optional<kyc_details> findByuserIdKyc(String userId);

	

	

	

}
