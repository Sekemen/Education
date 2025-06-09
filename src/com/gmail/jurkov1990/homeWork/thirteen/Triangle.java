package com.gmail.jurkov1990.homework.thirteen;

public final class Triangle implements GeometricShape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base must be positive.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive.");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle{" +
               "base=" + base +
               ", height=" + height +
               ", area=" + getArea() +
               '}';
    }
} 