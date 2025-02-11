package com.example.simbirsoft_java_core_training;

import static org.junit.Assert.assertEquals;

import com.example.simbirsoft_java_core_training.geometry.Circle;
import com.example.simbirsoft_java_core_training.geometry.Rectangle;
import com.example.simbirsoft_java_core_training.geometry.Square;

import org.junit.Test;

public class ShapeTest {

    @Test
    public void testRectangle() {
        Rectangle rectangle = new Rectangle(5, 6);
        assertEquals(22, rectangle.perimeter(),0.01);
        assertEquals(30, rectangle.area(),0.01);
    }

    @Test
    public void testSquare() {
        Square square = new Square(4);
        assertEquals(16, square.perimeter(), 0.01);
        assertEquals(16, square.area(), 0.01);
    }

    @Test
    public void testCircle() {
        Circle circle = new Circle(10);
        assertEquals(Math.PI * 10, circle.perimeter(), 0.01);
        assertEquals(Math.PI * 25, circle.area(), 0.01);
    }
}

