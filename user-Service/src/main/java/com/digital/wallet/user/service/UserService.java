package com.digital.wallet.user.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digital.wallet.user.dto.UserDto;
import com.digital.wallet.user.enums.Kyc_status;
import com.digital.wallet.user.enums.Status;
import com.digital.wallet.user.model.User;
import com.digital.wallet.user.model.kyc_details;
import com.digital.wallet.user.repository.KycRepository;
import com.digital.wallet.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	private UserRepository repo;
	private KycRepository kycrepo;
	public UserService(UserRepository repo,KycRepository kycrepo) {
		this.repo=repo;
		this.kycrepo=kycrepo;
	}
	
	@Transactional
	public User Register(UserDto userdto) {
		if(repo.existsByuserName(userdto.getUserName())) {
			throw new RuntimeException("username already exist");
		}
		User newuser=new User(
				userdto.getUserName(),
				userdto.getEmail(),
				userdto.getPassword(),
				userdto.getPhoneNumber(),
				Status.ACTIVE,
				Kyc_status.PENDING,
				LocalDateTime.now(),
				LocalDateTime.now());
		return repo.save(newuser);
	}
	//kyc register
	@Transactional
	public kyc_details kycRegister(kyc_details kyc,String id) {
		if(!repo.existsByuserId(id)) {
			throw new RuntimeException("User not found");
		}
              
		if (kyc.getUser_id()!= null) {
	        throw new RuntimeException("User data is already in KYC details");
	    }
		kyc_details newkyc=new kyc_details(
				id,
				kyc.getDocument_type(),
				kyc.getDocument_id(),
			    Kyc_status.PENDING,
				LocalDateTime.now(),
				LocalDateTime.now());
		return kycrepo.save(newkyc);
	}
	public Optional<User> getByUserId(User user,String id) {
		return repo.findByuserId(id);
	}
	public List<User> getAll(){
		return repo.findAll();
	}
	//kyc get
	public List<kyc_details> getkyc(){
		return kycrepo.findAll();
	}

	public ResponseEntity<String> loginUser(String userName, String password) {
        User user = repo.findByuserName(userName)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(!password.matches(user.getPassword())) {
        	new RuntimeException("enter correct password");
        }
        return ResponseEntity.ok("login successfull");
	
	

}
	public ResponseEntity<String> updateUser(String userName,String newUserName) {
		User exist=repo.findByuserName(userName)
                .orElseThrow(() -> new RuntimeException("User not found"));
		exist.setUserName(newUserName);
		exist.setUpdatedAt(LocalDateTime.now());
		repo.save(exist);
		return ResponseEntity.ok("username updated");
		
	}
	public ResponseEntity<String> deleteUser(String userName,String password) {
		User user=repo.findByuserName(userName)
				.orElseThrow(()->new RuntimeException("user not found"));
		if(!password.matches(user.getPassword())) {
			new RuntimeException("password is incorrect");
		}
		repo.delete(user);
		user.setStatus(Status.INACTIVE);
		return ResponseEntity.ok("user deleted");
	}
	//kyc deletion
	public ResponseEntity<String> deleteKyc(){
		/*kyc_details kyc=kycrepo.findByuserIdKyc(userId)
				.orElseThrow(()->new RuntimeException("user not found"));*/
		kycrepo.deleteAll();
		return ResponseEntity.ok("deleted");
	}
	//kyc verification
	public ResponseEntity<String> kycVerification(String userId,Long doc_id){
		kyc_details exist=kycrepo.findByuserIdKyc(userId)
				.orElseThrow(()-> new RuntimeException("User not found"));
		User user = repo.findByuserId(userId)
				.orElseThrow(()-> new RuntimeException("User not found"));
		if(exist.getDocument_id().equals(doc_id)) {
			exist.setKyc_status(Kyc_status.VERIFIED);
			user.setKyc_status(Kyc_status.VERIFIED);
		
		}
		else {
			exist.setKyc_status(Kyc_status.REJECTED);
			user.setKyc_status(Kyc_status.REJECTED);
		}
		kycrepo.save(exist);
		repo.save(user);
		
		 return ResponseEntity.ok("updated successfully");
	}
	public ResponseEntity<String> updatePassword(String password) {
		User exist=repo.findByPassword(password)
                .orElseThrow(() -> new RuntimeException("User not found"));
		if(!password.equals(repo.findByPassword(password))) {
			exist.setPassword(password);
			exist.setUpdatedAt(LocalDateTime.now());
        }
		else {
			throw new RuntimeException("password should be not as previous");
		}
		repo.save(exist);
		return ResponseEntity.ok("password changed successfully");
	}
}
