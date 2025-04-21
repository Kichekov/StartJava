import java.util.Scanner;

public class Calculator {
    private int firstOperand;
    private int secondOperand;
    private char sign;

    public int getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public char getSign() {
        return sign;
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

    @Override
    public String toString() {
        Object result;
        if (sign == '^' && secondOperand < 0) {
            result = 1.0 / calculate(getFirstOperand(), getSecondOperand());
        } else {
            result = calculate(getFirstOperand(), getSecondOperand());
        }

        return String.format("%d %c %d = %s", 
        getFirstOperand(), 
        getSign(), 
        getSecondOperand(), 
        result);
    }

    private int calculate(int firstOperand, int secondOperand) {
        int result = 0;
        return switch (sign) {
            case '+' -> firstOperand + secondOperand;
            case '-' -> firstOperand - secondOperand;
            case '*' -> firstOperand * secondOperand;
            case '/' -> firstOperand / secondOperand;
            case '%' -> firstOperand % secondOperand;
            case '^' -> exponentiate(firstOperand, secondOperand);
            default -> 0;
        };
    }

    private int exponentiate(int firstOperand, int secondOperand) {
        if (firstOperand == 0 && secondOperand < 0) {
            throw new IllegalArgumentException(
                "Функция возведения в степень нуля не определена" + 
                " для отрицательных показателей степени");
        }
        int counter = 1;
        int degreeModul = secondOperand < 0 ? secondOperand * -1 : secondOperand;
        for (int i = 0; i < degreeModul; i++) {
            counter *= firstOperand;
        }
        return counter;
    }
}
