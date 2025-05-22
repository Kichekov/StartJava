package com.startjava.lesson_2_3_4.array;

public class HackerSimulation {
    private static final char[] SPINNER = {'-', '\\', '|', '/'};
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    private static int randomNumber;

    public static void main(String[] args) throws InterruptedException {
        hack();
        printHackResult();
    }

    private static void hack() throws InterruptedException {
        randomNumber = (int) (Math.random() * 100);
        for (int i = 0; i < 13; i++) {
            char item = SPINNER[i % 4];
            System.out.print("\rHacking: " + item);
            Thread.sleep(400);
        }
    }

    private static void printHackResult() {
        System.out.printf("\rHacking: %s ", randomNumber > 70 ?
                GREEN + "Access Granted!" : RED + "Access Denied!");
    }
}

