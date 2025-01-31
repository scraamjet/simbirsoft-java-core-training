package com.example.simbirsoft_java_core_training.classes.Task3;

public class Triangle {
    private final Point[] vertices;

    public Triangle(Point p1, Point p2, Point p3) {
        this.vertices = new Point[]{p1, p2, p3};
    }

    public double getPerimeter() {
        return getSideLength(vertices[0], vertices[1]) +
                getSideLength(vertices[1], vertices[2]) +
                getSideLength(vertices[2], vertices[0]);
    }

    public double getArea() {
        return Math.abs((vertices[0].getX() * (vertices[1].getY() - vertices[2].getY()) +
                vertices[1].getX() * (vertices[2].getY() - vertices[0].getY()) +
                vertices[2].getX() * (vertices[0].getY() - vertices[1].getY())) / 2.0);
    }

    public Point getCentroid() {
        double centroidX = (vertices[0].getX() + vertices[1].getX() + vertices[2].getX()) / 3.0;
        double centroidY = (vertices[0].getY() + vertices[1].getY() + vertices[2].getY()) / 3.0;
        return new Point(centroidX, centroidY);
    }

    public Point[] getVertices() {
        return vertices.clone();
    }

    private double getSideLength(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    @Override
    public String toString() {
        return "Triangle{" + "vertices=" + vertices[0] + ", " + vertices[1] + ", " + vertices[2] + '}';
    }
}


