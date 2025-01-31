package com.example.simbirsoft_java_core_training.classes.Task1;

public class SimpleClass {
    private int var1;
    private int var2;

    public SimpleClass(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public void setValues(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public int sum() {
        return var1 + var2;
    }

    public int max() {
        return Math.max(var1, var2);
    }

    public void display() {
        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
    }
}

