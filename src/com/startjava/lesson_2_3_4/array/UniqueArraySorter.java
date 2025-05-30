package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueArraySorter {
    public static void main(String[] args) {
        int[] numbers = generateRandomArray(-30, -10, 23);
        printArray(numbers, 23);

        numbers = generateRandomArray(10, 50, 10);
        printArray(numbers, 10);

        numbers = generateRandomArray(-34, -34, 0);
        printArray(numbers, 0);

        numbers = generateRandomArray(-1, 2, -3);
        printArray(numbers, -3);

        numbers = generateRandomArray(5, -8, 2);
        printArray(numbers, 2);
    }

    private static int[] generateRandomArray(int startRange, int endRange, int itemsPerLine) {
        int range = endRange - startRange + 1;

        if (startRange > endRange) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)\n\n", startRange, endRange);
            return null;
        }

        if (itemsPerLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)\n", itemsPerLine);
            return null;
        }

        int size = (int) (range * 0.75);
        if (size <= 0) {
            System.out.printf("Ошибка: длина массива должна быть > 0 (%d)\n", size);
            return null;
        }

        Random random = new Random();
        int[] uniqueNumbers = new int[size];
        int uniqueCount = 0;
        while (uniqueCount < size) {
            int currNumber = startRange + random.nextInt(range);
            boolean isUnique = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueNumbers[j] == currNumber) {
                    isUnique = true;
                    break;
                }
            }
            if (!isUnique) {
                uniqueNumbers[uniqueCount++] = currNumber;
            }
        }
        Arrays.sort(uniqueNumbers);
        return Arrays.copyOf(uniqueNumbers, uniqueCount);
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

