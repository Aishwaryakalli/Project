package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService productService;
  public ProductController(ProductService productService){ this.productService = productService; }

  @GetMapping
  public List<Product> list(@RequestParam(value="q", required=false) String q){
    if(q==null || q.isBlank()) return productService.listAll();
    return productService.search(q);
  }

  @GetMapping("/{id}")
  public java.util.Optional<Product> get(@PathVariable Long id){
    return productService.get(id);
  }
}
