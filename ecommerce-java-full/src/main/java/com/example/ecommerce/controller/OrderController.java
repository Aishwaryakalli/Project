package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  private final OrderService orderService;
  public static class CheckoutReq { public Long userId; public String shippingAddress; }

  public OrderController(OrderService orderService){ this.orderService = orderService; }

  @PostMapping
  public Order checkout(@RequestBody CheckoutReq req){
    return orderService.checkout(req.userId, req.shippingAddress);
  }
}
