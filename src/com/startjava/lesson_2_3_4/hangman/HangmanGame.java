package com.startjava.lesson_2_3_4.array.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String TROPHY_EMOJI = "\uD83C\uDFC6";

    private String guessedWord;
    private int wrongLettersIndex;
    public char[] maskedWord;
    private char[] wrongLetters;
    public int wrongAttempts;
    private int totalAttempts;
    public boolean isGameOver;
    public int maxAttempts = gallows.length;

    private static String[] gallows = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };

    public HangmanGame() {
        Random random = new Random();
        String[] secretWords = {
                "компьютер",
                "программа",
                "машина",
                "школа",
                "самолет",
                "поезд",
                "город"
        };
        guessedWord = secretWords[random.nextInt(secretWords.length)];
        wrongLetters = new char[guessedWord.length() + maxAttempts - 1];
        maskedWord = new char[guessedWord.length()];
        Arrays.fill(maskedWord, '*');
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (maxAttempts > wrongAttempts && !isGameOver) {
            System.out.print("Загаданное слово: ");
            printMaskedWord();

            if (wrongAttempts > 0) {
                printIncorrectLetters();
                System.out.println();
            }
            System.out.print("Введите букву: ");
            char letter = scanner.next().charAt(0);
            if (Character.isDigit(letter)) {
                System.out.println(RED + "Ошибка: Необходимо ввести именно букву, а не цифру. " +
                        "Попробуйте снова." + RESET);
                continue;
            }
            if (!isValidInput(letter)) {
                System.out.println(RED + "Ошибка: Буква не является кириллической. " +
                        "Попробуйте снова." + RESET);
                continue;
            }
            if (letterIsAlreadyUsed(letter)) {
                System.out.println(RED + "Ошибка: Буква уже вводилась ранее. " +
                        "Попробуйте снова." + RESET);
                continue;
            }
            tryGuessLetter(letter);
        }
    }

    public boolean isValidInput(char letter) {
        return String.valueOf(letter).matches("[а-яА-Я]");
    }

    public void tryGuessLetter(char letter) {
        char[] word = guessedWord.toCharArray();
        boolean correctGuess = checkGuess(word, letter);

        if (correctGuess) {
            if (wrongAttempts > 0) {
                wrongAttempts--;
            }
            System.out.println(GREEN + "Вы ввели верную букву." + RESET + "\n");
            printGallows();
            isGameOver = checkVictoryCondition();
            countingAttemptsNumber();
        } else {
            System.out.println(RED + "Вы ввели НЕ верную букву" + RESET + "\n");
            wrongAttempts++;
            wrongLetters[wrongLettersIndex++] = letter;
            printGallows();
            System.out.println();
            isGameOver = checkLoseCondition();
            countingAttemptsNumber();
        }
        totalAttempts++;
    }

    public void printIncorrectLetters() {
        if (wrongLettersIndex == 0) return;
        System.out.print("Неверные буквы: ");
        for (int i = 0; i < wrongLettersIndex; i++) {
            System.out.print(wrongLetters[i] + " ");
        }
        System.out.println();
    }

    private boolean letterIsAlreadyUsed(char letter) {
        for (char guessedLetter : maskedWord) {
            if (Character.toLowerCase(guessedLetter) == Character.toLowerCase(letter)) {
                return true;
            }
        }
        for (int i = 0; i < wrongLettersIndex; i++) {
            if (Character.toLowerCase(wrongLetters[i]) == Character.toLowerCase(letter)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkGuess(char[] word, char letter) {
        boolean result = false;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                maskedWord[i] = Character.toUpperCase(letter);
                result = true;
            }
        }
        return result;
    }

    private boolean checkVictoryCondition() {
        for (char c : maskedWord) {
            if (c == '*') {
                return false;
            }
        }
        System.out.println(GREEN + "Это победа " + RESET + TROPHY_EMOJI + "\nЗагаданное слово: ");
        printMaskedWord();
        return true;
    }

    private void printMaskedWord() {
        for (char item : maskedWord) {
            System.out.print(item);
        }
        System.out.println();
    }

    private void printGallows() {
        for (int i = 0; i < wrongAttempts; i++) {
            System.out.println(gallows[i]);
        }
    }

    private boolean checkLoseCondition() {
        if (wrongAttempts >= maxAttempts) {
            System.out.println(RED + "Это проигрыш." + RESET + "\nЗагаданное слово: " +
                    guessedWord + "\n");
            return true;
        }
        return false;
    }

    private void countingAttemptsNumber() {
        if (!isGameOver) {
            System.out.printf("У Вас%s: %d попыток\n",
                    wrongAttempts > 0 ? " осталось" : "", maxAttempts - wrongAttempts);
        }
    }
}

