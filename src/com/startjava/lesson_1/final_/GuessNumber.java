package com.startjava.lesson_1.final_;

import java.util.Random;
import java.util.Scanner;

class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Добро пожаловать в игру УГАДАЙ ЧИСЛО!!!
                -------------------------------------------
                Правила игры: Компьютер "загадывает" целое число в отрезке [1-100].
                              Вы должны его отгадать!
                      
                После каждой неудачной попытки Вы получите подсказку.
                Игра продолжится до тех пор, пока Вы не отгадаете загаданное
                компьютером число!
                        """);
        int randomNumber = random.nextInt(100) + 1;
        int attemptsCounter = 1;
        int playerInput = 1;
        do {
            System.out.print("Введите число: ");
            if (scanner.hasNextInt()) {
                playerInput = scanner.nextInt();
                if (playerInput < 1 || playerInput > 100) {
                    System.out.println("Ошибка: введенное Вами число не принадлежит" + 
                            " заданному отрезку, повторите попытку.");
                    continue;
                } 
            } else {
                System.out.println("Ошибка: введенные Вами данные не являются натуральным числом.");
                return;
            }
            if (randomNumber != playerInput) {
                String message = playerInput > randomNumber ? 
                        "больше" : "меньше";
                System.out.printf("Подсказка: %s %s того, что загадал компьютер\n", 
                        playerInput, message);
                attemptsCounter++;
            }
        } while (randomNumber != playerInput);
        System.out.printf("Вы победили! Победной стала попытка № %s\n", attemptsCounter);
    }
}
