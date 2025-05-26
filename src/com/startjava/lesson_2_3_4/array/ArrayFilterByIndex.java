package com.startjava.lesson_2_3_4.array;

public class ArrayFilterByIndex {
    private static int zeroedCount;
    private static final int ARRAY_SIZE = 15;

    public static void main(String[] args) {
        float[] original1 = generateRandomArray();
        int index = -1;
        float[] filtered1 = filterByIndexValue(original1, index);
        printResult(original1, filtered1, index);

        float[] original2 = generateRandomArray();
        index = 15;
        float[] filtered2 = filterByIndexValue(original2, index);
        printResult(original2, filtered2, index);

        float[] original3 = generateRandomArray();
        index = 0;
        float[] filtered3 = filterByIndexValue(original3, index);
        printResult(original3, filtered3, index);

        float[] original4 = generateRandomArray();
        index = 14;
        float[] filtered4 = filterByIndexValue(original4, index);
        printResult(original4, filtered4, index);
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
        System.out.println("Исходный массив:");
        for (int i = 0; i < original.length; i++) {
            System.out.printf("%.3f %s", original[i], i == 7 ? "\n" : " ");
        }

        System.out.printf("\n\nЗначение из ячейки по переданному индексу: = %.3f\n", original[index]);

        System.out.println("\nОткорректированный массив:");
        for (int i = 0; i < filtered.length; i++) {
            System.out.printf("%.3f %s", filtered[i], i == 7 ? "\n" : " ");
        }

        System.out.println("\n\nКоличество обнуленных ячеек: " + zeroedCount + "\n");
        zeroedCount = 0;
    }
}
