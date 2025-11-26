package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
  private final ProductService productService;
  public AdminController(ProductService productService){ this.productService = productService; }

  @PostMapping("/products")
  public Product create(@RequestBody Product p){ return productService.save(p); }

  @PutMapping("/products/{id}")
  public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p){
    return productService.get(id).map(existing -> {
      existing.setName(p.getName());
      existing.setDescription(p.getDescription());
      existing.setPrice(p.getPrice());
      existing.setStockQty(p.getStockQty());
      existing.setImageUrl(p.getImageUrl());
      productService.save(existing);
      return ResponseEntity.ok(existing);
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    productService.delete(id);
    return ResponseEntity.ok().build();
  }
}
