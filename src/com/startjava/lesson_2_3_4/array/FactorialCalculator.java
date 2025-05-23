package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        int[] numbers1 = {};
        long[] factorials1 = calculateFactorial(numbers1);
        printFactorial(numbers1, factorials1);

        int[] numbers2 = null;
        long[] factorials2 = calculateFactorial(numbers2);
        printFactorial(numbers2, factorials2);

        int[] numbers3 = {8, 0, 9};
        long[] factorials3 = calculateFactorial(numbers3);
        printFactorial(numbers3, factorials3);

        int[] numbers4 = {-3, 1, 7, 13};
        long[] factorials4 = calculateFactorial(numbers4);
        printFactorial(numbers4, factorials4);

        int[] numbers5 = {-22, -0};
        long[] factorials5 = calculateFactorial(numbers5);
        printFactorial(numbers5, factorials5);
    }

    private static long[] calculateFactorial(int... numbers) {
        if (numbers == null) {
            return null;
        }

        long[] factorials = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                continue;
            }
            long factorialValue = 1;
            for (int j = 1; j <= numbers[i]; j++) {
                factorialValue *= j;
            }
            factorials[i] = factorialValue;
        }
        return factorials;
    }

    private static void printFactorial(int[] numbers, long... factorials) {
        if (numbers == null) {
            System.out.println("Ошибка ввода данных, расчет факториала невозможен\n");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Переданный массив не содержит данных, расчет факториала не возможен\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.println("Ошибка: факториал " + numbers[i] + "! не определен");
                continue;
            }
            if (numbers[i] == 0 || numbers[i] == 1) {
                System.out.println(numbers[i] + "! = " + factorials[i]);
            } else {
                System.out.print(numbers[i] + "! = ");
                for (int j = 1; j <= numbers[i]; j++) {
                    System.out.printf("%d%s", j, j != numbers[i] ? " * " : "");
                }
                System.out.println(" = " + factorials[i]);
            }
        }
        System.out.println();
    }
}
