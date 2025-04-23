import java.util.Scanner;

public class Calculator {
    private int firstOperand;
    private int secondOperand;
    private char sign;

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
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

    public double calculate() {
        return switch (sign) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '/' -> firstOperand / secondOperand;
            case '%' -> firstOperand % secondOperand;
            case '^' -> exponentiate();
            default -> 0;
        };
    }

    public void printResult(double calculationResult) {
        if (calculationResult % 1 == 0) {
            System.out.printf("%d %c %d = %d\n", 
                    firstOperand, 
                    sign, 
                    secondOperand, 
                    (int) calculationResult);
        } else {
            System.out.printf("%d %c %d = %f\n", 
                    firstOperand, 
                    sign, 
                    secondOperand, 
                    calculationResult);
        }
    }

    private double exponentiate() {
        if (firstOperand == 0 && secondOperand < 0) {
            throw new IllegalArgumentException(
                "Функция возведения в степень нуля не определена" + 
                " для отрицательных показателей степени");
        }
        int computedValue = 1;
        int degreeModul = Math.abs(secondOperand);
        for (int i = 0; i < degreeModul; i++) {
            computedValue *= firstOperand;
        }
        return secondOperand > 0 ? computedValue : 1.0 / computedValue;
    }
}