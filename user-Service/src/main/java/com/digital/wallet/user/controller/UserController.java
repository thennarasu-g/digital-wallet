package com.digital.wallet.user.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.wallet.user.dto.UserDto;
import com.digital.wallet.user.model.User;
import com.digital.wallet.user.model.kyc_details;
import com.digital.wallet.user.service.UserService;


@RestController
@RequestMapping(value="/api")
public class UserController {
	private UserService service;
	public UserController(UserService service) {
		this.service=service;
	}
	@PostMapping("/user/Register")
	public User Register(@RequestBody UserDto user) {
		return service.Register(user);
	}
	@PostMapping("/user/login")
	public ResponseEntity<String> loginUser(@RequestParam String userName,@RequestParam String password) {
		return service.loginUser(userName,password);
		
	}
	@PutMapping("/user/userUpdate")
	public ResponseEntity<String> updateUser(@RequestParam String userName,@RequestParam String newUserName) {
		return service.updateUser(userName,newUserName);
	}
	@PutMapping("/user/passwordUpdate")
	public ResponseEntity<String> passwordUpdate(@RequestParam String password) {
		return service.updatePassword(password);
	}
	@PutMapping("/user/kyc")
	public ResponseEntity<String> kycVerification(@RequestParam String userId,@RequestParam Long doc_id) {
		return service.kycVerification(userId,doc_id);
	}
	@GetMapping("/user")
	public List<User> getAll(){
		return service.getAll();
	}
	@GetMapping("/user/{userId}")
	public Optional<User> getById(User user,@PathVariable String userId){
		return service.getByUserId(user,userId);
	}
	@DeleteMapping("/user")
	public ResponseEntity<String> deleteUser(@RequestParam String userName,@RequestParam String password) {
		return service.deleteUser(userName,password);
	}
	@PostMapping("/kyc_details/Register")
	public kyc_details kycRegister(@RequestBody kyc_details kyc,@RequestParam String id) {
		return service.kycRegister(kyc,id);
	}
	@GetMapping("/kyc_details")
	public List<kyc_details> getkyc() {
		return service.getkyc();
	}
	@DeleteMapping("/kyc_details")
	public ResponseEntity<String> deleteKyc() {
		return service.deleteKyc();
	}

}
