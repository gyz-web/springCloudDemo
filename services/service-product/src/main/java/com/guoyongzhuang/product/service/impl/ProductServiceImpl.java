package com.guoyongzhuang.product.service.impl;

import java.math.BigDecimal;

import com.guoyongzhuang.bean.product.Product;
import com.guoyongzhuang.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("99"));
        product.setName("iphone13");
        product.setNum(1);
        return product;
    }
}
