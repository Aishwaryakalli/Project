package com.example.ecommerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private User user;
  private BigDecimal totalAmount;
  @Enumerated(EnumType.STRING)
  private Status status = Status.PLACED;
  private LocalDateTime createdAt = LocalDateTime.now();
  private String shippingAddress;
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> items = new ArrayList<>();

  public enum Status { PLACED, SHIPPED, DELIVERED, CANCELLED }

  public Order(){}

  public Long getId(){ return id; }
  public void setId(Long id){ this.id = id; }
  public User getUser(){ return user; }
  public void setUser(User user){ this.user = user; }
  public BigDecimal getTotalAmount(){ return totalAmount; }
  public void setTotalAmount(BigDecimal totalAmount){ this.totalAmount = totalAmount; }
  public Status getStatus(){ return status; }
  public void setStatus(Status status){ this.status = status; }
  public LocalDateTime getCreatedAt(){ return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt){ this.createdAt = createdAt; }
  public String getShippingAddress(){ return shippingAddress; }
  public void setShippingAddress(String shippingAddress){ this.shippingAddress = shippingAddress; }
  public List<OrderItem> getItems(){ return items; }
  public void setItems(List<OrderItem> items){ this.items = items; }
}
