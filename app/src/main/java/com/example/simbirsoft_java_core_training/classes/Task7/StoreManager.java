package com.example.simbirsoft_java_core_training.classes.Task7;

import java.util.Set;
import java.util.HashSet;

public class StoreManager {
    private Set<Customer> blacklist = new HashSet<>();

    public void registerSale(Order order) {
        if (order.isPaid()) {
        } else {
            blacklistCustomer(order.getCustomer());
        }
    }

    public void blacklistCustomer(Customer customer) {
        customer.setBlacklisted(true);
        blacklist.add(customer);
    }
}
