package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CartRepository extends JpaRepository<Cart, Long> {
  Cart findByUser(User user);
}
