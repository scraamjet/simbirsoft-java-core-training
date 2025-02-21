package com.example.simbirsoft_java_core_training.classes.Task7;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;

class Order {
    private Map<Product, Integer> products = new HashMap<>();
    private Customer customer;
    private boolean isPaid = false;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше нуля");
        }
        products.merge(product, quantity, Integer::sum);
    }

    public BigDecimal getTotalPrice() {
        return products.entrySet()
                .stream()
                .map(this::calculateProductTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateProductTotalPrice(Map.Entry<Product, Integer> entry) {
        return entry.getKey()
                .getPrice()
                .multiply(
                        BigDecimal.valueOf(
                                entry.getValue()
                        )
                );
    }
}