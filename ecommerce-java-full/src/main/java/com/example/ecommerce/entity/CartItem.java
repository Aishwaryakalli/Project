package com.example.ecommerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cart_items")
public class CartItem {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Cart cart;
  @ManyToOne
  private Product product;
  private Integer qty;
  private BigDecimal unitPrice;

  public CartItem(){}

  public Long getId(){ return id; }
  public void setId(Long id){ this.id = id; }
  public Cart getCart(){ return cart; }
  public void setCart(Cart cart){ this.cart = cart; }
  public Product getProduct(){ return product; }
  public void setProduct(Product product){ this.product = product; }
  public Integer getQty(){ return qty; }
  public void setQty(Integer qty){ this.qty = qty; }
  public BigDecimal getUnitPrice(){ return unitPrice; }
  public void setUnitPrice(BigDecimal unitPrice){ this.unitPrice = unitPrice; }
}
