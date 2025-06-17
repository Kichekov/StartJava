package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        runTransactionReverser();
        runHackerSimulation();
        runFactorialCalculator();
        runFilterByIndexTask();
        runTrianglePrintTask();
        runUniqueArraySorter();
        runTypewriterEffect();
    }

    public static void runTransactionReverser() {
        int[] original = {6, 8, 9, 1};
        int[] reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);

        original = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);

        original = new int[]{5};
        reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);

        original = new int[]{};
        reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);

        original = null;
        reversed = Arrays.reverse(original);
        Console.printTransactions(original, reversed);
    }

    public static void runHackerSimulation() throws InterruptedException {
        boolean isHack = Arrays.hack();
        Console.printHackResult(isHack);
    }

    private static void runFactorialCalculator() {
        int[] numbers = {};
        long[] factorials = Arrays.calculateFactorial(numbers);
        Console.printFactorialsExpr(numbers, factorials);

        numbers = null;
        factorials = Arrays.calculateFactorial(numbers);
        Console.printFactorialsExpr(numbers, factorials);

        numbers = new int[]{8, 0, 9};
        factorials = Arrays.calculateFactorial(numbers);
        Console.printFactorialsExpr(numbers, factorials);

        numbers = new int[]{-3, 1, 7, 13};
        factorials = Arrays.calculateFactorial(numbers);
        Console.printFactorialsExpr(numbers, factorials);

        numbers = new int[]{-22, -0};
        factorials = Arrays.calculateFactorial(numbers);
        Console.printFactorialsExpr(numbers, factorials);
    }

    private static void runFilterByIndexTask() {
        float[] original = Arrays.generateSortedUniqueRandomArray();
        int index = -1;
        float[] filtered = Arrays.filterByIndexValue(original, index);
        Console.printFilterByIndex(original, filtered, index);

        original = Arrays.generateSortedUniqueRandomArray();
        index = 15;
        filtered = Arrays.filterByIndexValue(original, index);
        Console.printFilterByIndex(original, filtered, index);

        original = Arrays.generateSortedUniqueRandomArray();
        index = 0;
        filtered = Arrays.filterByIndexValue(original, index);
        Console.printFilterByIndex(original, filtered, index);

        original = Arrays.generateSortedUniqueRandomArray();
        index = 14;
        filtered = Arrays.filterByIndexValue(original, index);
        Console.printFilterByIndex(original, filtered, index);
    }

    private static void runTrianglePrintTask() {
        StringBuilder triangle = Arrays.buildCharRangeTriangle('0', '9', true);
        Console.printTriangle('0', '9', triangle);

        triangle = Arrays.buildCharRangeTriangle('/', '!', false);
        Console.printTriangle('/', '!', triangle);

        triangle = Arrays.buildCharRangeTriangle('A', 'J', false);
        Console.printTriangle('A', 'J', triangle);
    }

    public static void runUniqueArraySorter() {
        int[] numbers = Arrays.generateSortedUniqueRandomArray(-30, -10, 23);
        Console.printArray(numbers, -30, -10, 23);

        numbers = Arrays.generateSortedUniqueRandomArray(10, 50, 10);
        Console.printArray(numbers, 10, 50, 10);

        numbers = Arrays.generateSortedUniqueRandomArray(-34, -34, 0);
        Console.printArray(numbers, -34, 34, 0);

        numbers = Arrays.generateSortedUniqueRandomArray(-1, 2, -3);
        Console.printArray(numbers, -1, 2, -3);

        numbers = Arrays.generateSortedUniqueRandomArray(5, -8, 2);
        Console.printArray(numbers, 5, -8, 2);
    }

    public static void runTypewriterEffect() throws InterruptedException {
        String modifiedString = Arrays.toUppercaseRange("Чтобы написать чистый код," +
                " мы сначала пишем грязный код, затем рефакторим его.\n- Robert Martin");
        Console.type(modifiedString);

        modifiedString = Arrays.toUppercaseRange("Java - это C++, из которого убрали все пистолеты," +
                " ножи и дубинки.\n- James Gosling");
        Console.type(modifiedString);

        modifiedString = Arrays.toUppercaseRange(null);
        Console.type(modifiedString);

        modifiedString = Arrays.toUppercaseRange("");
        Console.type(modifiedString);
    }
}
