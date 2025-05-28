package com.startjava.lesson_2_3_4.array;

public class CharTrianglePrinter {
    public static void main(String[] args) {
        char[] chars = generateCharArray('0', '9', true);
        printTriangle(chars);

        chars = generateCharArray('/', '!', false);
        printTriangle(chars);

        chars = generateCharArray('A', 'J', false);
        printTriangle(chars);
    }

    private static char[] generateCharArray(char leftBorder, char rightBorder, boolean isAscending) {
        if (leftBorder > rightBorder) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n\n",
                    (int) leftBorder, (int) rightBorder);
            return null;
        }

        char[] chars = new char[rightBorder - leftBorder + 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (leftBorder + i);
        }

        if (!isAscending) {
            reverse(chars);
        }
        return chars;
    }

    private static void reverse(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private static void printTriangle(char[] chars) {
        if (chars == null) {
            return;
        }
        int rows = chars.length;
        int triangleWidth = (rows * 2) - 1;

        for (int i = 0; i < rows; i++) {
            char currentChar = chars[i];
            int repeatCount = i * 2 + 1;
            int spacesCount = (triangleWidth - repeatCount) / 2;

            StringBuilder sb = new StringBuilder();
            sb.append(" ".repeat(spacesCount));
            sb.append(Character.toString(currentChar).repeat(repeatCount));

            System.out.println(sb);
        }
        System.out.println();
    }
}


