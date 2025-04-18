import java.util.Scanner;

public class Calculator {
    private int firstOperand;
    private int secondOperand;
    private char sign;

    public Calculator() {
    }

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

    public void setSign(char sign) throws IllegalArgumentException {
        switch (sign) {
            case '+', '-', '*', '/', '^', '%':
                this.sign = sign;
                break;
            default:
                throw new IllegalArgumentException("Ошибка: операция " + sign + " не поддерживается");
        }
    }

    public String formatExpressionWithResult() {
        boolean isNegativeDegree = (sign == '^' && secondOperand < 0);
        if (!isNegativeDegree) {
            return String.format("%d %c %d = %d", 
            getFirstOperand(), 
            getSign(), 
            getSecondOperand(), 
            calculateResult(getFirstOperand(), getSecondOperand()));
        } else {
            return String.format("%d %c %d = %f", 
            getFirstOperand(), 
            getSign(), 
            getSecondOperand(), 
            negativeExponentiate(getFirstOperand(), getSecondOperand()));
        }
    }

    private int calculateResult(int firstOperand, int secondOperand) {
        int result = 0;
        switch (sign) {
            case '+' -> result = firstOperand + secondOperand;
            case '-' -> result = firstOperand - secondOperand;
            case '*' -> result = firstOperand * secondOperand;
            case '/' -> result = firstOperand / secondOperand;
            case '%' -> result = firstOperand % secondOperand;
            case '^' -> result = positiveExponentiate(firstOperand, secondOperand);
            default -> result = 0;
        }
        return result;
    }

    private int positiveExponentiate(int firstOperand, int secondOperand) {
        int counter = 1;
        for (int i = 0; i < secondOperand; i++) {
            counter *= firstOperand;
        }
        return counter;
    }

    private double negativeExponentiate(int firstOperand, int secondOperand) throws ArithmeticException {
        if (firstOperand == 0) {
            throw new ArithmeticException();
        }

        double counter = 1.0;
        int degreeModul = -secondOperand;
        for (int j = 0; j < degreeModul; j++) {
            counter *= firstOperand;
        }
        return 1 / counter;
    }
}
