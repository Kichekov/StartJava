import java.util.Scanner;

class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator expression = new Calculator();
        boolean isRunning = true;
        do {
            try {
                int firstOperand = inputOperand(scanner, "Введите первый операнд: ");
                expression.setFirstOperand(firstOperand);

                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                char sign = scanner.next().charAt(0);
                expression.setSign(sign);

                int secondOperand = inputOperand(scanner, "Введите второй операнд: ");
                expression.setSecondOperand(secondOperand); 

                System.out.println(expression.formatExpressionWithResult());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException ex) {
                System.out.println("Ошибка: деление на ноль запрещено");
            }

            String result = "";
            while (true) {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                result = scanner.next();
                if (result.equals("yes") || result.equals("no")) {
                    if (result.equals("yes")) {
                        System.out.println();
                    } 
                    break;
                }
            }
            isRunning = result.equals("yes");
        } while (isRunning);
    }

    private static int inputOperand(Scanner scanner, String msg) throws IllegalArgumentException {
        System.out.printf("%s", msg);
        int operand = 0;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            throw new IllegalArgumentException("Ошибка: Введенное значение не является целым числом");
        }
        return operand;
    }
}