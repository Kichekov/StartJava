package com.startjava.lesson_2_3_4.array;

public class HackerSimulation {
    private static final char[] SPINNER = {'-', '\\', '|', '/'};
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void main(String[] args) throws InterruptedException {
        hack();
        int randomNumber = assignRandomNumber();
        printHackResult(randomNumber);
    }

    private static void hack() throws InterruptedException {
        for (int i = 0, totalItem = 13; i < totalItem; i++) {
            int index = i % 4;
            char item = SPINNER[index];
            System.out.print("\rHacking: " + item);
            Thread.sleep(400);
        }
    }

    private static int assignRandomNumber() {
        return (int) (Math.random() * 100);
    }

    private static void printHackResult(int randomNumber) {
        System.out.printf("\rHacking: %s ", randomNumber > 70 ?
                GREEN + "Access Granted!" : RED + "Access Denied!");
    }
}

