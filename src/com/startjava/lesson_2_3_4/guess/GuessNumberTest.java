package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

class GuessNumberTest {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Добро пожаловать в игру УГАДАЙ ЧИСЛО!!!
                -------------------------------------------
                Правила игры: Компьютер "загадывает" целое число в отрезке [1-100].
                              Вы должны его отгадать!
                
                После каждой неудачной попытки Вы получите подсказку.
                Игра продолжится до тех пор, пока Вы не отгадаете загаданное
                компьютером число. Победитель будет определен по итогам трех раундов.
                """);

        Player playerOne = createPlayer(scanner);
        Player playerTwo = createPlayer(scanner);
        Player playerThree = createPlayer(scanner);

        animateDraw();

        GuessNumber game = new GuessNumber(playerOne, playerTwo, playerThree);
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

    private static Player createPlayer(Scanner scanner) {
        System.out.print("Введите имя игрока: ");
        return new Player(scanner.next());
    }

    public static void animateDraw() throws InterruptedException {
        char[] spinner = {'-', '\\', '|', '/'};
        for (int i = 0; i < 13; i++) {
            char item = spinner[i % 4];
            System.out.print("\rБросаем жребий: " + item);
            Thread.sleep(400);
        }
    }
}
