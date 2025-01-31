package com.example.simbirsoft_java_core_training.classes.Task7;

import java.util.Map;
import java.util.HashMap;

class Order {
    private final Map<Product, Integer> products = new HashMap<>();
    private final Customer customer;
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
        if (quantity <= 0) throw new IllegalArgumentException("Количество должно быть больше нуля");
        products.merge(product, quantity, Integer::sum);
    }

    public double getTotalPrice() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}