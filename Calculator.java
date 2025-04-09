import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Для нахождения суммы введите: +
                Для нахождения разности введите: -
                Для нахождения произведения введите: *
                для нахождения частного введите: /
                Для возведения в степень введите: ^ 
                Для деления по модулю введите: %"""
        );
        char sign = scanner.next().charAt(0);
        if (sign != '+' && sign != '-' && sign != '*' &&
                sign != '/' && sign != '^' && sign != '%') {
            System.out.println("Ошибка: Данная операция не предусмотрена");
            return;
        }
        int result = 0;
        int firstOperand = 0;
        int secondOperand = 0;
        int base = 0;
        int degree = 0;
        if (sign != '^') {
            firstOperand = setValue(scanner, "первый");
            secondOperand = setValue(scanner, "второй");
            if (sign == '+') {
                result = firstOperand + secondOperand;
            } else if (sign == '-') {
                result = firstOperand - secondOperand;
            } else if (sign == '*') {
                result = firstOperand * secondOperand;
            } else if (sign == '/') {
                result = firstOperand / secondOperand;
            } else if (sign == '%') {
                result = firstOperand % secondOperand;
            }
        } else {
            base = setDegree(scanner, "Введите основание степени: ");
            degree = setDegree(scanner, "Введите степень: ");
            result = base;
            for (int i = 1; i < degree; i++) {
                result *= base;
            }
        }
        System.out.printf("%d %c %d = %d \n",
                sign != '^' ? firstOperand : base, sign,
                sign != '^' ? secondOperand : degree, result);
    }

    public static int setValue(Scanner scanner, String operandNumber) {
        System.out.printf("Введите %s операнд: ", operandNumber);
        int operand = 0;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
            if (operand < 1) {
                System.out.println("Ошибка: Операнд не является натуральным числом");
                System.exit(1); ;
            }
        } else {
            System.out.println("Ошибка: Операнд не является натуральным числом");
            System.exit(1); ;
        }
        return operand;
    }

    public static int setDegree(Scanner scanner, String operandNumber) {
        System.out.printf("%s", operandNumber);
        int operand = 0;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
            if (operand < 1) {
                System.out.println("Ошибка: Операнд не является натуральным числом");
                System.exit(1); ;
            }
        } else {
            System.out.println("Ошибка: Операнд не является натуральным числом");
            System.exit(1); ;
        }
        return operand;
    }
}