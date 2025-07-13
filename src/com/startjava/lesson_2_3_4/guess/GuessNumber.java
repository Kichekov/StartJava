package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private Player playerOne;
    private Player playerTwo;
    private int targetNum;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start(Scanner scanner) {
        System.out.println("Игра началась! У каждого игрока по 10 попыток.");
        assignRandomNumber();
        boolean hasWinner = false;
        do {
            inputNumber(playerOne, scanner);
            playerOne.setTrial();

            if (isGuessed(playerOne)) {
                hasWinner = true;
                break;
            }
            isLastTrial(playerOne);
            scanner.nextLine();

            inputNumber(playerTwo, scanner);
            playerTwo.setTrial();
            if (isGuessed(playerTwo)) {
                hasWinner = true;
                break;
            }
            if (isLastTrial(playerTwo)) {
                break;
            }
        } while (!hasWinner);
        printTargetNum(playerOne);
        printTargetNum(playerTwo);

        playerOne.reset();
        playerTwo.reset();
    }

    private void assignRandomNumber() {
        targetNum = (int) (1 + Math.random() * 100);
    }

    private void inputNumber(Player player, Scanner scanner) {
        while (true) {
            System.out.print("\nПопытка N" + (player.getTrial() + 1) + "\n" +
                    "Число вводит " + player.getName() + ": ");
            try {
                int number = validateEnteredNumber(scanner);
                player.setNumber(number);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте еще раз:");
                scanner.nextLine();
            }
        }
    }

    private int validateEnteredNumber(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("Ошибка: введенные вами данные" +
                    " не являются натуральным числом.");
        }
        int enteredNumber = scanner.nextInt();
        if (enteredNumber < 1 || enteredNumber > 100) {
            throw new IllegalArgumentException("Число должно входить в отрезок [1, 100]." +
                    "\nПопробуйте еще раз.");
        }
        return enteredNumber;
    }

    private boolean isGuessed(Player player) {
        if (targetNum != player.getNumber()) {
            String message = player.getNumber() > targetNum ?
                    "больше" : "меньше";
            System.out.printf("%s %d %s того, что загадал компьютер\n",
                    player.getName(), player.getNumber(), message);
            return false;
        }
        System.out.printf("%s угадал число %d с %d-й попытки\n",
                player.getName(), targetNum, player.getTrial());
        return true;
    }

    private boolean isLastTrial(Player player) {
        if (player.getTrial() == Player.MAX_ATTEMPTS) {
            System.out.printf("У %s закончились попытки!%s\n",
                    player.getName(), player.equals(playerTwo) ? " Загаданное число: " + targetNum + "\n" : "");
            return true;
        }
        return false;
    }

    private void printTargetNum(Player player) {
        System.out.printf("%s ввел числа: ", player.getName());

        for (int number : player.getEnteredNumbers()) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

