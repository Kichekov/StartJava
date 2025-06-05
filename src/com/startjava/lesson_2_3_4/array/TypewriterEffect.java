package com.startjava.lesson_2_3_4.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String modifiedString = toUppercaseRange("Чтобы написать чистый код," +
                " мы сначала пишем грязный код, затем рефакторим его.\n- Robert Martin");
        type(modifiedString);

        modifiedString = toUppercaseRange("Java - это C++, из которого убрали все пистолеты," +
                " ножи и дубинки.\n- James Gosling");
        type(modifiedString);

        modifiedString = toUppercaseRange(null);
        type(modifiedString);

        modifiedString = toUppercaseRange("");
        type(modifiedString);
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

    private static int findLongestWord(String[] words, int count) {
        int longestWordIndex = 0;
        for (int i = 0; i < count; i++) {
            if (words[i].length() > words[longestWordIndex].length()) {
                longestWordIndex = i;
            }
        }
        return longestWordIndex;
    }

    private static int findShortestWord(String[] words, int count) {
        int shortestWordIndex = 0;
        for (int i = 0; i < count; i++) {
            if (words[i].length() <= words[shortestWordIndex].length()) {
                shortestWordIndex = i;
            }
        }
        return shortestWordIndex;
    }

    private static void type(String modifiedText) throws InterruptedException {
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
}
