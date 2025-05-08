package com.startjava.lesson_2_3.calculator;

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
                int firstOperand = inputOperand(scanner, "Введите первый операнд: ");
                calc.setFirstOperand(firstOperand);

                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                char sign = scanner.next().charAt(0);
                calc.setSign(sign);

                int secondOperand = inputOperand(scanner, "Введите второй операнд: ");
                calc.setSecondOperand(secondOperand); 

                double calculationResult = calc.calculate();
                printResult(calc, calculationResult);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (ArithmeticException ex) {
                System.out.println("Ошибка: деление на ноль запрещено");
                scanner.nextLine();
            }

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                continueCalculation = scanner.next();
            } while (!continueCalculation.equals("yes") && !continueCalculation.equals("no"));
        } while (continueCalculation.equals("yes"));
    }

    private static int inputOperand(Scanner scanner, String msg) {
        System.out.printf("%s", msg);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        throw new IllegalArgumentException("Ошибка: Введенное значение не является целым числом");
    }

    private static void printResult(Calculator calc, double calculationResult) {
        if (calculationResult % 1 == 0) {
            System.out.printf("%d %c %d = %d\n", 
                    calc.getFirstOperand(), 
                    calc.getSign(), 
                    calc.getSecondOperand(), 
                    (int) calculationResult);
        } else {
            System.out.printf("%d %c %d = %f\n", 
                    calc.getFirstOperand(), 
                    calc.getSign(), 
                    calc.getSecondOperand(), 
                    calculationResult);
        }
    }
}
