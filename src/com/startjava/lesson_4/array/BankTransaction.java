package com.startjava.lesson_4.array;

import java.util.Arrays;

public class BankTransaction {
    private int[] originTransactionQueue;

    public int[] getOriginTransactionQueue() {
        return originTransactionQueue;
    }

    public void setOriginTransactionQueue(int[] originTransactionQueue) {
        if (originTransactionQueue == null) {
            throw new IllegalArgumentException("Исходные транзакции: Ошибка ввода данных");
        }
        if (originTransactionQueue.length == 0) {
            throw new IllegalArgumentException("Исходные транзакции: Очередь транзакций пуста, " +
                    "выполните хотя бы одну транзакцию");
        }
        this.originTransactionQueue = originTransactionQueue;
    }

    private int[] invertTransactionQueue(int[] originTransactionQueue) {
        int[] reverseTransactionQueue = new int[originTransactionQueue.length];
        for (int i = originTransactionQueue.length - 1; i >= 0; i--) {
            reverseTransactionQueue[reverseTransactionQueue.length - 1 - i] = originTransactionQueue[i];
        }
        return reverseTransactionQueue;
    }

    public void printTransactionQueue(int[] reverseTransactionQueue) {
        System.out.println("Исходные транзакции: " + Arrays.toString(originTransactionQueue) + "\n" +
                " В обратном порядке: " + Arrays.toString(reverseTransactionQueue) + "\n");
    }

    public static void main(String[] args) {
        BankTransaction clientTransactions = new BankTransaction();

        int[][] transactions = {
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1},
                {5},
                {},
                null
        };

        for (int[] originTransactionQueue : transactions) {
            try {
                clientTransactions.setOriginTransactionQueue(originTransactionQueue);
                int[] reverseTransactionQueue = clientTransactions.invertTransactionQueue(
                        clientTransactions.getOriginTransactionQueue());
                clientTransactions.printTransactionQueue(reverseTransactionQueue);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
