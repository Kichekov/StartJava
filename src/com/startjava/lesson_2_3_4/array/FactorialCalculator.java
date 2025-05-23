package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    public static void main(String[] args) {
        int[] numbers = {};
        long[] factorials = calculateFactorial(numbers);
        printFactorialsExpr(numbers, factorials);

        numbers = null;
        factorials = calculateFactorial(numbers);
        printFactorialsExpr(numbers, factorials);

        numbers = new int[]{8, 0, 9};
        factorials = calculateFactorial(numbers);
        printFactorialsExpr(numbers, factorials);

        numbers = new int[]{-3, 1, 7, 13};
        factorials = calculateFactorial(numbers);
        printFactorialsExpr(numbers, factorials);

        numbers = new int[]{-22, -0};
        factorials = calculateFactorial(numbers);
        printFactorialsExpr(numbers, factorials);
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

    private static void printFactorialsExpr(int[] numbers, long[] factorials) {
        if (numbers == null) {
            System.out.println("Ошибка: массив не инициализирован\n");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Массив пуст. Нет данных для вывода факториалов.\n");
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
                StringBuilder expression = new StringBuilder(numbers[i] + "! = ");
                for (int j = 1; j <= numbers[i]; j++) {
                    expression.append(String.format("%d%s", j, j != numbers[i] ? " * " : ""));
                }
                expression.append(" = ").append(factorials[i]);
                System.out.println(expression);
            }
        }
        System.out.println();
    }
}
