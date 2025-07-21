package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private final Player playerOne;
    private final Player playerTwo;
    private int targetNumber;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start(Scanner scanner) {
        System.out.println("Игра началась! У каждого игрока по 10 попыток.");
        initTargetNumber();
        boolean hasWinner = false;
        while (!hasWinner) {
            inputNumber(playerOne, scanner);
            playerOne.incAttempt();

            if (isGuessed(playerOne)) {
                hasWinner = true;
                continue;
            }
            hasAttempt(playerOne);
            scanner.nextLine();

            inputNumber(playerTwo, scanner);
            playerTwo.incAttempt();
            if (isGuessed(playerTwo)) {
                hasWinner = true;
                continue;
            }
            if (hasAttempt(playerTwo)) {
                break;
            }
        }
        printAttempts(playerOne);
        printAttempts(playerTwo);

        playerOne.reset();
        playerTwo.reset();
    }

    private void initTargetNumber() {
        targetNumber = (int) (Player.MIN_NUMBER + Math.random() * Player.MAX_NUMBER);
    }

    private void inputNumber(Player player, Scanner scanner) {
        while (true) {
            System.out.printf("""
                    
                    Попытка N %d
                    Число вводит %s:\s""".formatted(player.getAttempt() + 1, player.getName())
            );
            try {
                int number = validateEnteredNumber(scanner);
                player.addNumber(number);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private int validateEnteredNumber(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("\nОшибка: введенные вами данные" +
                    " не являются натуральным числом.");
        }
        int enteredNumber = scanner.nextInt();
        if (enteredNumber < Player.MIN_NUMBER || enteredNumber > Player.MAX_NUMBER) {
            throw new IllegalArgumentException("""
                    Число должно входить в отрезок [%d, %d].
                    Попробуйте еще раз.""".formatted(Player.MIN_NUMBER, Player.MAX_NUMBER));
        }
        return enteredNumber;
    }

    private boolean isGuessed(Player player) {
        if (targetNumber != player.getNumber()) {
            String message = player.getNumber() > targetNumber ?
                    "больше" : "меньше";
            System.out.printf("%s %d %s того, что загадал компьютер\n",
                    player.getName(), player.getNumber(), message);
            return false;
        }
        System.out.printf("%s угадал число %d с %d-й попытки\n",
                player.getName(), targetNumber, player.getAttempt());
        return true;
    }

    private boolean hasAttempt(Player player) {
        if (player.getAttempt() == Player.MAX_ATTEMPTS) {
            System.out.printf("""
                    У %s закончились попытки!%s
                    """.formatted(player.getName(),
                    player.equals(playerTwo) ? """
                             Загаданное число: %d
                            """.formatted(targetNumber) : "")
            );
            return true;
        }
        return false;
    }

    private void printAttempts(Player player) {
        System.out.printf("%s ввел числа: ", player.getName());

        for (int number : player.getEnteredNumbers()) {
            System.out.printf("""
                    %d + \s""".formatted(number));
        }
        System.out.println();
    }
}

