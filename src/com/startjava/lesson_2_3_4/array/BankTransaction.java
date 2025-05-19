package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class BankTransaction {
    public static void main(String[] args) {
        int[] original1 = {6, 8, 9, 1};
        int[] reversed1 = reverseTransactions(original1);
        printTransactions(original1, reversed1);

        int[] original2 = {13, 8, 5, 3, 2, 1, 1};
        int[] reversed2 = reverseTransactions(original2);
        printTransactions(original2, reversed2);

        int[] original3 = {5};
        int[] reversed3 = reverseTransactions(original3);
        printTransactions(original3, reversed3);

        int[] original4 = {};
        int[] reversed4 = reverseTransactions(original4);
        printTransactions(original4, reversed4);

        int[] original5 = null;
        int[] reversed5 = reverseTransactions(original5);
        printTransactions(original5, reversed5);
    }

    private static void validateTransactions(int[] original) {
        if (original == null) {
            throw new IllegalArgumentException("Исходные транзакции: Ошибка ввода данных\n");
        }
        if (original.length == 0) {
            throw new IllegalArgumentException("Исходные транзакции: Очередь транзакций пуста, " +
                    "выполните хотя бы одну транзакцию\n");
        }
    }

    private static int[] reverseTransactions(int[] original) {
        if (original == null) {
            return null;
        }
        int[] reversed = new int[original.length];
        int length = original.length - 1;
        for (int transaction : original) {
            reversed[length] = transaction;
            length--;
        }
        return reversed;
    }

    private static void printTransactions(int[] original, int[] reversed) {
        try {
            validateTransactions(original);
            System.out.println("Исходные транзакции: " + Arrays.toString(original) + "\n" +
                    " В обратном порядке: " + Arrays.toString(reversed) + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
