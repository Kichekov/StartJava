import java.util.Scanner;

public class Calculator {
    private int firstOperand;
    private int secondOperand;
    private char sign;

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public int getFirstOperand() {
        return this.firstOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public int getSecondOperand() {
        return this.secondOperand;
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
        return this.sign;
    }

    public double calculate() {
        return switch (sign) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '/' -> firstOperand / secondOperand;
            case '%' -> firstOperand % secondOperand;
            case '^' -> pow();
            default -> 0;
        };
    }

    private double pow() {
        if (firstOperand == 0 && secondOperand < 0) {
            throw new IllegalArgumentException(
                "Функция возведения в степень нуля не определена" + 
                " для отрицательных показателей степени");
        }
        int result = 1;
        int degreeModul = Math.abs(secondOperand);
        for (int i = 0; i < degreeModul; i++) {
            result *= firstOperand;
        }
        return secondOperand > 0 ? result : 1.0 / result;
    }
}