package com.gmail.jurkov1990.homework.five;
import java.util.Scanner;


public class CumulativeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість чисел (від 0 і більше): ");
        int n = scanner.nextInt();

        System.out.println("\n--- Реалізація з for ---");
        printSumFor(n);

        System.out.println("\n--- Реалізація з while ---");
        printSumWhile(n);

        System.out.println("\n--- Реалізація з do-while ---");
        printSumDoWhile(n);
    }

    public static void printSumFor(int n) {
        if (n == 0) return;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.println(i + ") Num is " + i + ", sum is " + sum);
        }
        System.out.println("------------------------");
        System.out.println("Sum of numbers is " + sum);
    }

    public static void printSumWhile(int n) {
        if (n == 0) return;
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            System.out.println(i + ") Num is " + i + ", sum is " + sum);
            i++;
        }
        System.out.println("------------------------");
        System.out.println("Sum of numbers is " + sum);
    }

    public static void printSumDoWhile(int n) {
        if (n == 0) return;
        int sum = 0;
        int i = 1;
        do {
            sum += i;
            System.out.println(i + ") Num is " + i + ", sum is " + sum);
            i++;
        } while (i <= n);
        System.out.println("------------------------");
        System.out.println("Sum of numbers is " + sum);
    }
}
