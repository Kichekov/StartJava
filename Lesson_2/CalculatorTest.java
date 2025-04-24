import java.util.Scanner;

class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator expression = new Calculator();
        String continueCalculations = "";
        do {
            if (continueCalculations.equals("yes")) {
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
                printResult(expression, calculationResult);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (ArithmeticException ex) {
                System.out.println("Ошибка: деление на ноль запрещено");
                scanner.nextLine();
            }

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                continueCalculations = scanner.next();
            } while (!continueCalculations.equals("yes") && !continueCalculations.equals("no"));
        } while (continueCalculations.equals("yes"));
    }

    public static void printResult(Calculator expression, double calculationResult) {
        if (calculationResult % 1 == 0) {
            System.out.printf("%d %c %d = %d\n", 
                    expression.getFirstOperand(), 
                    expression.getSign(), 
                    expression.getSecondOperand(), 
                    (int) calculationResult);
        } else {
            System.out.printf("%d %c %d = %f\n", 
                    expression.getFirstOperand(), 
                    expression.getSign(), 
                    expression.getSecondOperand(), 
                    calculationResult);
        }
    }

    private static int inputOperand(Scanner scanner, String msg) {
        System.out.printf("%s", msg);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        throw new IllegalArgumentException("Ошибка: Введенное значение не является целым числом");
    }
}