package com.digital.wallet.auth.controller;

import com.digital.wallet.auth.dto.*;
import com.digital.wallet.auth.entity.AuthUser;
import com.digital.wallet.auth.repository.AuthUserRepository;
import com.digital.wallet.auth.service.AuthService;
import com.digital.wallet.auth.util.JwtUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        String token = authService.login(
                request.getUsername(),
                request.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping("/test")
    public String test() {
        return "AUTH SERVICE WORKING";
    }
}
