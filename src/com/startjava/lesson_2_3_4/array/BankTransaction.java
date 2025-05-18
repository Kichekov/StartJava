package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class BankTransaction {
    public static void main(String[] args) {
        int[] originTransactionsId01 = {6, 8, 9, 1};
        handleTransactions(originTransactionsId01);

        int[] originTransactionsId02 = {13, 8, 5, 3, 2, 1, 1};
        handleTransactions(originTransactionsId02);

        int[] originTransactionsId03 = {5};
        handleTransactions(originTransactionsId03);

        int[] originTransactionsId04 = {};
        handleTransactions(originTransactionsId04);

        int[] originTransactionsId05 = null;
        handleTransactions(originTransactionsId05);
    }

    private static void handleTransactions(int[] originTransactions) {
        try {
            validateTransactions(originTransactions);
            int[] reverseTransactions = reverseTransactions(originTransactions);
            printTransactions(originTransactions, reverseTransactions);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validateTransactions(int[] originTransactions) {
        if (originTransactions == null) {
            throw new IllegalArgumentException("Исходные транзакции: Ошибка ввода данных");
        }
        if (originTransactions.length == 0) {
            throw new IllegalArgumentException("Исходные транзакции: Очередь транзакций пуста, " +
                    "выполните хотя бы одну транзакцию");
        }
    }

    private static int[] reverseTransactions(int[] originTransactions) {
        int[] reverseTransactions = new int[originTransactions.length];
        int length = originTransactions.length - 1;
        for (int i = 0; i < originTransactions.length; i++) {
            reverseTransactions[length] = originTransactions[i];
            length--;
        }
        return reverseTransactions;
    }

    private static void printTransactions(int[] originTransactions, int[] reverseTransactions) {
        System.out.println("Исходные транзакции: " + Arrays.toString(originTransactions) + "\n" +
                " В обратном порядке: " + Arrays.toString(reverseTransactions) + "\n");
    }
}
