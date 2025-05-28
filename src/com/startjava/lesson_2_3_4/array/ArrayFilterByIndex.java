package com.startjava.lesson_2_3_4.array;

public class ArrayFilterByIndex {
    private static int zeroedCount;
    private static final int ARRAY_SIZE = 15;

    public static void main(String[] args) {
        float[] original = generateRandomArray();
        int index = -1;
        float[] filtered = filterByIndexValue(original, index);
        printResult(original, filtered, index);

        original = generateRandomArray();
        index = 15;
        filtered = filterByIndexValue(original, index);
        printResult(original, filtered, index);

        original = generateRandomArray();
        index = 0;
        filtered = filterByIndexValue(original, index);
        printResult(original, filtered, index);

        original = generateRandomArray();
        index = 14;
        filtered = filterByIndexValue(original, index);
        printResult(original, filtered, index);
    }

    private static float[] generateRandomArray() {
        float[] array = new float[ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) Math.random();
        }
        return array;
    }

    private static float[] filterByIndexValue(float[] original, int index) {
        if (index < 0 || index > original.length - 1) {
            return original;
        }

        zeroedCount = 0;
        float[] filtered = original.clone();
        for (int i = 0; i < original.length; i++) {
            if (filtered[i] > original[index]) {
                filtered[i] = 0.0F;
                zeroedCount++;
            }
        }
        return filtered;
    }

    private static void printResult(float[] original, float[] filtered, int index) {
        if (index < 0 || index >= original.length) {
            System.out.printf("""
                    Ошибка: индекс %d вне допустимого диапазона. \
                    Укажите значение от 0 до %d включительно.
                    
                    """, index, original.length - 1);
            return;
        }

        printArray("Исходный массив:", original);

        System.out.printf("\n\nЗначение из ячейки по переданному индексу: = %.3f\n", original[index]);

        printArray("Откорректированный массив:", filtered);

        System.out.println("\n\nКоличество обнуленных ячеек: " + zeroedCount + "\n");
        zeroedCount = 0;
    }

    private static void printArray(String msg, float[] array) {
        System.out.println("\n" + msg);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f %s", array[i], i == 7 ? "\n" : " ");
        }
    }
}
