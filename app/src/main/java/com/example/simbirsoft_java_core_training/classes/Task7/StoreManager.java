package com.example.simbirsoft_java_core_training.classes.Task7;

class StoreManager {
    private String name;
    private PaymentProcessor paymentProcessor;

    public StoreManager(String name, PaymentProcessor paymentProcessor) {
        this.name = name;
        this.paymentProcessor = paymentProcessor;
    }

    public boolean registerSale(Order order) {
        if (order.isPaid()) {
            System.out.println("Заказ уже оплачен.");
            return true;
        }

        if (paymentProcessor.process(order)) {
            System.out.println("Платеж успешно прошел. Продажа зарегистрирована.");
            return true;
        } else {
            order.getCustomer().markAsBlacklisted();
            System.out.println("Платеж не прошел. Клиент добавлен в черный список.");
            return false;
        }
    }
}
