package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionProcessor {
    public static void main(String[] args) {
        int[] original1 = {6, 8, 9, 1};
        int[] reversed1 = reverse(original1);
        printTransactions(original1, reversed1);

        int[] original2 = {13, 8, 5, 3, 2, 1, 1};
        int[] reversed2 = reverse(original2);
        printTransactions(original2, reversed2);

        int[] original3 = {5};
        int[] reversed3 = reverse(original3);
        printTransactions(original3, reversed3);

        int[] original4 = {};
        int[] reversed4 = reverse(original4);
        printTransactions(original4, reversed4);

        int[] original5 = null;
        int[] reversed5 = reverse(original5);
        printTransactions(original5, reversed5);
    }

    private static int[] reverse(int[] transactions) {
        if (transactions == null) {
            return null;
        }
        int[] reversed = new int[transactions.length];
        int length = transactions.length - 1;
        for (int transaction : transactions) {
            reversed[length--] = transaction;
        }
        return reversed;
    }

    private static void printTransactions(int[] original, int[] reversed) {
        if (original == null) {
            System.out.println("Исходные транзакции: Ошибка ввода данных\n");
            return;
        }

        if (original.length == 0) {
            System.out.println("Исходные транзакции: Очередь транзакций пуста, " +
                    "выполните хотя бы одну транзакцию\n");
            return;
        }

        System.out.println("Исходные транзакции: " + Arrays.toString(original) + "\n" +
                " В обратном порядке: " + Arrays.toString(reversed) + "\n");
    }
}
