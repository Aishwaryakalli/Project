package com.example.ecommerce.service;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class CartService {
  private final CartRepository cartRepository;
  private final CartItemRepository cartItemRepository;
  private final ProductRepository productRepository;
  private final UserService userService;

  public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductRepository productRepository, UserService userService){
    this.cartRepository = cartRepository;
    this.cartItemRepository = cartItemRepository;
    this.productRepository = productRepository;
    this.userService = userService;
  }

  public Cart getOrCreateCart(User user){
    Cart c = cartRepository.findByUser(user);
    if(c==null){
      c = new Cart();
      c.setUser(user);
      cartRepository.save(c);
    }
    return c;
  }

  public Cart addItem(User user, Long productId, int qty){
    Cart cart = getOrCreateCart(user);
    Optional<Product> opt = productRepository.findById(productId);
    if(opt.isEmpty()) throw new RuntimeException("Product not found");
    Product p = opt.get();
    CartItem item = new CartItem();
    item.setCart(cart);
    item.setProduct(p);
    item.setQty(qty);
    item.setUnitPrice(p.getPrice());
    cart.getItems().add(item);
    cartRepository.save(cart);
    return cart;
  }

  public BigDecimal cartTotal(Cart cart){
    return cart.getItems().stream()
      .map(i -> i.getUnitPrice().multiply(new BigDecimal(i.getQty())))
      .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
