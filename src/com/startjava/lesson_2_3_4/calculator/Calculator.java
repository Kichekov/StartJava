package com.startjava.lesson_2_3_4.calculator;

import static java.lang.Double.NaN;

public class Calculator {
    private double firstOperand;
    private double secondOperand;
    private char sign;

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

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

    public char getSign() {
        return sign;
    }

    private double isValidateOperand(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            return NaN;
        }
    }

    public void inputException(String input) {
        String[] expression = input.split(" ");
        firstOperand = isValidateOperand(expression[0]);
        secondOperand = isValidateOperand(expression[2]);
        setSign(expression[1].charAt(0));
    }

    public double calculate() {
        return switch (sign) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '/' -> {
                if (secondOperand == 0) {
                    throw new ArithmeticException();
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
}
