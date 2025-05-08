package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("Задача No. 1: ВЫВОД ХАРАКТЕРИСТИК КОМПЬЮТЕРА");
        byte cpuQty = 1;
        System.out.println("Количество физических процессоров: " + cpuQty);
        char coreQty = '4';
        System.out.println("Количество ядер: " + coreQty);
        int cpuSeries = 3700;
        System.out.println("Серия процессора Intel(R) Pentium(R) CPU N " + cpuSeries);
        long ramQty = 80194412;
        System.out.println("Количество оперативной память: " + ramQty + " KiB");
        float cpuBaseFrequency = 1.6F;
        System.out.println("Базовая частота процессора: " + cpuBaseFrequency + " GHz");
        double cpuMaxFrequency = 2.4;
        System.out.println("Максимальная частота процессора: " + cpuMaxFrequency + " GHz");
        short horizontal = 1366;
        short vertical = 768;
        System.out.println("Разрешение экрана: " + horizontal + " x " + vertical);
        boolean hasGpuAcceleration = true;
        System.out.println("Графическое ускорение: " + hasGpuAcceleration);

        System.out.println("\nЗадача No. 2: РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ");
        double penPrice = 105.5;
        double bookPrice = 235.83;
        double basePrice = penPrice + bookPrice;
        double discount = 11.0;
        double discountSum = basePrice * (discount / 100);
        double discountPrice = basePrice - discountSum;
        System.out.printf("Общая стоимость товаров без скидки: %.2f руб. \n", basePrice);
        System.out.printf("Общая сумма скидки: %.2f руб. \n", discountSum);
        System.out.printf("Общая стоимость товаров со скидкой: %.2f руб. \n", discountPrice);

        System.out.println("\nЗадача No. 3: ВЫВОД СЛОВА JAVA");
        System.out.println("""
                J    a  v     v  a
                J   a a  v   v  a a
             J  J  aaaaa  V V  aaaaa
              JJ  a     a  V  a     a""");

        System.out.println("\nЗадача No. 4: ВЫВОД MIN И MAX ЗНАЧЕНИЙ ЦЕЛЫХ ЧИСЛОВЫХ ТИПОВ");
        byte originalByteValue = 127;
        System.out.println("Первоначальное значение: " + originalByteValue);
        System.out.println("Значение после инкремента: " + ++originalByteValue);
        System.out.println("Значение после декремента: " + --originalByteValue);

        short originalShortValue = 32_767;
        System.out.println("\n" + "Первоначальное значение: " + originalShortValue);
        System.out.println("Значение после инкремента: " + ++originalShortValue);
        System.out.println("Значение после декремента: " + --originalShortValue);

        int originalIntValue = 2_147_483_647;
        System.out.println("\n" + "Первоначальное значение: " + originalIntValue);
        System.out.println("Значение после инкремента: " + ++originalIntValue);
        System.out.println("Значение после декремента: " + --originalIntValue);

        long originalLongValue = 9_223_372_036_854_775_807L;
        System.out.println("\n" + "Первоначальное значение: " + originalLongValue);
        System.out.println("Значение после инкремента: " + ++originalLongValue);
        System.out.println("Значение после декремента: " + --originalLongValue);

        char originalCharValue = 65_535;
        System.out.println("\n" + "Первоначальное значение: " + (int) originalCharValue);
        System.out.println("Значение после инкремента: " + (int) ++originalCharValue);
        System.out.println("Значение после декремента: " + (int) --originalCharValue);

        System.out.println("\nЗадача No. 5: ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ПЕРЕМЕННЫХ");
        System.out.println("Исходные значения переменных:");
        int numberOne = 2;
        int numberTwo = 5;
        System.out.printf("numberOne = %d, numberTwo = %d\n", numberOne, numberTwo);

        System.out.println("Перестановка значений переменных с помощью третьей переменной:");
        int temp = numberOne;
        numberOne = numberTwo;
        numberTwo = temp;
        System.out.printf("numberOne = %d, numberTwo = %d \n", numberOne, numberTwo);

        System.out.println("Перестановка значений переменных с помощью арифметических операций:");
        numberOne += numberTwo;
        numberTwo = numberOne - numberTwo;
        numberOne -= numberTwo;
        System.out.printf("numberOne = %d, numberTwo = %d \n", numberOne, numberTwo);

        System.out.println("Перестановка значений переменных с помощью побитовой операции^:");
        numberOne ^= numberTwo;
        numberTwo ^= numberOne;
        numberOne ^= numberTwo;
        System.out.printf("numberOne = %d, numberTwo = %d \n", numberOne, numberTwo);

        System.out.println("\nЗадача No. 6: ВЫВОД СИМВОЛОВ И ИХ КОДОВ");
        char dollarSign = '$';
        char asterisk = '*';
        char at = '@';
        char caret = '^';
        char tilde = '~';
        System.out.println("Код символа: " + (int) dollarSign +
                ", соответствующий коду символ: " + dollarSign);
        System.out.println("Код символа: " + (int) asterisk +
                ", соответствующий коду символ: " + asterisk);
        System.out.println("Код символа: " + (int) at +
                ", соответствующий коду символ: " + at);
        System.out.println("Код символа: " + (int) caret +
                ", соответствующий коду символ: " + caret);
        System.out.println("Код символа: " + (int) tilde +
                ", соответствующий коду символ: " + tilde);

        System.out.println("\nЗадача No. 7: ВЫВОД В КОНСОЛЬ ASCII-АРТ ДЮКА");
        char slash = '/';
        char backslash = '\\';
        char leftBracket = '(';
        char rightBracket = ')';
        char underline = '_';
        System.out.println("    " + slash + backslash);
        System.out.println("   " + slash + "  " + backslash);
        System.out.println("  " + slash + underline + leftBracket + 
                " " + rightBracket + backslash);
        System.out.println(" " + slash + "      " + backslash);
        System.out.println("" + slash + underline + underline + underline +
                underline + slash + backslash + underline + underline + backslash + "\n");

        System.out.println("Задача No. 8: МАНИПУЛЯЦИИ С СОТНЯМИ, ДЕСЯТКАМИ И ЕДИНИЦАМИ ЧИСЛА");
        int initialNumber = 123;
        int hundreds = initialNumber / 100;
        int tens = initialNumber % 100 / 10;
        int ones = initialNumber % 10;
        System.out.println("Число " + initialNumber + " содержит:" + 
                "\n  сотен - " + hundreds +
                "\n" + "  десятков - " + tens +
                "\n" + "  единиц - " + ones);
        System.out.println("Сумма разрядов = " + (hundreds + tens + ones));
        System.out.println("Произведение разрядов = " + (hundreds * tens * ones) + "\n");

        System.out.println("Задача No. 9: ПЕРЕВОД СЕКУНД В ЧАСЫ, МИНУТЫ И СЕКУНДЫ");
        int totalSeconds = 86399;
        int hours = totalSeconds / 3600;
        int minutes = totalSeconds % 60;
        int seconds = (totalSeconds / 60) % 60;
        System.out.printf("%02d:%02d:%02d \n", hours, minutes, seconds);

        System.out.println("\nЗадача No. 10: РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ С ПОМОЩЬЮ BigDecimal");
        BigDecimal penPriceBd = new BigDecimal("105.5");
        BigDecimal bookPriceBd = new BigDecimal("235.83");
        BigDecimal basePriceBd = new BigDecimal(String.valueOf(penPriceBd.add(bookPriceBd)));
        BigDecimal discountBd = new BigDecimal("11.0");
        BigDecimal discountSumBd = basePriceBd.multiply(discountBd.divide(
                BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
        BigDecimal discountPriceBd = basePriceBd.subtract(discountSumBd);
        System.out.printf("Общая стоимость товаров без скидки: %.2f руб. \n", basePriceBd);
        System.out.printf("Общая сумма скидки: %.2f руб. \n", discountSumBd);
        System.out.printf("Общая стоимость товаров со скидкой: %.2f руб. \n", discountPriceBd);
    }
}
