package com.example.simbirsoft_java_core_training.classes.Task7;

import java.math.BigDecimal;

class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Цена товара должна быть больше нуля");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}