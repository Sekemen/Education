package com.gmail.jurkov1990.homework.thirteen;

public final class Circle implements GeometricShape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
               "radius=" + radius +
               ", area=" + getArea() +
               '}';
    }
} 