package com.startjava.lesson_2_3_4.array;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Arrays {
    public static final int ARRAY_SIZE = 15;

    private Arrays() {
    }

    public static StringBuilder buildCharRangeTriangle(char leftBorder, char rightBorder,
                                                       boolean isAscending) {
        if (leftBorder > rightBorder) {
            return null;
        }

        char[] chars = new char[rightBorder - leftBorder + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (isAscending ? leftBorder++ : rightBorder--);
        }

        int rows = chars.length;
        int triangleWidth = (rows * 2) - 1;

        StringBuilder triangle = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            int repeatCount = i * 2 + 1;
            int spacesCount = (triangleWidth - repeatCount) / 2;
            triangle.append(" ".repeat(spacesCount));
            triangle.append(Character.toString(chars[i]).repeat(repeatCount)).append("\n");
        }
        return triangle;
    }

    public static long[] calculateFactorial(int... numbers) {
        if (numbers == null) {
            return null;
        }

        long[] factorials = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                continue;
            }
            long factorialValue = 1;
            for (int j = 1; j <= numbers[i]; j++) {
                factorialValue *= j;
            }
            factorials[i] = factorialValue;
        }
        return factorials;
    }

    public static float[] filterByIndexValue(float[] original, int index) {
        if (index < 0 || index > original.length - 1) {
            return original;
        }

        float[] filtered = original.clone();
        for (int i = 0; i < original.length; i++) {
            if (filtered[i] > original[index]) {
                filtered[i] = 0.0F;
            }
        }
        return filtered;
    }

    public static float[] generateSortedUniqueRandomArray() {
        float[] array = new float[ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) Math.random();
        }
        return array;
    }

    public static boolean hack() throws InterruptedException {
        char[] spinner = {'-', '\\', '|', '/'};
        int randomNumber = (int) (Math.random() * 100);
        for (int i = 0; i < 13; i++) {
            char item = spinner[i % 4];
            System.out.print("\rHacking: " + item);
            Thread.sleep(400);
        }
        return randomNumber > 70;
    }

    public static int[] reverse(int[] numbers) {
        if (numbers == null) {
            return null;
        }

        if (numbers.length == 0) {
            return numbers;
        }

        int[] reversed = new int[numbers.length];
        int length = numbers.length;
        for (int number : numbers) {
            reversed[--length] = number;
        }
        return reversed;
    }

    public static String toUppercaseRange(String input) {
        if (input == null) {
            return null;
        }

        if (input.isEmpty()) {
            return "";
        }

        Pattern wordPattern = Pattern.compile("[a-zA-Zа-яА-Я+]+");
        Matcher matcher = wordPattern.matcher(input);

        String[] words = new String[input.length()];
        int[] wordStart = new int[input.length()];
        int[] wordEnd = new int[input.length()];
        int count = 0;

        while (matcher.find()) {
            words[count] = matcher.group();
            wordStart[count] = matcher.start();
            wordEnd[count] = matcher.end();
            count++;
        }

        int modificationStart = Math.min(findShortestWord(words, count), findLongestWord(words, count));
        int modificationEnd = Math.max(findShortestWord(words, count), findLongestWord(words, count));

        StringBuilder sb = new StringBuilder();
        int currentPos = 0;

        for (int i = 0; i < count; i++) {
            sb.append(input, currentPos, wordStart[i]);
            if (i >= modificationStart && i <= modificationEnd) {
                sb.append(words[i].toUpperCase());
            } else {
                sb.append(words[i]);
            }
            currentPos = wordEnd[i];
        }
        sb.append(input.substring(currentPos));

        return sb.toString();
    }

    public static int findLongestWord(String[] words, int count) {
        int longestWordIndex = 0;
        for (int i = 0; i < count; i++) {
            if (words[i].length() > words[longestWordIndex].length()) {
                longestWordIndex = i;
            }
        }
        return longestWordIndex;
    }

    public static int findShortestWord(String[] words, int count) {
        int shortestWordIndex = 0;
        for (int i = 0; i < count; i++) {
            if (words[i].length() <= words[shortestWordIndex].length()) {
                shortestWordIndex = i;
            }
        }
        return shortestWordIndex;
    }

    public static int[] generateSortedUniqueRandomArray(int startRange, int endRange, int itemsPerLine) {
        int range = endRange - startRange + 1;

        if (startRange > endRange || itemsPerLine < 1 || (int) (range * 0.75) <= 0) {
            return null;
        }

        int size = (int) (range * 0.75);
        Random random = new Random();
        int[] uniqueNumbers = new int[size];
        int uniqueCount = 0;
        while (uniqueCount < size) {
            int currNumber = startRange + random.nextInt(range);
            boolean isUnique = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueNumbers[j] == currNumber) {
                    isUnique = true;
                    break;
                }
            }
            if (!isUnique) {
                uniqueNumbers[uniqueCount++] = currNumber;
            }
        }
        java.util.Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }
}
