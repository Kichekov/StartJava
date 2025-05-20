package com.startjava.lesson_2_3_4.array;

public class HackerSimulation {
    private static final char[] SPINNER_SYMBOLS = {'-', '\\', '|', '/'};
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws InterruptedException {
        animateHackingProcess(SPINNER_SYMBOLS);
        int randomNumber = assignRandomNumber();
        System.out.print(determineOperationResult(randomNumber));
    }

    private static void animateHackingProcess(char[] spinnerSymbols) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= spinnerSymbols.length - 1; j++) {
                System.out.print("\rHacking: " + spinnerSymbols[j]);
                Thread.sleep(400);
            }
        }
        System.out.print("\rHacking: -");
        Thread.sleep(400);
        System.out.print("\rHacking: ");
    }

    private static int assignRandomNumber() {
        return (int) (Math.random() * 100);
    }

    private static String determineOperationResult(int randomNumber) {
        return randomNumber > 70 ? ANSI_GREEN + "Access Granted!" : ANSI_RED + "Access Denied!";
    }
}

