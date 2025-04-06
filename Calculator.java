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
            System.out.println("Введите первый операнд: ");
            if (scanner.hasNextInt()) {
                firstOperand = scanner.nextInt();
                if (firstOperand < 1) {
                    System.out.println("Ошибка: Операнд не является натуральным числом");
                    return;
                }
            } else {
                System.out.println("Ошибка: Операнд не является натуральным числом");
                return;
            }
            System.out.println("Введите второй операнд: ");
            if (scanner.hasNextInt()) {
                secondOperand = scanner.nextInt();
                if (secondOperand < 1) {
                    System.out.println("Ошибка: Операнд не является натуральным числом");
                    return;
                }
            } else {
                System.out.println("Ошибка: Операнд не является натуральным числом");
                return;
            }
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
            System.out.println("Введите основание степени: ");
            base = scanner.nextInt();
            System.out.println("Введите степень: ");
            degree = scanner.nextInt();
            result = base;
            for (int i = 1; i < degree; i++) {
                result *= base;
            }
        }
        System.out.printf("%d %c %d = %d \n", 
                sign != '^' ? firstOperand : base, sign, 
                sign != '^' ? secondOperand : degree, result);
    }
}