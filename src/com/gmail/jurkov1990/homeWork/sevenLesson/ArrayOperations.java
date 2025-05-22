package com.gmail.jurkov1990.homeWork.sevenLesson;

import java.util.Random;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введіть довжину масиву: ");
            String input = scanner.nextLine();

            try {
                length = Integer.parseInt(input);
                if (length <= 0) {
                    System.out.println("Помилка: довжина масиву повинна бути більше 0.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть ціле число.");
            }
        }

        int[] array = new int[length];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        System.out.print("Початковий вигляд масиву: ");
        printArray(array);
        insertionSort(array);
        System.out.print("Відсортований масив: ");
        printArray(array);
        int key = 0;
        validInput = false;
        while (!validInput) {
            System.out.print("Введіть число для пошуку: ");
            String input = scanner.nextLine();
            try {
                key = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть ціле число.");
            }
        }
        int index = binarySearch(array, key);
        if (index != -1) {
            System.out.println("Індекс числа " + key + " у відсортованому масиві: " + index);
        } else {
            System.out.println("Число " + key + " не знайдено у масиві.");
        }
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int sortedIndex = i - 1;

            while (sortedIndex >= 0 && array[sortedIndex] > key) {
                array[sortedIndex + 1] = array[sortedIndex];
                sortedIndex = sortedIndex - 1;
            }
            array[sortedIndex + 1] = key;
        }
    }

    private static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == key) {
                return mid;
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}