package com.gmail.jurkov1990.homework.thirteen;

public class ShapeCalculator {

    public static double calculateTotalArea(GeometricShape[] shapes) {
        double totalArea = 0;
        if (shapes == null) {
            return 0;
        }
        for (GeometricShape shape : shapes) {
            if (shape != null) {
                totalArea += shape.getArea();
            }
        }
        return totalArea;
    }

    public static void main(String[] args) {
        GeometricShape[] shapes = new GeometricShape[] {
            new Circle(5.0),
            new Triangle(4.0, 3.0),
            new Square(6.0),
            new Circle(2.5),
            new Square(3.0)
        };

        double totalArea = calculateTotalArea(shapes);
        System.out.println("Загальна площа всіх фігур: " + totalArea);
    }
} 