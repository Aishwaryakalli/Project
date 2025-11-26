package com.example.ecommerce.service;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class OrderService {
  private final OrderRepository orderRepository;
  private final CartService cartService;
  private final UserService userService;

  public OrderService(OrderRepository orderRepository, CartService cartService, UserService userService){
    this.orderRepository = orderRepository;
    this.cartService = cartService;
    this.userService = userService;
  }

  public Order checkout(Long userId, String shippingAddress){
    User user = userService.findById(userId);
    if(user==null) throw new RuntimeException("User not found");
    Cart cart = cartService.getOrCreateCart(user);
    Order order = new Order();
    order.setUser(user);
    order.setShippingAddress(shippingAddress);
    order.setTotalAmount(cartService.cartTotal(cart));
    orderRepository.save(order);
    return order;
  }
}
