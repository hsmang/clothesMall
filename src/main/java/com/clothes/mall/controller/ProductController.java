package com.clothes.mall.controller;

import com.clothes.mall.domain.product.Product;
import com.clothes.mall.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/api/products/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다."));
    }

    @PostMapping("/api/products")
    public Product save(@RequestBody Product product){


        return productRepository.save(product);
    }
}
