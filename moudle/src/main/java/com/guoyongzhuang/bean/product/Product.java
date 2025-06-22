package com.guoyongzhuang.bean.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;//product id
    private BigDecimal price;//product price
    private String name;//product name
    private int num; //buy nums

}
