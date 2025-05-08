package com.gmail.jurkov1990.homeWork.fourthLeson;

import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введіть суму доходу: ");
            double income = scanner.nextDouble();

            if (income < 0) {
                System.out.println("Помилка: Сума доходу не може бути від'ємною");
                return;
            }

            double tax;
            if (income <= 10000) {
                tax = income * 0.025;
            } else if (income <= 25000) {
                tax = income * 0.043;
            } else {
                tax = income * 0.067;
            }

            System.out.printf("Сума податку: %.2f%n", tax);

        } catch (Exception e) {
            System.out.println("Помилка: Будь ласка, введіть коректне числове значення");
        }
    }
}