package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    public static final int MAX_ATTEMPTS = 10;

    private String name;
    private int[] numbers = new int[MAX_ATTEMPTS];
    private int trial;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Число должно входить в отрезок [1, 100].");
        }
        numbers[trial] = number;
    }

    public int getNumber() {
        return numbers[trial - 1];
    }

    public int getTrial() {
        return trial;
    }

    public void setTrial() {
        this.trial++;
    }

    public int[] getEnteredNumbers() {
        return Arrays.copyOf(numbers, trial);
    }

    public void reset() {
        Arrays.fill(numbers, 0);
        trial = 0;
    }
}
