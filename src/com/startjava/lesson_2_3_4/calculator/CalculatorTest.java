package com.startjava.lesson_2_3_4.calculator;

import java.util.Locale;
import java.util.Scanner;

class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        String continueCalculation = "";
        do {
            if (continueCalculation.equals("yes")) {
                System.out.println();
            }
            try {
                System.out.println("Введите выражение из трех аргументов, например, 2 ^ 10:");
                String input = scanner.nextLine();
                calc.inputException(input);

                double calculationResult = calc.calculate();
                printResult(calc, calculationResult);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException ex) {
                System.out.println("Ошибка: деление на ноль запрещено");
            }

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                continueCalculation = scanner.nextLine();
            } while (!continueCalculation.equals("yes") && !continueCalculation.equals("no"));
        } while (continueCalculation.equals("yes"));
    }

    private static void printResult(Calculator calc, double calculationResult) {
        if (Double.isNaN(calculationResult)) {
            System.out.println("Один из операндов не является целым числом");
            return;
        }
        int firstOperand = (int) calc.getFirstOperand();
        int secondOperand = (int) calc.getSecondOperand();
        char sign = calc.getSign();

        if (calculationResult % 1 == 0) {
            System.out.printf("%d %c %d = %d%n", firstOperand, sign, secondOperand, (int) calculationResult);
        } else {
            String formattedResult = String.format(Locale.US, "%.3f", calculationResult)
                    .replaceAll("0+$", "")
                    .replaceAll("\\.$", "");
            System.out.printf("%d %c %d = %s%n", firstOperand, sign, secondOperand, formattedResult);
        }
    }
}
