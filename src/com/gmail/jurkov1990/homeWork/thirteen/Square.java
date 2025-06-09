package com.gmail.jurkov1990.homework.thirteen;

public final class Square implements GeometricShape {
    private final double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive.");
        }
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square{" +
               "side=" + side +
               ", area=" + getArea() +
               '}';
    }
} 