package com.example.simbirsoft_java_core_training.classes.Task7;

class DefaultPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean process(Order order) {
        if (order.getCustomer().isBlacklisted()) {
            return false;
        }
        order.markAsPaid();
        return true;
    }
}