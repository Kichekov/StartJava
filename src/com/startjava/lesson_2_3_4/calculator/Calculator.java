package com.startjava.lesson_2_3_4.calculator;

import java.util.InputMismatchException;

public class Calculator {
    public static final int MAX_EXPRESSION_LENGTH = 3;

    public static double calculate(String expression) {
        String[] parts = validateExpressionLength(expression);
        int firstOperand = validateOperand(parts[0]);
        int secondOperand = validateOperand(parts[2]);
        char sign = validateSign(parts[1]);

        return switch (sign) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '/' -> {
                if (secondOperand == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль запрещено");
                }
                yield (double) firstOperand / secondOperand;
            }
            case '%' -> Math.IEEEremainder(firstOperand, secondOperand);
            case '^' -> {
                if (firstOperand == 0 && secondOperand < 0) {
                    throw new IllegalArgumentException(
                            "Функция возведения в степень нуля не определена" +
                                    " для отрицательных показателей степени");
                }
                yield Math.pow(firstOperand, secondOperand);
            }
            default -> throw new UnsupportedOperationException("Ошибка: операция " + sign +
                    " не поддерживается");
        };
    }

    private static String[] validateExpressionLength(String expression) {
        String[] parts = expression.split(" ");
        if (parts.length != MAX_EXPRESSION_LENGTH) {
            throw new InputMismatchException("Ошибка: выражение должно содержать ровно 3 элемента " +
                    "(операнд, оператор, операнд)");
        }
        return parts;
    }

    private static int validateOperand(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Операнд " + operand + " не является целым числом");
        }
    }

    private static char validateSign(String sign) {
        if (sign.length() > 1) {
            throw new UnknownOperatorException(
                    "Ошибка: оператор должен быть одним из символов + - * / % ^");
        }
        return sign.charAt(0);
    }
}

class UnknownOperatorException extends RuntimeException {
    public UnknownOperatorException(String message) {
        super(message);
    }
}
