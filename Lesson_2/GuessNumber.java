import java.util.Scanner;

public class GuessNumber {
    private Player playerOne;
    private Player playerTwo;
    private int randomNumber;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        assignRandomNumber();
        boolean hasWinner = false;
        do {
            playerOne.setNumber(getPlayerInput(playerOne, scanner));
            if (compareWithRandomNumber(playerOne)) {
                hasWinner = true;
                return;
            }
            scanner.nextLine();
            playerTwo.setNumber(getPlayerInput(playerTwo, scanner));
            if (compareWithRandomNumber(playerTwo)) {
                hasWinner = true;
                return;
            }
        } while (!hasWinner);
    }

    private void assignRandomNumber() {
        randomNumber = (int) (1 + Math.random() * 100);
    }

    private int getPlayerInput(Player player, Scanner scanner) {
        while (true) {
            System.out.print(player.getName() + " введи число: ");
            try {
                int playerInput = validatePlayerInput(scanner);
                return playerInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private int validatePlayerInput(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("Ошибка: введенные вами данные" + 
                " не являются натуральным числом.");
        }
        int playerNumberInput = scanner.nextInt();
        if (playerNumberInput < 1 || playerNumberInput > 100) {
            throw new IllegalArgumentException("Ошибка: введенное Вами число не принадлежит " + 
                "заданному отрезку, повторите попытку.");
        } 
        return playerNumberInput;
    }

    private boolean compareWithRandomNumber(Player player) {
        if (randomNumber != player.getNumber()) {
            String message = player.getNumber() > randomNumber ? 
                    "больше" : "меньше";
            System.out.printf("%s %d %s того, что загадал компьютер\n", 
                    player.getName(), player.getNumber(), message);
            return false;
        } else {
            System.out.printf("Победа!!! %s угадал число загаданное компьютером\n", player.getName());
            return true;
        }
    }
}

