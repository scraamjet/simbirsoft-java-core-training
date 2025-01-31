package com.example.simbirsoft_java_core_training.classes.Task7;

class PaymentSystem {
    public static boolean processPayment(Order order) {
        if (order.getCustomer().isBlacklisted()) {
            return false;
        }

        order.setPaid(true);
        return true;
    }
}
