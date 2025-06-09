package com.gmail.jurkov1990.homework.eight;


import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введіть розмірність матриці (ціле число > 0): ");
            String input = scanner.nextLine();
            try {
                size = Integer.valueOf(input);
                if (size <= 0) {
                    System.out.println("Помилка: розмірність матриці повинна бути більше 0.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть ціле число.");
            }
        }

        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }

        System.out.println("Матриця " + size + "x" + size + ":");
        printMatrix(matrix);

        int sumEvenRows = 0;
        int sumOddRows = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 == 0) {
                    sumEvenRows += matrix[i][j];
                } else {
                    sumOddRows += matrix[i][j];
                }
            }
        }

        long productEvenColumns = 1;
        long productOddColumns = 1;

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (j % 2 == 0) {
                    productEvenColumns *= matrix[i][j];
                } else {
                    productOddColumns *= matrix[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках: " + sumEvenRows);
        System.out.println("Сума елементів у непарних рядках: " + sumOddRows);
        System.out.println("Добуток елементів у парних стовпцях: " + productEvenColumns);
        System.out.println("Добуток елементів у непарних стовпцях: " + productOddColumns);

        boolean isMagicSquare = checkMagicSquare(matrix);
        if (isMagicSquare) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
        scanner.close();
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean checkMagicSquare(int[][] matrix) {
        int size = matrix.length;
        int[] rowSums = new int[size];
        int[] colSums = new int[size];
        int leftDiagonal = 0;
        int rightDiagonal = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rowSums[i] += matrix[i][j];
                colSums[j] += matrix[i][j];
                if (i == j) {
                    leftDiagonal += matrix[i][j];
                }
                if (i + j == size - 1) {
                    rightDiagonal += matrix[i][j];
                }
            }
        }

        int magicSum = rowSums[0];

        for (int i = 1; i < size; i++) {
            if (rowSums[i] != magicSum) {
                return false;
            }
        }

        for (int j = 0; j < size; j++) {
            if (colSums[j] != magicSum) {
                return false;
            }
        }
        return leftDiagonal == magicSum && rightDiagonal == magicSum;
    }
}