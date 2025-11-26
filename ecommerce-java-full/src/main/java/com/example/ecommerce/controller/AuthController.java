package com.example.ecommerce.controller;

import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.RegisterRequest;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  public AuthController(UserService userService, PasswordEncoder passwordEncoder){
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequest req){
    if(userService.existsByEmail(req.getEmail())){
      return ResponseEntity.badRequest().body("Email already in use");
    }
    User u = new User();
    u.setUsername(req.getUsername());
    u.setEmail(req.getEmail());
    u.setPasswordHash(passwordEncoder.encode(req.getPassword()));
    userService.save(u);
    return ResponseEntity.ok("Registered");
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest req){
    User user = userService.findByEmail(req.getEmail());
    if(user == null || !passwordEncoder.matches(req.getPassword(), user.getPasswordHash())){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
    return ResponseEntity.ok(java.util.Map.of("message","Login successful","userId", user.getId()));
  }
}
