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

    public void start() {
        Scanner scanner = new Scanner(System.in);
        assignRandomNumber();
        boolean hasWinner = false;
        do {
            playerOne.setNumber(inputNumber(playerOne, scanner));
            if (isGuessed(playerOne)) {
                hasWinner = true;
                return;
            }
            scanner.nextLine();
            playerTwo.setNumber(inputNumber(playerTwo, scanner));
            if (isGuessed(playerTwo)) {
                hasWinner = true;
                return;
            }
        } while (!hasWinner);
    }

    private void assignRandomNumber() {
        targetNum = (int) (1 + Math.random() * 100);
    }

    private int inputNumber(Player player, Scanner scanner) {
        while (true) {
            System.out.print(player.getName() + " введи число: ");
            try {
                return validateEnteredNumber(scanner);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
            throw new IllegalArgumentException("Ошибка: введенное Вами число не принадлежит " + 
                "заданному отрезку, повторите попытку.");
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
        System.out.printf("Победа!!! %s угадал число загаданное компьютером\n", player.getName());
        return true;
    }
}

