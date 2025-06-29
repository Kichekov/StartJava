package com.startjava.lesson_2_3_4.array.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public final int MAX_ATTEMPTS = 6;
    public final String RED = "\u001B[31m";
    public final String GREEN = "\u001B[32m";
    public final String RESET = "\u001B[0m";

    private final String[] words = {"компьютер", "программа", "машина", "школа", "самолет", "поезд", "город"};
    private String guessedWord;
    private int wrongLettersIndex;
    public char[] maskedWord;
    private char[] wrongLetters;
    public int wrongAttempts;
    private int totalAttempts;
    public boolean isGameOver;

    private String[] gallowsAllElements = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };

    public HangmanGame() {
        wrongAttempts = 0;
        wrongLetters = new char[20];
        totalAttempts = 0;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        chooseSecretWord();
        while (MAX_ATTEMPTS > wrongAttempts && !isGameOver) {
            System.out.println("Загаданное слово: " + Arrays.toString(maskedWord));
            if (wrongAttempts > 0) {
                printIncorrectLetters();
                System.out.println();
            }
            System.out.println("Назовите одну из букв угадываемого слова: ");
            char letter = scanner.next().charAt(0);
            if (!isValidInput(letter)) {
                System.out.println(RED + "Ошибка: Буква уже вводилась ранее или не " +
                        "является кириллической.Попробуйте снова." + RESET);
                continue;
            }
            tryGuessLetter(letter);
        }
    }

    public String chooseSecretWord() {
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];
        guessedWord = secretWord;
        initializeCurrentState();
        return secretWord;
    }

    public boolean isValidInput(char letter) {
        return String.valueOf(letter).matches("[а-яА-Я]") && !isAlreadyUsed(letter);
    }

    public void tryGuessLetter(char letter) {
        char[] word = guessedWord.toCharArray();
        boolean correctGuess = checkGuess(word, letter);

        if (correctGuess) {
            if (wrongAttempts > 0) {
                wrongAttempts--;
            }
            System.out.println(GREEN + "Вы ввели верную букву." + RESET + "\n");

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
        System.out.print("Перечень неверно введенных букв: ");
        for (int i = 0; i < wrongLettersIndex; i++) {
            System.out.print(wrongLetters[i] + " ");
        }
        System.out.println();
    }

    private void initializeCurrentState() {
        maskedWord = new char[guessedWord.length()];
        Arrays.fill(maskedWord, '*');
    }

    private boolean isAlreadyUsed(char letter) {
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
        System.out.println(GREEN + "Это победа\nЗагаданное слово: " +
                Arrays.toString(maskedWord) + RESET + "\n");
        return true;
    }

    private void printGallows() {
        for (int i = 0; i < wrongAttempts; i++) {
            System.out.println(gallowsAllElements[i]);
        }
    }

    private boolean checkLoseCondition() {
        if (wrongAttempts >= MAX_ATTEMPTS) {
            System.out.println(RED + "Это проигрыш.\nЗагаданное слово: " +
                    guessedWord + RESET + "\n");
            return true;
        }
        return false;
    }

    private void countingAttemptsNumber() {
        if (!isGameOver) {
            System.out.printf("У Вас%s: %d попыток\n",
                    wrongAttempts > 0 ? " осталось" : "", MAX_ATTEMPTS - wrongAttempts);
        }
    }
}

