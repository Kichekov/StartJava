package com.startjava.lesson_1.final_;

import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Для нахождения суммы введите: +
                Для нахождения разности введите: -
                Для нахождения произведения введите: *
                для нахождения частного введите: /
                Для возведения в степень введите: ^ 
                Для деления по модулю введите: %"""
        );
        char sign = scanner.next().charAt(0);
        if (sign != '+' && sign != '-' && sign != '*' &&
                sign != '/' && sign != '^' && sign != '%') {
            System.out.println("Ошибка: Данная операция не предусмотрена");
            return;
        }
        int result = 0;
        int firstOperand = 0;
        int secondOperand = 0;
        int base = 0;
        int degree = 0;
        if (sign != '^') {
            try {
                firstOperand = inputOperand(scanner, "Введите первый операнд: ");
                isValid(firstOperand);
                secondOperand = inputOperand(scanner, "Введите второй операнд: ");
                isValid(secondOperand);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            if (sign == '+') {
                result = firstOperand + secondOperand;
            } else if (sign == '-') {
                result = firstOperand - secondOperand;
            } else if (sign == '*') {
                result = firstOperand * secondOperand;
            } else if (sign == '/') {
                result = firstOperand / secondOperand;
            } else if (sign == '%') {
                result = firstOperand % secondOperand;
            }
        } else {
            try {
                base = inputOperand(scanner, "Введите основание степени: ");
                isValid(base);
                degree = inputOperand(scanner, "Введите степень: ");
                isValid(degree);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            result = base;
            for (int i = 1; i < degree; i++) {
                result *= base;
            }
        }
        System.out.printf("%d %c %d = %d \n",
                sign != '^' ? firstOperand : base, sign,
                sign != '^' ? secondOperand : degree, result);
    }

    private static int inputOperand(Scanner scanner, String msg) {
        System.out.printf("%s", msg);
        int operand = 0;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
            if (operand < 1) {
                return 0;
            }
        } else {
            return 0;
        }
        return operand;
    }

    public static void isValid(int operand) throws IllegalArgumentException {
        if (operand == 0) {
            throw new IllegalArgumentException("Ошибка: Операнд не является натуральным числом");
        }
    }
}
