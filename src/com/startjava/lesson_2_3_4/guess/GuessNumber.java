package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private final Player[] players = new Player[3];
    private int targetNumber;
    private int round;
    private boolean isCurrentRoundEnded = false;

    public GuessNumber(Player playerOne, Player playerTwo, Player playerThree) {
        Player[] tempPlayers = {playerOne, playerTwo, playerThree};
        Random random = new Random();
        for (int i = 0; i < tempPlayers.length; i++) {
            Player nextElement = tempPlayers[i];
            int insert = random.nextInt(i + 1);
            if (insert == i) {
                players[insert] = nextElement;
            } else {
                players[i] = players[insert];
                players[insert] = nextElement;
            }
        }
    }

    public void start(Scanner scanner) {
        System.out.println("\nЖребий брошен, игра началась! У каждого игрока по 10 попыток.");

        while (!isGameOver()) {
            initTargetNumber();
            while (!isCurrentRoundEnded) {
                for (int i = 0; i < 3; i++) {
                    inputNumber(players[i], scanner);
                    players[i].incAttempt();

                    if (isGuessed(players[i])) {
                        players[i].incVictory();
                        round++;
                        isCurrentRoundEnded = true;
                        break;
                    }
                    hasAttempt(players[i]);

                    if (hasAttempt(players[2])) {
                        round++;
                        isCurrentRoundEnded = true;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                printAttempts(players[i]);
            }
            for (int i = 0; i < 3; i++) {
                players[i].reset();
            }
            System.out.printf("%s", round != 3 ? "\nКонец раунда. Начало следующего\n" : "\n");
            isCurrentRoundEnded = false;
        }
        System.out.println("\nКонец игры.");
        findWinner();
    }

    private boolean isGameOver() {
        return round == 3;
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
                    player == this.players[2] ? """
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
                    %d \s""".formatted(number));
        }
        System.out.println();
    }

    private boolean isGeneralLoss(Player[] player) {
        boolean result =
                player[0].getVictory() == player[1].getVictory() &&
                        player[1].getVictory() == player[2].getVictory();
        return result && player[0].getVictory() == 0;
    }

    private boolean hasDrawGame(Player[] player) {
        boolean result =
                player[0].getVictory() == player[1].getVictory() &&
                        player[1].getVictory() == player[2].getVictory();
        return result && player[0].getVictory() > 0;
    }

    private void findWinner() {
        if (isGeneralLoss(players)) {
            System.out.println("Все проиграли. Ни один из игроков за 3 раунда не угадал число");
        } else if (hasDrawGame(players)) {
            System.out.println("Ничья");
        } else {
            Player winner = players[0];
            for (Player p : players) {
                if (p.getVictory() > winner.getVictory()) {
                    winner = p;
                }
            }
            System.out.println("Результатом игры стала победа игрока под именем: " + winner.getName());
        }
    }
}

