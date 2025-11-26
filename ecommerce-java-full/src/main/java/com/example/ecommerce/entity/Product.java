package com.example.ecommerce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(length=2000)
  private String description;
  private BigDecimal price;
  private Integer stockQty;
  private String imageUrl;
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  public Product(){}

  public Long getId(){ return id; }
  public void setId(Long id){ this.id = id; }
  public String getName(){ return name; }
  public void setName(String name){ this.name = name; }
  public String getDescription(){ return description; }
  public void setDescription(String description){ this.description = description; }
  public BigDecimal getPrice(){ return price; }
  public void setPrice(BigDecimal price){ this.price = price; }
  public Integer getStockQty(){ return stockQty; }
  public void setStockQty(Integer stockQty){ this.stockQty = stockQty; }
  public String getImageUrl(){ return imageUrl; }
  public void setImageUrl(String imageUrl){ this.imageUrl = imageUrl; }
  public Category getCategory(){ return category; }
  public void setCategory(Category category){ this.category = category; }
}
