import java.util.Scanner;

class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator expression = new Calculator();
        String result = "";
        do {
            try {
                int firstOperand = inputOperand(scanner, "Введите первый операнд: ");
                expression.setFirstOperand(firstOperand);

                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                char sign = scanner.next().charAt(0);
                expression.setSign(sign);

                int secondOperand = inputOperand(scanner, "Введите второй операнд: ");
                expression.setSecondOperand(secondOperand); 

                System.out.println(expression);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (ArithmeticException ex) {
                System.out.println("Ошибка: деление на ноль запрещено");
                scanner.nextLine();
            }

            while (true) {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                result = scanner.next();
                if (result.equals("yes")) {
                    System.out.println();
                    break;
                }
                if (result.equals("no")) {
                    break;
                }
            }
        } while (result.equals("yes"));
    }

    private static int inputOperand(Scanner scanner, String msg) {
        System.out.printf("%s", msg);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        throw new IllegalArgumentException("Ошибка: Введенное значение не является целым числом");
    }
}