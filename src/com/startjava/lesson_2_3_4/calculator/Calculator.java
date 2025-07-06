package com.startjava.lesson_2_3_4.calculator;

import static java.lang.Double.NaN;

public class Calculator {
    private double firstOperand;
    private double secondOperand;
    private char sign;

    public void setSign(char sign) {
        switch (sign) {
            case '+', '-', '*', '/', '^', '%':
                this.sign = sign;
                break;
            default:
                throw new IllegalArgumentException("Ошибка: операция " + sign +
                        " не поддерживается");
        }
    }

    public double calculate(String expression) {
        String[] parts = expression.split(" ");
        firstOperand = isValidateOperand(parts[0]);
        secondOperand = isValidateOperand(parts[2]);
        setSign(parts[1].charAt(0));

        return switch (sign) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '/' -> {
                if (secondOperand == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль запрещено");
                }
                yield firstOperand / secondOperand;
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
            default -> 0;
        };
    }

    private double isValidateOperand(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            return NaN;
        }
    }
}
