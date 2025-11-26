package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
  private final UserRepository userRepository;
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User save(User user){ return userRepository.save(user); }
  public User findByEmail(String email){ return userRepository.findByEmail(email); }
  public boolean existsByEmail(String email){ return userRepository.existsByEmail(email); }
  public User findById(Long id){ return userRepository.findById(id).orElse(null); }
}
