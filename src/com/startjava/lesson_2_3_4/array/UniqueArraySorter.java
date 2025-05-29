package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueArraySorter {
    public static void main(String[] args) {
        int[] numbers = generateRandomArray(-30, -10, 23);
        sortArray(numbers);
        printArray(numbers, 23);

        numbers = generateRandomArray(10, 50, 10);
        sortArray(numbers);
        printArray(numbers, 10);

        numbers = generateRandomArray(-34, -34, 0);
        sortArray(numbers);
        printArray(numbers, 0);

        numbers = generateRandomArray(-1, 2, -3);
        sortArray(numbers);
        printArray(numbers, -3);

        numbers = generateRandomArray(5, -8, 2);
        sortArray(numbers);
        printArray(numbers, 2);
    }

    private static int[] generateRandomArray(int startRange, int endRange, int itemsPerLine) {
        int range = endRange - startRange + 1;
        int size = (int) (range * 0.75);

        if (startRange > endRange) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)\n\n", startRange, endRange);
            return null;
        }

        if (itemsPerLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)\n", itemsPerLine);
            return null;
        }

        if (size <= 0) {
            System.out.printf("Ошибка: длина массива должна быть > 0 (%d)\n", size);
            return null;
        }

        Random random = new Random();
        int[] uniqueNumbers = new int[size];
        int uniqueCount = 0;
        while (uniqueCount < size) {
            int number = startRange + random.nextInt(range);
            boolean isFound = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueNumbers[j] == number) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                uniqueNumbers[uniqueCount++] = number;
            }
        }
        return Arrays.copyOf(uniqueNumbers, uniqueCount);
    }

    private static void sortArray(int[] numbers) {
        if (numbers == null) {
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    isSwapped = true;
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    private static void printArray(int[] numbers, int itemsPerLine) {
        if (numbers == null) {
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d%s", numbers[i], (i + 1) % itemsPerLine == 0 ? "\n" : " ");
        }

        if (numbers.length % itemsPerLine != 0) {
            System.out.println();
        }

        System.out.println();
    }
}

