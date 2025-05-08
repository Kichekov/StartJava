import java.math.BigDecimal;
import java.math.RoundingMode;

class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("Задача No. 1: ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");
        boolean isMale = true;
        if (!isMale) {
            System.out.println("Женский пол");
        } else {
            System.out.println("Мужской пол");
        }

        int age = 35;
        if (age > 18) {
            System.out.println("Возраст больше 18 лет");
        } else {
            System.out.println("Возраст меньше 18 лет");
        }

        double height = 1.7;
        if (height < 1.8) {
            System.out.println("Рост меньше 1.8 метра");
        } else {
            System.out.println("Рост больше 1.8 метра");
        }

        char firstLetterOfName = "Maksim".charAt(0);
        if (firstLetterOfName == 'M') {
            System.out.println("Первая буква имени - М");
        } else if (firstLetterOfName == 'I') {
            System.out.println("Первая буква имени - I");
        } else {
            System.out.println("Первая буква имени точно не M или I");
        }

        System.out.println("\nЗадача No. 2: ПОИСК БОЛЬШЕГО ЧИСЛА");
        int numOne = 9;
        int numTwo = 7;
        if (numOne > numTwo) {
            System.out.println(numOne + " > " + numTwo);
        } else if (numOne < numTwo) {
            System.out.println(numOne + " < " + numTwo);
        } else {
            System.out.println(numOne + " == " + numTwo);
        }

        System.out.println("\nЗадача No. 3: ПРОВЕРКА ЧИСЛА");
        int testNum = 2;
        if (testNum != 0) {
            String parity = testNum % 2 == 0 ? "четным" : "нечетным";
            String sign = testNum > 0 ? "положительным" : "отрицательным";
            System.out.println(testNum + " является " + sign + " и " + parity);
        } else {
            System.out.println("ERROR исходное значение равно 0, дальнейший расчет невозможен.");
        }

        System.out.println("\nЗадача No. 4: ПОИСК ОДИНАКОВЫХ ЦИФР В ЧИСЛАХ");
        int firstNum = 123;
        int secondNum = 223;
        int hundredsOfFirstNum = firstNum / 100;
        int tensOfFirstNum = firstNum % 100 / 10;
        int onesOfFirstNum = firstNum % 10;
        int hundredsOfSecondNum = secondNum / 100;
        int tensOfSecondNum = secondNum % 100 / 10;
        int onesOfSecondNum = secondNum % 10;
        boolean isEqualHundreds = hundredsOfFirstNum == hundredsOfSecondNum;
        boolean isEqualTens = tensOfFirstNum == tensOfSecondNum;
        boolean isEqualOnes = onesOfFirstNum == onesOfSecondNum;
        if ((hundredsOfFirstNum == hundredsOfSecondNum) ||
                (tensOfFirstNum == tensOfSecondNum) ||
                (onesOfFirstNum == onesOfSecondNum)) {
            System.out.printf("|Разряд  |Число %4d|Число %4d|\n", firstNum, secondNum);
            if (isEqualHundreds) {
                System.out.printf("|Сотни   |  %4d    |  %4d    |\n",
                        hundredsOfFirstNum, hundredsOfSecondNum);
            }
            if (isEqualTens) {
                System.out.printf("|Десятки |  %4d    |  %4d    |\n",
                        tensOfFirstNum, tensOfSecondNum);
            }
            if (isEqualOnes) {
                System.out.printf("|Единицы |  %4d    |  %4d    |\n",
                        onesOfFirstNum, onesOfSecondNum);
            }
        } else {
            System.out.println("Отсутствуют совпадения в разрядах исходных чисел");
        }

        System.out.println("\nЗадача No. 5: ОПРЕДЕЛЕНИЕ СИМВОЛА ПО ЕГО КОДУ");
        char uncknownChar = '\u0057';
        if (uncknownChar >= 'A' && uncknownChar <= 'Z') {
            System.out.println(uncknownChar + " - большая буква");
        } else if (uncknownChar >= 'a' && uncknownChar <= 'z') {
            System.out.println(uncknownChar + " - маленькая буква");
        } else if (uncknownChar >= '1' && uncknownChar <= '9') {
            System.out.println(uncknownChar + " - цифра");
        } else {
            System.out.println(uncknownChar + " - ни буква и ни цифра");
        }

        System.out.println("\nЗадача No. 6: ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        double depositValue = 321123.59;
        double interestRate = 10;
        if (depositValue < 100_000) {
            interestRate = 5;
        } else if (depositValue >= 100_000 && depositValue <= 300_000) {
            interestRate = 7;
        } 
        double interestIncome = depositValue * (interestRate / 100.0);
        double totalDepositValue = depositValue + interestIncome;
        System.out.printf("Сумма вклада: %.2f руб." +
                "\nСумму начисленного %%: %.2f руб." +
                "\nИтоговую сумму с %%: %.2f руб.\n",
                 depositValue, interestIncome, totalDepositValue);

        System.out.println("\nЗадача No. 7: ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        int historyPct = 59;
        int historyMark = 2;
        if (historyPct > 60 && historyPct <= 73) {
            historyMark = 3;
        } else if (historyPct > 73 && historyPct <= 91) {
            historyMark = 4;
        } else if (historyPct > 91) {
            historyMark = 5;
        }

        int programmingPct = 92;
        int programmingMark = 2;
        if (programmingPct > 60 && programmingPct <= 73) {
            programmingMark = 3;
        } else if (programmingPct > 73 && programmingPct <= 91) {
            programmingMark = 4;
        } else if (programmingPct > 91) {
            programmingMark = 5;
        }

        System.out.println("Предмет: История. Оценка по предмету: " + historyMark + ".");
        System.out.println("Предмет: Программирование. Оценка по предмету: " + programmingMark + ".");
        double avgMark = (double) (historyMark + programmingMark) / 2.0;
        System.out.printf("Cредний балл оценок по предметам: %.2f\n", avgMark);
        double avgPct = (double) (programmingPct + historyPct) / 2.0;
        System.out.printf("Cредний %% по предметам: %.2f\n", avgPct);

        System.out.println("\nЗадача No. 8: РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        double monthlyRevenue = 13025.233;
        double rent = 5123.018;
        double productionCost = 9001.729;
        double yearlyProfit = (monthlyRevenue - (rent + productionCost)) * 12;
        if (yearlyProfit != 0) {
            System.out.printf("Прибыль за год: %+.2f руб.\n", yearlyProfit);
        } else {
            System.out.println("Прибыль за год: 0,00 руб.");
        }

        System.out.println("\nЗадача No. 9: РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ ПРИ ПОМОЩИ BigDecimal");
        BigDecimal depositValueBd = new BigDecimal("321123.59");
        double percent = 10;
        if (depositValueBd.compareTo(BigDecimal.valueOf(100000)) < 0) {
            percent = 5;
        } else if (depositValueBd.compareTo(BigDecimal.valueOf(100000)) >= 0 &&
                depositValueBd.compareTo(BigDecimal.valueOf(300000)) <= 0) {
            percent = 7;
        } 
        BigDecimal interestIncomeBd = depositValueBd.multiply(
                BigDecimal.valueOf(percent).divide(BigDecimal.valueOf(100)));
        BigDecimal totalDepositValueBd = depositValueBd.add(interestIncomeBd);
        System.out.printf("Сумма вклада: %.2f руб." +
                "\nСумму начисленного %%: %.2f руб." +
                "\nИтоговую сумму с %%: %.2f руб.\n",
                        depositValueBd, interestIncomeBd, totalDepositValueBd);

        System.out.println("\nЗадача No. 10: РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ ПРИ ПОМОЩИ BigDecimal");
        BigDecimal monthlyRevenueBd = new BigDecimal("13025.233");
        BigDecimal rentBd = new BigDecimal("5123.018");
        BigDecimal productionCostBd = new BigDecimal("9001.729");
        BigDecimal yearlyProfitBd = monthlyRevenueBd.subtract(
                rentBd.add(productionCostBd)).multiply(BigDecimal.valueOf(12));
        if (yearlyProfitBd.compareTo(BigDecimal.ZERO) != 0) {
            System.out.printf("Прибыль за год: %+.2f руб.\n", yearlyProfitBd);
        } else {
            System.out.println("Прибыль за год: 0,00 руб.");
        }
    }
}