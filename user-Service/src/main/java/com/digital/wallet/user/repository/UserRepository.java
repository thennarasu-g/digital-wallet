package com.digital.wallet.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.wallet.user.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findByuserName(String userName);

	boolean existsByuserName(String userName);

	Optional<User> findByPassword(String password);

	Optional<User> findByuserId(String id);

	boolean existsByuserId(String userId);

}
