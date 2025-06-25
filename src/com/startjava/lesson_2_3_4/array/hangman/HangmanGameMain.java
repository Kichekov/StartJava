package com.startjava.lesson_2_3_4.array.hangman;

import java.util.Arrays;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userChoice = "";
        do {
            if (userChoice.equals("yes")) {
                System.out.println();
            }
            System.out.println("""
                    Начинаем игру Виселица. Мы Вас повесим, если Вы не отгадаете слово.
                    
                    Правила игры:
                    - Игрок угадывает случайное слово, вводя по одной букве.
                    - Угаданная буква отображается столько раз, сколько встречается в слове.
                    - Если слово не содержит названной буквы, отображается часть виселицы;
                      если содержит — одна часть виселицы убирается.
                    - Для победы необходимо угадать слово до отображения всей виселицы.
                    
                    У Вас 6 попыток.
                    """);

            HangmanGame game = new HangmanGame();
            game.chooseSecretWord();

            while (game.MAX_ATTEMPTS > game.wrongAttempts && !game.isGameOver) {
                System.out.println("Загаданное слово: " + Arrays.toString(game.maskedWord));
                if (game.wrongAttempts > 0) {
                    game.printIncorrectLetters();
                    System.out.println();
                }
                System.out.println("Назовите одну из букв угадываемого слова: ");
                char letter = scanner.next().charAt(0);
                if (!game.isValidInput(letter)) {
                    System.out.println(game.RED + "Ошибка: Буква уже вводилась ранее или не " +
                            "является кириллической.Попробуйте снова." + game.RESET);
                    continue;
                }
                game.tryGuessLetter(letter);
            }

            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                userChoice = scanner.next().toLowerCase();

                if (!userChoice.equals("yes") && !userChoice.equals("no")) {
                    System.out.println("Ответ некорректен. Введите корректный ответ");
                }
            } while (!userChoice.equals("yes") && !userChoice.equals("no"));
        } while (userChoice.equals("yes"));
    }
}
