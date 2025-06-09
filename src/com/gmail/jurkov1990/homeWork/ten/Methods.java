package com.gmail.jurkov1990.homework.ten;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;


public class Methods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int number = inputInt(scanner, "1. Введіть ціле число: ");
        printSquare(number);
        System.out.println();

        double radius = inputPositiveDouble(scanner, "2. Введіть радіус циліндра (додатне число): ");
        double height = inputPositiveDouble(scanner, "   Введіть висоту циліндра (додатне число): ");
        double volume = calculateCylinderVolume(radius, height);
        System.out.println("   Об'єм циліндра з радіусом " + radius + " і висотою " + height + " дорівнює " + volume + ".");
        System.out.println();

        int arrayLength = inputPositiveInt(scanner, "3. Введіть довжину масиву (додатне число): ");

        int[] array = new int[arrayLength];
        System.out.print("  Масив чисел: [");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(100) + 1;
            System.out.print(array[i]);
            if (i < arrayLength - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        int sum = calculateArraySum(array);
        System.out.println("  Сума всіх елементів масиву дорівнює " + sum + ".");
        System.out.println();

        scanner.nextLine();
        String inputString = inputNonEmptyString(scanner, "4. Введіть рядок: ");
        String reversedString = reverseString(inputString);
        System.out.println("  Рядок в зворотньому порядку: " + reversedString);
        System.out.println();

        int[] powerValues = inputPowerValues(scanner);
        int a = powerValues[0];
        int b = powerValues[1];

        int powerResult = power(a, b);
        if (powerResult != Integer.MAX_VALUE && powerResult != Integer.MIN_VALUE) {
            System.out.println("  Результат " + a + "^" + b + " дорівнює " + powerResult + ".");
        }
        System.out.println();

        int n = inputPositiveInt(scanner, "6. Введіть ціле число n (додатне): ");
        scanner.nextLine();
        String text = inputNonEmptyString(scanner, "  Введіть текстовий рядок: ");
        printTextNTimes(n, text);

        scanner.close();
    }

    public static void printSquare(int number) {
        int square = number * number;
        System.out.println("Квадрат числа " + number + " дорівнює " + square + ".");
    }

    public static double calculateCylinderVolume(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            System.out.println("Помилка: радіус і висота повинні бути додатними числами");
            return 0;
        }
        return Math.PI * radius * radius * height;
    }

    public static int calculateArraySum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static String reverseString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] chars = input.toCharArray();
        char[] result = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[chars.length - 1 - i];
        }

        return new String(result);
    }

    public static int power(int a, int b) {
        if (b < 0) {
            System.out.println("Показник степеня повинен бути невід'ємним");
            return 0;
        }

        if (b == 0) {
            return 1;
        }

        if (willOverflow(a, b)) {
            System.out.println("Результат виходить за межі типу int");
            if (a > 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
            if (result > Integer.MAX_VALUE) {
                System.out.println("Результат виходить за межі типу int");
                return Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE) {
                System.out.println("Результат виходить за межі типу int");
                return Integer.MIN_VALUE;
            }
        }

        return (int) result;
    }

    public static void printTextNTimes(int n, String text) {
        if (n <= 0) {
            System.out.println("Кількість повторень повинна бути додатною!");
            return;
        }

        if (text == null || text.trim().isEmpty()) {
            System.out.println("Текст не може бути пустим!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(text);
        }
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isPositive(double number) {
        return number > 0;
    }

    public static boolean isValidString(String text) {
        return text != null && !text.trim().isEmpty();
    }

    public static boolean willOverflow(int a, int b) {
        if (a == 0 || a == 1 || a == -1 || b == 0) {
            return false;
        }
        return b > 31;
    }

    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static int inputInt(Scanner scanner, String outputMessage) {
        System.out.print(outputMessage);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Помилка! Введено некоректний тип даних. Очікується ціле число.");
            scanner.nextLine();
            return inputInt(scanner, outputMessage);
        }
    }

    public static int inputPositiveInt(Scanner scanner, String outputMessage) {
        int value = inputInt(scanner, outputMessage);
        if (isPositive(value)) {
            return value;
        } else {
            System.out.println("Значення повинно бути додатним!");
            return inputPositiveInt(scanner, outputMessage);
        }
    }

    public static int inputNonNegativeInt(Scanner scanner, String outputMessage) {
        int value = inputInt(scanner, outputMessage);
        if (value >= 0) {
            return value;
        } else {
            System.out.println("Значення повинно бути невід'ємним!");
            return inputNonNegativeInt(scanner, outputMessage);
        }
    }

    public static int inputIntInRange(Scanner scanner, String outputMessage, int min, int max) {
        int value = inputInt(scanner, outputMessage);
        if (isInRange(value, min, max)) {
            return value;
        } else {
            System.out.println("Значення повинно бути в діапазоні від " + min + " до " + max + "!");
            return inputIntInRange(scanner, outputMessage, min, max);
        }
    }

    public static double inputDouble(Scanner scanner, String outputMessage) {
        System.out.print(outputMessage);
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Помилка! Введено некоректний тип даних. Очікується дійсне число.");
            scanner.nextLine();
            return inputDouble(scanner, outputMessage);
        }
    }

    public static double inputPositiveDouble(Scanner scanner, String outputMessage) {
        double value = inputDouble(scanner, outputMessage);
        if (isPositive(value)) {
            return value;
        } else {
            System.out.println("Значення повинно бути додатним!");
            return inputPositiveDouble(scanner, outputMessage);
        }
    }

    public static String inputNonEmptyString(Scanner scanner, String outputMessage) {
        System.out.print(outputMessage);
        String value = scanner.nextLine();
        if (isValidString(value)) {
            return value;
        } else {
            System.out.println("Рядок не може бути пустим! Спробуйте ще раз.");
            return inputNonEmptyString(scanner, outputMessage);
        }
    }

    public static int[] inputPowerValues(Scanner scanner) {
        try {
            int a = inputInt(scanner, "5. Введіть a: ");
            int b = inputNonNegativeInt(scanner, "  Введіть b (невід'ємне число): ");

            if (a == 0 && b == 0) {
                System.out.println("  0^0 є невизначеним! Введіть інші значення.");
                return inputPowerValues(scanner);
            }

            return new int[]{a, b};
        } catch (InputMismatchException e) {
            System.out.println("Помилка! Введено некоректний тип даних.");
            scanner.nextLine();
            return inputPowerValues(scanner);
        }
    }
} 