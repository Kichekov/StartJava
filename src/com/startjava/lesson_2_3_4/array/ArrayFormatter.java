package com.startjava.lesson_2_3_4.array;

public class ArrayFormatter {
    public static void main(String[] args) {
        double[] originalArray = new double[15]; //  создаем пустой массив из 15 элементов
        originalArray = fillingRandomNumbers(originalArray); // заполняем массив случайными вещественными числами
        int index = 3;// индекс
        try {
            double[] formattedArray = createNewArray(index, originalArray);// новый массив
            printArray(originalArray, formattedArray, index);// вывод на печать
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double[] fillingRandomNumbers(double[] originalArray) { // Заполнение массива случайными числами
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = Math.random();
        }
        return originalArray;
    }
    //!!! НЕВЕРНОЕ ФОРМИРОВАНИЕ НОВОГО МАССИВА, НУЖНО ЗАМЕНИТЬ ЗНАЧЕНИЯ В МАССИВЕ ПО ЗНАЧЕНИЮ А НЕ ПО ИНДЕКСУ
    private static double[] createNewArray(int index, double[] originalArray) { //Метод создает новый массив при помощи index и originalArray
        double[] formattedArray = originalArray.clone();
        isValidIndex(index, originalArray);
        for (int i = 0; i < originalArray.length; i++) {
            if (formattedArray[i] > originalArray[index]) {
                formattedArray[i] = 0;
            }
        }
        return formattedArray;
    }

    private static void isValidIndex(int index, double[] originalArray) { // Метод проверяющий корретность переданного index
        if (index < 0 || index > originalArray.length - 1) {
            throw new IllegalArgumentException("Ошибка, индекс указан некорректно");
        }
    }

    private static int countZeroCells(double[] formattedArray) {
        int counterDesiredNumber = 0;
        for (double number : formattedArray) {
            if (number == 0.000) {
                counterDesiredNumber += 1;
            }
        }
        return counterDesiredNumber;
    }

    private static void printArray(double[] originalArray, double[] formattedArray, int index) {
        System.out.println("Исходный массив:");
        for (int i = 0; i < originalArray.length; i++) {
            System.out.printf("%.3f %s", originalArray[i], i == 7 ? "\n" : " ");
        }

        System.out.printf("\n\nЗначение из ячейки по переданному индексу: = %.3f\n", originalArray[index]);

        System.out.println("\nОткорректированный массив:");
        for (int i = 0; i < formattedArray.length; i++) {
            System.out.printf("%.3f %s", formattedArray[i], i == 7 ? "\n" : " ");
        }

        System.out.println("\n\nКоличество обнуленных ячеек: " + countZeroCells(formattedArray));
    }
}
