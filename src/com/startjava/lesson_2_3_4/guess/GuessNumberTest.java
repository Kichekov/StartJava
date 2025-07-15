package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Добро пожаловать в игру УГАДАЙ ЧИСЛО!!!
                -------------------------------------------
                Правила игры: Компьютер "загадывает" целое число в отрезке [1-100].
                              Вы должны его отгадать!
                
                После каждой неудачной попытки Вы получите подсказку.
                Игра продолжится до тех пор, пока Вы не отгадаете загаданное
                компьютером число.
                """);

        System.out.print("Введите имя первого игрока: ");
        Player playerOne = new Player(scanner.next());

        System.out.print("Введите имя второго игрока: ");
        Player playerTwo = new Player(scanner.next());

        GuessNumber game = new GuessNumber(playerOne, playerTwo);
        String replayGame;
        do {
            game.start(scanner);
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                replayGame = scanner.next();
            } while (!replayGame.equals("yes") && !replayGame.equals("no"));
            System.out.println();
        } while (replayGame.equals("yes"));
    }
}
