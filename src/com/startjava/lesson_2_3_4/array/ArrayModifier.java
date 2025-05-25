package com.startjava.lesson_2_3_4.array;

public class ArrayModifier {
    private static int zeroedCount;

    public static void main(String[] args) {
        double[] originalArray1 = generateRandomArray(15);
        int index = -1;
        double[] filteredArray1 = createNewFilterArray(originalArray1, index);
        printResult(originalArray1, filteredArray1, index);

        double[] originalArray2 = generateRandomArray(15);
        index = 15;
        double[] filteredArray2 = createNewFilterArray(originalArray2, index);
        printResult(originalArray2, filteredArray2, index);

        double[] originalArray3 = generateRandomArray(15);
        index = 0;
        double[] filteredArray3 = createNewFilterArray(originalArray3, index);
        printResult(originalArray3, filteredArray3, index);

        double[] originalArray4 = generateRandomArray(15);
        index = 14;
        double[] filteredArray4 = createNewFilterArray(originalArray4, index);
        printResult(originalArray4, filteredArray4, index);
    }

    private static double[] generateRandomArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    private static double[] createNewFilterArray(double[] originalArray, int index) {
        if (index < 0 || index > originalArray.length - 1) {
            return originalArray;
        }

        zeroedCount = 0;
        double[] filteredArray = originalArray.clone();
        for (int i = 0; i < originalArray.length; i++) {
            if (filteredArray[i] > originalArray[index]) {
                filteredArray[i] = 0.0;
                zeroedCount++;
            }
        }
        return filteredArray;
    }

    private static void printResult(double[] originalArray, double[] filteredArray, int index) {
        if (index < 0 || index >= originalArray.length) {
            System.out.println("Ошибка, индекс указан некорректно\n");
            return;
        }
        System.out.println("Исходный массив:");
        for (int i = 0; i < originalArray.length; i++) {
            System.out.printf("%.3f %s", originalArray[i], i == 7 ? "\n" : " ");
        }

        System.out.printf("\n\nЗначение из ячейки по переданному индексу: = %.3f\n", originalArray[index]);

        System.out.println("\nОткорректированный массив:");
        for (int i = 0; i < filteredArray.length; i++) {
            System.out.printf("%.3f %s", filteredArray[i], i == 7 ? "\n" : " ");
        }

        System.out.println("\n\nКоличество обнуленных ячеек: " + zeroedCount);
        zeroedCount = 0;
    }
}
