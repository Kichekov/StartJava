import java.util.Scanner;

class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator expression = new Calculator();
        String calculationsRestart = "";
        do {
            if (calculationsRestart.equals("yes")) {
                System.out.println();
            }
            try {
                int firstOperand = inputOperand(scanner, "Введите первый операнд: ");
                expression.setFirstOperand(firstOperand);

                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                char sign = scanner.next().charAt(0);
                expression.setSign(sign);

                int secondOperand = inputOperand(scanner, "Введите второй операнд: ");
                expression.setSecondOperand(secondOperand); 

                double calculationResult = expression.calculate();
                expression.printResult(calculationResult);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (ArithmeticException ex) {
                System.out.println("Ошибка: деление на ноль запрещено");
                scanner.nextLine();
            }

            calculationsRestart = "";
            while (!calculationsRestart.equals("yes") && !calculationsRestart.equals("no")) {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                calculationsRestart = scanner.next();
            }
        } while (calculationsRestart.equals("yes"));
    }

    private static int inputOperand(Scanner scanner, String msg) {
        System.out.printf("%s", msg);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        throw new IllegalArgumentException("Ошибка: Введенное значение не является целым числом");
    }
}