package com.example.simbirsoft_java_core_training.classes.Task7;

class Customer {
    private final String name;
    private boolean isBlacklisted = false;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isBlacklisted() {
        return isBlacklisted;
    }

    public void markAsBlacklisted() {
        this.isBlacklisted = true;
    }
}
