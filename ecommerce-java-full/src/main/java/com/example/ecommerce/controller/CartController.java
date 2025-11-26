package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
  private final CartService cartService;
  private final UserService userService;

  public static class AddItemReq { public Long userId; public Long productId; public int qty; }

  public CartController(CartService cartService, UserService userService){
    this.cartService = cartService;
    this.userService = userService;
  }

  @PostMapping("/items")
  public Cart addItem(@RequestBody AddItemReq req){
    User user = userService.findById(req.userId);
    return cartService.addItem(user, req.productId, req.qty);
  }
}
