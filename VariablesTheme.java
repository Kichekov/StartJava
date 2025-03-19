import java.math.BigDecimal;
import java.math.RoundingMode;

class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("Задача No. 1: ВЫВОД ХАРАКТЕРИСТИК КОМПЬЮТЕРА");
        byte processor = 1;
        System.out.println("Количество физических процессоров: " + processor);
        char core = '4';
        System.out.println("Количество ядер: " + 4);
        int cpuSeries = 3700;
        System.out.println("Серия процессора Intel(R) Pentium(R) CPU N " + cpuSeries);
        long ram = 80194412;
        System.out.println("Оперативная память: " + ram + " KiB");
        float cpuBaseFrequency = 1.6F;
        System.out.println("Базовая частота процессора: " + cpuBaseFrequency + " GHz");
        double cpuMaxFrequency = 2.4;
        System.out.println("Максимальная частота процессора: " + cpuMaxFrequency + " GHz");
        short horizontal = 1366;
        short vertical = 768;
        System.out.println("Разрешение экрана: " + horizontal + " x " + vertical);
        boolean graphicalAcceleration = true;
        System.out.println("Графическое ускорение: " + graphicalAcceleration);

        System.out.println("\nЗадача No. 2: РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ");
        double penPrice = 105.5;
        double bookPrice = 235.83;
        double kitPrice = penPrice + bookPrice;
        double kitDiscount = 11.0;
        double discountSum = kitPrice * (kitDiscount / 100);
        double finalPrice = kitPrice - discountSum;
        System.out.printf("Общая стоимость товаров без скидки: %.2f руб. \n", kitPrice);
        System.out.printf("Общая сумма скидки: %.2f руб. \n", discountSum);
        System.out.printf("Общая стоимость товаров со скидкой: %.2f руб. \n", finalPrice);

        System.out.println("\nЗадача No. 3: ВЫВОД СЛОВА JAVA");
        System.out.println("""
                J    a  v     v  a
                J   a a  v   v  a a
             J  J  aaaaa  V V  aaaaa
              JJ  a     a  V  a     a
                           """);

        System.out.println("\nЗадача No. 4: ВЫВОД MIN И MAX ЗНАЧЕНИЙ ЦЕЛЫХ ЧИСЛОВЫХ ТИПОВ");
        byte originalByteValue = 127;
        System.out.println("Первоначальное значение: " + originalByteValue);
        System.out.println("Значение после инкремента: " + (byte) (originalByteValue += 1));
        System.out.println("Значение после декремента: " + (byte) (originalByteValue -= 2));

        short originalShortValue = 32_767;
        System.out.println("\n" + "Первоначальное значение: " + originalShortValue);
        System.out.println("Значение после инкремента: " + (short) (originalShortValue += 1));
        System.out.println("Значение после декремента: " + (short) (originalShortValue -= 2));

        int originalIntValue = 2_147_483_647;
        System.out.println("\n" + "Первоначальное значение: " + originalIntValue);
        System.out.println("Значение после инкремента: " + (int) (originalIntValue += 1));
        System.out.println("Значение после декремента: " + (int) (originalIntValue -= 2));

        long originalLongValue = 9_223_372_036_854_775_807L;
        System.out.println("\n" + "Первоначальное значение: " + originalLongValue);
        System.out.println("Значение после инкремента: " + (long) (originalLongValue += 1));
        System.out.println("Значение после декремента: " + (long) (originalLongValue -= 2));

        char originalCharValue = 65_535;
        System.out.println("\n" + "Первоначальное значение: " + (int) (originalCharValue));
        System.out.println("Значение после инкремента: " + (int) ((char) (originalCharValue += 1)));
        System.out.println("Значение после декремента: " + (int) ((char) (originalCharValue -= 2)));

        System.out.println("\nЗадача No. 5: ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ПЕРЕМЕННЫХ");
        int numberOne = 2;
        int numberTwo = 5;
        System.out.printf("Исходные значения переменных: numberOne = %d, numberTwo = %d \n",
                numberOne, numberTwo);

        int temp = numberOne;
        numberOne = numberTwo;
        numberTwo = temp;
        System.out.printf("Перестановка значений переменных с помощью третьей переменной:" +
                        " numberOne = %d, numberTwo = %d \n", numberOne, numberTwo);

        numberOne = numberTwo + numberOne;
        numberTwo = numberOne - numberTwo;
        numberOne = numberOne - numberTwo;
        System.out.printf("Перестановка значений переменных с помощью арифметических операций:" +
                        " numberOne = %d, numberTwo = %d \n", numberOne, numberTwo);

        numberOne ^= numberTwo;
        numberTwo ^= numberOne;
        numberOne ^= numberTwo;
        System.out.printf("Перестановка значений переменных с помощью побитовой операции^:" +
                        " numberOne = %d, numberTwo = %d \n", numberOne, numberTwo);

        System.out.println("\nЗадача No. 6: ВЫВОД СИМВОЛОВ И ИХ КОДОВ");
        char firstNumber = '$';
        char secondNumber = '*';
        char thirdNumber = '@';
        char fourthNumber = '^';
        char fifthNumber = '~';
        System.out.println("Код символа: " + (int) firstNumber +
                ", соответствующий коду символ: " + firstNumber);
        System.out.println("Код символа: " + (int) secondNumber +
                ", соответствующий коду символ: " + secondNumber);
        System.out.println("Код символа: " + (int) thirdNumber +
                ", соответствующий коду символ: " + thirdNumber);
        System.out.println("Код символа: " + (int) fourthNumber +
                ", соответствующий коду символ: " + fourthNumber);
        System.out.println("Код символа: " + (int) fifthNumber +
                ", соответствующий коду символ: " + fifthNumber);

        System.out.println("\nЗадача No. 7: ВЫВОД В КОНСОЛЬ ASCII-АРТ ДЮКА");
        char directSlash = '/';
        char backSlash = '\\';
        char leftBracket = '(';
        char rightBracket = ')';
        char underline = '_';
        System.out.println("    " + directSlash + "" + backSlash);
        System.out.println("   " + directSlash + "  " + backSlash);
        System.out.println("  " + directSlash + "" + underline + leftBracket + 
                " " + rightBracket + backSlash);
        System.out.println(" " + directSlash + "      " + backSlash);
        System.out.println(directSlash + "" + underline + underline + underline +
                underline + directSlash + backSlash + underline + underline + backSlash + "\n");

        System.out.println("Задача No. 8: МАНИПУЛЯЦИИ С СОТНЯМИ, ДЕСЯТКАМИ И ЕДИНИЦАМИ ЧИСЛА");
        int number = 123;
        int hundreds = number / 100;
        int tens = number % 100 / 10;
        int units = number % 10;
        System.out.println("Число " + number + " содержит:\n  сотен - " +
                hundreds + "\n" + "  десятков - " + tens + "\n" +
                "  единиц - " + units);
        System.out.println("Сумма разрядов = " + (hundreds + tens + units));
        System.out.println("Произведение разрядов = " + (hundreds * tens * units) + "\n");

        System.out.println("Задача No. 9: ПЕРЕВОД СЕКУНД В ЧАСЫ, МИНУТЫ И СЕКУНДЫ");
        int timeInterval = 86399;
        int hours = timeInterval / 3600;
        int minutes = timeInterval % 3600 / 60;
        int seconds = (timeInterval % 3600) % 60;
        System.out.printf("%02d:%02d:%02d \n", hours, minutes, seconds);

        System.out.println("\nЗадача No. 10: РАСЧЕТ СТОИМОСТИ ТОВАРА СО СКИДКОЙ С ПОМОЩЬЮ BigDecimal");
        BigDecimal penCost = new BigDecimal("105.5");
        BigDecimal bookCost = new BigDecimal("235.83");
        BigDecimal kitCost = new BigDecimal(String.valueOf(penCost.add(bookCost)));
        BigDecimal kitSale = new BigDecimal("11.0");
        BigDecimal saleSum = new BigDecimal(String.valueOf(kitCost.multiply(
                kitSale.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP))));
        BigDecimal totalCost = new BigDecimal(String.valueOf(kitCost.subtract(saleSum)));
        System.out.printf("Общая стоимость товаров без скидки: %.2f руб. \n", kitCost);
        System.out.printf("Общая сумма скидки: %.2f руб. \n", saleSum);
        System.out.printf("Общая стоимость товаров со скидкой: %.2f руб. \n", totalCost);
    }
}