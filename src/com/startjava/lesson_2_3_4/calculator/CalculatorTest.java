package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueCalculation = "";
        do {
            if (continueCalculation.equals("yes")) {
                System.out.println();
            }
            try {
                System.out.println("Введите выражение из трех аргументов, например, 2 ^ 10:");
                String expression = scanner.nextLine();
                expression = expression.trim().replaceAll("\\s+", " ");

                double calculationResult = Calculator.calculate(expression);
                printResult(expression, calculationResult);
            } catch (IllegalArgumentException | ArithmeticException | UnsupportedOperationException |
                     InputMismatchException | UnknownOperatorException e) {
                System.out.println(e.getMessage());
            }

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                continueCalculation = scanner.nextLine();
            } while (!continueCalculation.equals("yes") && !continueCalculation.equals("no"));
        } while (continueCalculation.equals("yes"));
    }

    private static void printResult(String expression, double calculationResult) {
        DecimalFormat df = new DecimalFormat("#.###");
        String formattedResult = df.format(calculationResult);
        System.out.printf("%s = %s\n", expression, formattedResult);
    }
}
