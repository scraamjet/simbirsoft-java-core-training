package com.example.simbirsoft_java_core_training.geometry;

public class Circle implements Shape {
    private final double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public double perimeter() {
        return Math.PI * diameter;
    }

    @Override
    public double area() {
        double radius = diameter / 2;
        return Math.PI * radius * radius;
    }
}
