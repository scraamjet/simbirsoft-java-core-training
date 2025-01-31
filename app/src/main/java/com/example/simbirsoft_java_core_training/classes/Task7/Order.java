package com.example.simbirsoft_java_core_training.classes.Task7;

import java.util.Map;
import java.util.HashMap;

class Order {
    private Map<Product, Integer> products = new HashMap<>();
    private Customer customer;
    private boolean isPaid = false;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public double getTotalPrice() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Customer getCustomer() {
        return customer;
    }
}

