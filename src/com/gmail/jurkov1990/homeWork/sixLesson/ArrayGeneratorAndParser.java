package com.gmail.jurkov1990.homeWork.sixLesson;

import java.util.Random;
import java.util.Scanner;

public class ArrayGeneratorAndParser {
    public static void main(String[] args) {
        int arraySize = readArraySize();
        int[] numbers = generateRandomArray(arraySize, -100, 100);
        int minIndex = findMinIndex(numbers);
        int maxIndex = findMaxIndex(numbers);

        System.out.println("Елементи масиву: " + arrayToString(numbers));
        System.out.println("Сума від'ємних чисел: " + calculateNegativeSum(numbers));
        System.out.println("Кількість парних чисел: " + countEvenNumbers(numbers));
        System.out.println("Кількість непарних чисел: " + countOddNumbers(numbers));
        System.out.println("Найменший елемент: " + numbers[minIndex] + " (з індексом " + minIndex + ")");
        System.out.println("Найбільший елемент: " + numbers[maxIndex] + " (з індексом " + maxIndex + ")");

        Double average = averageAfterFirstNegative(numbers);
        if (average == null) {
            System.out.println("Від'ємних чисел немає або після першого від'ємного немає елементів.");
        } else {
            System.out.printf("Середнє арифметичне чисел після першого від'ємного числа: %.2f\n", average);
        }
    }

    public static int readArraySize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмір масиву: ");
        return scanner.nextInt();
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        int[] myArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            myArray[i] = random.nextInt(max - min + 1) + min;
        }
        return myArray;
    }

    public static String arrayToString(int[] myArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < myArray.length; i++) {
            stringBuilder.append(myArray[i]);
            if (i < myArray.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static int calculateNegativeSum(int[] myArray) {
        int sum = 0;
        for (int j : myArray) {
            if (j < 0) {
                sum += j;
            }
        }
        return sum;
    }

    public static int countEvenNumbers(int[] myArray) {
        int count = 0;
        for (int j : myArray) {
            if (j % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countOddNumbers(int[] myArray) {
        int count = 0;
        for (int j : myArray) {
            if (j % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int findMinIndex(int[] myArray) {
        int minIndex = 0;
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i] < myArray[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findMaxIndex(int[] myArray) {
        int maxIndex = 0;
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i] > myArray[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static Double averageAfterFirstNegative(int[] myArray) {
        int firstNegativeIndex = -1;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] < 0) {
                firstNegativeIndex = i;
                break;
            }
        }
        if (firstNegativeIndex == -1 || firstNegativeIndex == myArray.length - 1) {
            return null;
        }
        int sum = 0;
        int count = 0;
        for (int i = firstNegativeIndex + 1; i < myArray.length; i++) {
            sum += myArray[i];
            count++;
        }
        return (double) sum / count;
    }
}