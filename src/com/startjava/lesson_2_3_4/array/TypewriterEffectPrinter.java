package com.startjava.lesson_2_3_4.array;

public class TypewriterEffectPrinter {
    public static void main(String[] args) throws InterruptedException {
        String modifiedString = uppercaseRange("Чтобы написать чистый код," +
                " мы сначала пишем грязный код, затем рефакторим его.\n" + "- Robert Martin");
        typewriterPrint(modifiedString);

        modifiedString = uppercaseRange("Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling");
        typewriterPrint(modifiedString);

        modifiedString = uppercaseRange(null);
        typewriterPrint(modifiedString);

        modifiedString = uppercaseRange("");
        typewriterPrint(modifiedString);
    }

    public static String uppercaseRange(String input) {
        if (input == null) {
            return null;
        }

        if (input.isEmpty()) {
            return "пустая строка";
        }

        String longestWord = findLongestWord(input);
        String shortestWord = findShortestWord(input);

        int indexLongestWord = input.indexOf(longestWord);
        int indexShortestWord = input.indexOf(shortestWord);

        int modificationStart = Math.min(indexShortestWord, indexLongestWord);
        int modificationEnd = Math.max(indexLongestWord + longestWord.length(),
                indexShortestWord + shortestWord.length());

        StringBuilder sb = new StringBuilder();
        sb.append(input, 0, modificationStart);
        sb.append(input.substring(modificationStart, modificationEnd).toUpperCase());
        sb.append(input.substring(modificationEnd));

        return sb.toString();
    }

    private static String findLongestWord(String text) {
        String[] words = text.split("[^a-zA-Zа-яА-Я]+");
        String longestWord = words[0];
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private static String findShortestWord(String text) {
        String[] words = text.split("[^a-zA-Zа-яА-Я]+");
        String shortestWord = words[0];
        for (String word : words) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }
        return shortestWord;
    }

    private static void typewriterPrint(String modifiedText) throws InterruptedException {
        if (modifiedText == null) {
            System.out.println(modifiedText + "\n");
            return;
        }

        String result = modifiedText.toString();
        String[] chars = result.split("");
        for (String item : chars) {
            System.out.print(item);
            Thread.sleep(200);
        }
        System.out.println("\n");
    }
}
