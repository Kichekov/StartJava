package com.startjava.lesson_2_3_4.array;

class Console {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    private Console() {
    }

    public static void printFilterByIndex(float[] original, float[] filtered, int index) {
        if (index < 0 || index >= original.length) {
            System.out.printf("""
                    Ошибка: индекс %d вне допустимого диапазона. \
                    Укажите значение от 0 до %d включительно.

                    """, index, original.length - 1);
            return;
        }

        printArray("Исходный массив:", original);

        System.out.printf("\n\nЗначение из ячейки по переданному индексу: = %.3f\n", original[index]);

        printArray("\nОткорректированный массив:", filtered);

        int zeroedCount = 0;
        for (int i = 0; i < filtered.length; i++) {
            if (original[i] > original[index]) {
                zeroedCount++;
            }
        }

        System.out.println("\n\nКоличество обнуленных ячеек: " + zeroedCount + "\n");
    }

    public static void printArray(String msg, float[] array) {
        System.out.println(msg);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f %s", array[i], i == 7 ? "\n" : " ");
        }
    }

    public static void printTriangle(char leftBorder, char rightBorder, StringBuilder triangle) {
        if (triangle == null) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)\n\n",
                    (int) leftBorder, (int) rightBorder);
            return;
        }
        System.out.println(triangle);
    }

    public static void printFactorialsExpr(int[] numbers, long[] factorials) {
        if (numbers == null) {
            System.out.println("Ошибка: массив не инициализирован\n");
            return;
        }
        if (numbers.length == 0) {
            System.out.println("Массив пуст. Нет данных для вывода факториалов.\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.println("Ошибка: факториал " + numbers[i] + "! не определен");
                continue;
            }
            if (numbers[i] == 0 || numbers[i] == 1) {
                System.out.println(numbers[i] + "! = " + factorials[i]);
            } else {
                StringBuilder expression = new StringBuilder(numbers[i] + "! = ");
                for (int j = 1; j <= numbers[i]; j++) {
                    expression.append(String.format("%d%s", j, j != numbers[i] ? " * " : ""));
                }
                expression.append(" = ").append(factorials[i]);
                System.out.println(expression);
            }
        }
        System.out.println();
    }

    public static void printHackResult(int randomNumber) {
        System.out.printf("\rHacking: %s%s \n\n", randomNumber > 70 ?
                GREEN + "Access Granted!" : RED + "Access Denied!", RESET);
    }

    public static void printTransactions(int[] original, int[] reversed) {
        if (original == null) {
            System.out.println("Исходные транзакции: Ошибка ввода данных\n");
            return;
        }

        if (original.length == 0) {
            System.out.println("Исходные транзакции: Очередь транзакций пуста, " +
                    "выполните хотя бы одну транзакцию\n");
            return;
        }

        System.out.println("Исходные транзакции: " + java.util.Arrays.toString(original) + "\n" +
                " В обратном порядке: " + java.util.Arrays.toString(reversed) + "\n");
    }

    public static void type(String modifiedText) throws InterruptedException {
        if (modifiedText == null) {
            System.out.println(modifiedText + "\n");
            return;
        }

        if (modifiedText.isEmpty()) {
            System.out.println("пустая строка\n");
            return;
        }

        char[] chars = modifiedText.toCharArray();
        for (char item : chars) {
            System.out.print(item);
            Thread.sleep(200);
        }
        System.out.println("\n");
    }

    public static void printArray(int[] numbers, int startRange, int endRange, int itemsPerLine) {
        if (startRange > endRange) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)\n\n", startRange, endRange);
            return;
        }

        if (itemsPerLine < 1) {
            System.out.printf("Ошибка: количество чисел в строке не должно быть < 1 (%d)\n\n", itemsPerLine);
            return;
        }

        int size = (int) ((endRange - startRange + 1) * 0.75);
        if (size <= 0) {
            System.out.printf("Ошибка: длина массива должна быть > 0 (%d)\n\n", size);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d%s", numbers[i], (i + 1) % itemsPerLine == 0 ? "\n" : " ");
        }

        if (numbers.length % itemsPerLine != 0) {
            System.out.println();
        }

        System.out.println();
    }
}
