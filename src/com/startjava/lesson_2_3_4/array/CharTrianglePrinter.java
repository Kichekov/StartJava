package com.startjava.lesson_2_3_4.array;

public class CharTrianglePrinter {
    public static void main(String[] args) {
        StringBuilder triangle;

        triangle = buildCharRangeTriangle('0', '9', true);
        printTriangle(triangle);

        triangle = buildCharRangeTriangle('/', '!', false);
        printTriangle(triangle);

        triangle = buildCharRangeTriangle('A', 'J', false);
        printTriangle(triangle);
    }

    private static StringBuilder buildCharRangeTriangle(char leftBorder, char rightBorder, boolean isAscending) {
        if (leftBorder > rightBorder) {
            System.out.printf("Ошибка: левая граница (%d) > правой (%d)%n\n",
                    (int) leftBorder, (int) rightBorder);
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

    private static void printTriangle(StringBuilder triangle) {
        if (triangle == null) {
            return;
        }

        System.out.println(triangle);
    }
}


