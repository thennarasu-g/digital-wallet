package com.digital.wallet.auth.service;

import com.digital.wallet.auth.entity.AuthUser;
import com.digital.wallet.auth.exception.InvalidCredentialsException;
import com.digital.wallet.auth.repository.AuthUserRepository;
import com.digital.wallet.auth.util.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(AuthUserRepository repository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String login(String username, String password) {

        AuthUser user = repository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Invalid username"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getId());
    }
}
