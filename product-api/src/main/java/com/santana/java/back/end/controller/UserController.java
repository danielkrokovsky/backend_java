package com.santana.java.back.end.controller;

import com.santana.java.back.end.dto.CategoryDTO;
import com.santana.java.back.end.dto.ProductDTO;
import com.santana.java.back.end.exception.ProductNotFoundException;
import com.santana.java.back.end.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private ProductService productService;
    @GetMapping("/product")
    public List<ProductDTO> getProducts() {
        List<ProductDTO> produtos = productService.getAll();
        return produtos;
    }
    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(
            @PathVariable Long categoryId) {
        List<ProductDTO> produtos =
                productService.getProductByCategoryId(categoryId);
        return produtos;
    }
    @GetMapping("/product/{productIdentifier}")
    public ProductDTO findById(@PathVariable String productIdentifier) {
        return productService
                .findByProductIdentifier(productIdentifier);
    }
    @PostMapping("/product")
    public ProductDTO newProduct(
            @Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }
    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) throws ProductNotFoundException {
        productService.delete(id);
    }
}