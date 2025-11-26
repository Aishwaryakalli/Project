package com.example.ecommerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Order order;
  @ManyToOne
  private Product product;
  private Integer qty;
  private BigDecimal unitPrice;

  public OrderItem(){}

  public Long getId(){ return id; }
  public void setId(Long id){ this.id = id; }
  public Order getOrder(){ return order; }
  public void setOrder(Order order){ this.order = order; }
  public Product getProduct(){ return product; }
  public void setProduct(Product product){ this.product = product; }
  public Integer getQty(){ return qty; }
  public void setQty(Integer qty){ this.qty = qty; }
  public BigDecimal getUnitPrice(){ return unitPrice; }
  public void setUnitPrice(BigDecimal unitPrice){ this.unitPrice = unitPrice; }
}
