class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("Задача No. 1: ПОДСЧЕТ СУММЫ ЧЕТНЫХ И НЕЧЕТНЫХ ЧИСЕЛ");
        int leftBorder = -10;
        int counter = leftBorder;
        int rightBorder = 21;
        int evenSum = 0;
        int oddSum = 0;
        while (counter <= rightBorder) {
            if (counter % 2 == 0) {
                evenSum += counter;
            } else {
                oddSum += counter;
            }
            counter++;
        } 
        System.out.printf("В отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d\n",
                leftBorder, rightBorder, evenSum, oddSum);

        System.out.println("\nЗадача No. 2: ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX В ПОРЯДКЕ УБЫВАНИЯ");
        int valueA = 10;
        int valueB = 5;
        int valueC = -1;

        int min = (valueA < valueB) ? 
                ((valueA < valueC) ? valueA : valueC) : ((valueB < valueC) ? valueB : valueC);
        int max = (valueA > valueB) ? 
                ((valueA > valueC) ? valueA : valueC) : ((valueB > valueC) ? valueB : valueC);

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nЗадача No. 3: ВЫВОД РЕВЕРСИВНОГО ЧИСЛА И СУММЫ ЕГО ЦИФР");
        int initialNumber = 1234;
        int sumCounter = 0;
        System.out.print("Исходное число в обратном порядке: ");
        while (initialNumber > 0) {
            int lastNumber = initialNumber % 10;
            sumCounter += lastNumber;
            System.out.print(lastNumber);
            initialNumber /= 10;
        }
        System.out.println("\nСумма выделенных цифр: " + sumCounter);

        System.out.println("\nЗадача No. 4: ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        int startPoint = 1;
        int endPoint = 24;
        int count = 0;
        for (int i = startPoint; i < endPoint; i++) {
            if (i % 2 != 0) {
                System.out.printf("%4d ", i);
                count++;
                if (count % 5 == 0) {
                    System.out.println();
                    count = 0;
                }
            }
        }
        if (count > 0) {
            for (int j = count; j < 5; j++) {
                System.out.printf("%4d ", 0);
            }
        }

        System.out.println(
                "\n\nЗадача No. 5: ПРОВЕРКА КОЛИЧЕСТВА ДВОЕК ЧИСЛА НА ЧЕТНОСТЬ/НЕЧЕТНОСТЬ");
        initialNumber = 3242592;
        int currentNumber = initialNumber;
        int countOfTwos = 0;
        while (currentNumber > 0) {
            if (currentNumber % 10 == 2) {
                countOfTwos++;
            }
            currentNumber /= 10;
        }
        String parity = countOfTwos % 2 == 0 ? "четное" : "нечетное";
        System.out.printf("В %d %s (%d) количество двоек\n", initialNumber, parity, countOfTwos);

        System.out.println("\nЗадача No. 6: ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
        } 
        System.out.println("\n");

        int lineCount = 0;
        while (lineCount < 5) {
            int hashSymbolCounter = 5 - lineCount;
            while (hashSymbolCounter > 0) {
                System.out.print("#");
                hashSymbolCounter--;
            }
            System.out.println();
            lineCount++;
        }
        System.out.println();

        int triangleH = 3;
        int rowsNum = 2 * triangleH - 1;
        int rowCount = 1; 
        int step = 1;
        int triangleW = 1;
        do {
            int itemCounter = 0;
            do {
                System.out.print("$");
            } while (++itemCounter < triangleW);
            System.out.println();
            if (rowCount == triangleH) {
                step = -1;
            }
            triangleW += step;
        } while (++rowCount <= rowsNum);

        System.out.println("\nЗадача No. 7: ВЫВОД ASCII-СИМВОЛОВ");
        System.out.printf("%-10s %5s %15s\n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i <= 122; i++) {
            if ((i % 2 != 0 && i <= 47) ||
                    (i % 2 == 0 && i >= 97 && i <= 122)) {
                String description = Character.getName(i);
                System.out.printf("%5d %10c %12c %-15s\n", i, i, ' ', description);
            }
        }

        System.out.println("\nЗадача No. 8: ПРОВЕРКА, ЯВЛЯЕТСЯ ЛИ ЧИСЛО ПАЛИНДРОМОМ");
        initialNumber = 1234321;
        currentNumber = initialNumber;
        int reversedNumber = 0;
        while (currentNumber > 0) {
            reversedNumber = reversedNumber * 10 + currentNumber % 10;
            currentNumber /= 10;
        }
        if (reversedNumber == initialNumber) {
            System.out.printf("Число %d - палиндром\n", initialNumber);
        } else {
            System.out.printf("Число %d - непалиндром\n", initialNumber);
        }

        System.out.println("\nЗадача No. 9: ПРОВЕРКА, ЯВЛЯЕТСЯ ЛИ ЧИСЛО СЧАСТЛИВЫМ");
        initialNumber = 132321;
        int leftPart = initialNumber / 1000;
        int rightPart = initialNumber % 1000;
        int rightDigitsSum = 0;
        int leftDigitsSum = 0;
        while (leftPart > 0) {
            rightDigitsSum += rightPart % 10;
            rightPart /= 10;
            leftDigitsSum += leftPart % 10;
            leftPart /= 10;
        }
        String status = rightDigitsSum == leftDigitsSum ? "счастливое" : "несчастливое";
        System.out.println("""
            Число %d - %s
            Сумма цифр %d = %d
            Сумма %d = %d
                """.formatted(
                    initialNumber, 
                    status, 
                    initialNumber / 1000, 
                    leftDigitsSum, 
                    initialNumber % 1000, 
                    rightDigitsSum));
 
        System.out.println("\nЗадача No. 10: ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ ПИФАГОРА");
        System.out.printf("%4s", '|');
        for (int i = 2; i < 10; i++) {
            System.out.printf("%3d ", i);
        }
        System.out.print("\n---+");
        for (int i = 0; i < 31; i++) {
            System.out.printf("%s", '-');
        }
        System.out.println();
        for (int i = 2; i < 10; i++) {
            System.out.print(" " + i);
            System.out.printf("%2s", '|'); 
            for (int j = 2; j < 10; j++) {
                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
    }
}