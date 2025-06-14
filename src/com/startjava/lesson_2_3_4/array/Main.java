package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        runFilterByIndexTask();
        runTrianglePrintTask();
        runFactorialCalculator();
        runHackerSimulation();
        runTransactionReverser();
        runTypewriterEffect();
        runUniqueArraySorter();
    }

    private static void runFilterByIndexTask() {
        float[] original = Arrays.generateRandomArray();
        int index = -1;
        float[] filtered = Arrays.filterByIndexValue(original, index);
        Console.printResult(original, filtered, index);

        original = Arrays.generateRandomArray();
        index = 15;
        filtered = Arrays.filterByIndexValue(original, index);
        Console.printResult(original, filtered, index);

        original = Arrays.generateRandomArray();
        index = 0;
        filtered = Arrays.filterByIndexValue(original, index);
        Console.printResult(original, filtered, index);

        original = Arrays.generateRandomArray();
        index = 14;
        filtered = Arrays.filterByIndexValue(original, index);
        Console.printResult(original, filtered, index);
    }

    private static void runTrianglePrintTask() {
        StringBuilder triangle;

        triangle = Arrays.buildCharRangeTriangle('0', '9', true);
        Console.printTriangle('0', '9', triangle);

        triangle = Arrays.buildCharRangeTriangle('/', '!', false);
        Console.printTriangle('/','!', triangle);

        triangle = Arrays.buildCharRangeTriangle('A', 'J', false);
        Console.printTriangle('A','J', triangle);
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

    public static void runHackerSimulation() throws InterruptedException {
        Arrays.hack();
        Console.printHackResult();
    }

    public static void runTransactionReverser() {
        int[] original1 = {6, 8, 9, 1};
        int[] reversed1 = Arrays.reverse(original1);
        Console.printTransactions(original1, reversed1);

        int[] original2 = {13, 8, 5, 3, 2, 1, 1};
        int[] reversed2 = Arrays.reverse(original2);
        Console.printTransactions(original2, reversed2);

        int[] original3 = {5};
        int[] reversed3 = Arrays.reverse(original3);
        Console.printTransactions(original3, reversed3);

        int[] original4 = {};
        int[] reversed4 = Arrays.reverse(original4);
        Console.printTransactions(original4, reversed4);

        int[] original5 = null;
        int[] reversed5 = Arrays.reverse(original5);
        Console.printTransactions(original5, reversed5);
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

    public static void runUniqueArraySorter() {
        int[] numbers = Arrays.generateRandomArray(-30, -10, 23);
        Console.printArray(numbers, -30, -10, 23);

        numbers = Arrays.generateRandomArray(10, 50, 10);
        Console.printArray(numbers, 10, 50, 10);

        numbers = Arrays.generateRandomArray(-34, -34, 0);
        Console.printArray(numbers,-34, 34, 0);

        numbers = Arrays.generateRandomArray(-1, 2, -3);
        Console.printArray(numbers, -1, 2, -3);

        numbers = Arrays.generateRandomArray(5, -8, 2);
        Console.printArray(numbers,5,-8, 2);
    }
}
