package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;
    public static final int MAX_ATTEMPTS = 10;

    private final String name;
    private final int[] numbers = new int[MAX_ATTEMPTS];
    private int attempt;
    public int victory;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getVictory() {
        return victory;
    }

    public void incVictory() {
        victory++;
    }

    public void addNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("""
                    Число должно входить в отрезок [%d, %d].
                    Попробуйте еще раз.""".formatted(MIN_NUMBER, MAX_NUMBER));
        }
        numbers[attempt] = number;
    }

    public int getNumber() {
        return numbers[attempt - 1];
    }

    public int getAttempt() {
        return attempt;
    }

    public void incAttempt() {
        this.attempt++;
    }

    public int[] getEnteredNumbers() {
        return Arrays.copyOf(numbers, attempt);
    }

    public void reset() {
        Arrays.fill(numbers, 0, attempt, 0);
        attempt = 0;
    }
}
