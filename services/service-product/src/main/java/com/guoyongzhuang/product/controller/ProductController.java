package com.guoyongzhuang.product.controller;

import com.guoyongzhuang.product.bean.Product;
import com.guoyongzhuang.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    @Autowired
    ProductService productService;
    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
