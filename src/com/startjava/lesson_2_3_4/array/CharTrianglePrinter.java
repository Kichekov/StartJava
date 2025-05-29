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
            chars[i] = isAscending ? (char) (leftBorder + i) : (char) (rightBorder - i);
        }
        return chars;
    }

    private static void printTriangle(char[] chars) {
        if (chars == null) {
            return;
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
        System.out.println(triangle);
    }
}


