import java.math.BigDecimal;
import java.math.RoundingMode;

class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("Задача No. 1: ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");
        boolean isGenderMale = true;
        if (!isGenderMale) {
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
        int testNamber = 0;
        if (testNamber != 0) {
            if (testNamber > 0 && testNamber % 2 == 0) {
                System.out.println(testNamber + " является положительным и четным");
            } else if (testNamber < 0 && testNamber % 2 == 0) {
                System.out.println(testNamber + " является отрицательным и четным");
            } else if (testNamber > 0 && testNamber % 2 != 0) {
                System.out.println(testNamber + " является положительным и не четным");
            } else if (testNamber < 0 && testNamber % 2 != 0) {
                System.out.println(testNamber + " является отрицательным и не четным");
            }
        } else {
            System.out.println("ERROR исходное значение равно 0, дальнейший расчет невозможен.");
        }

        System.out.println("\nЗадача No. 4: ПОИСК ОДИНАКОВЫХ ЦИФР В ЧИСЛАХ");
        int firstOperand = 123;
        int secondOperand = 223;
        int hundredsOfFirstOperand = firstOperand / 100;
        int tensOfFirstOperand = firstOperand % 100 / 10;
        int onesOfFirstOperand = firstOperand % 10;
        int hundredsOfSecondOperand = secondOperand / 100;
        int tensOfSecondOperand = secondOperand % 100 / 10;
        int onesOfSecondOperand = secondOperand % 10;
        boolean isEqualHundreds = hundredsOfFirstOperand == hundredsOfSecondOperand;
        boolean isEqualTens = tensOfFirstOperand == tensOfSecondOperand;
        boolean isEqualones = onesOfFirstOperand == onesOfSecondOperand;
        if ((hundredsOfFirstOperand == hundredsOfSecondOperand) ||
                (tensOfFirstOperand == tensOfSecondOperand) ||
                (onesOfFirstOperand == onesOfSecondOperand)) {
            System.out.printf("|Разряд  |Число %4d|Число %4d|\n", firstOperand, secondOperand);
            if (isEqualHundreds) {
                System.out.printf("|Сотни   |  %4d    |  %4d    |\n",
                        hundredsOfFirstOperand, hundredsOfSecondOperand);
            }
            if (isEqualTens) {
                System.out.printf("|Десятки |  %4d    |  %4d    |\n",
                        tensOfFirstOperand, tensOfSecondOperand);
            }
            if (isEqualones) {
                System.out.printf("|Единицы |  %4d    |  %4d    |\n",
                        onesOfFirstOperand, onesOfSecondOperand);
            }
        } else {
            System.out.println("Отсутствуют совпадения в разрядах исходных чисел");
        }

        System.out.println("\nЗадача No. 5: ОПРЕДЕЛЕНИЕ СИМВОЛА ПО ЕГО КОДУ");
        char initialCharacter = '\u0057';
        if ((int) initialCharacter > 64 && (int) initialCharacter < 91) {
            System.out.println(initialCharacter + " - большая буква");
        } else if ((int) initialCharacter > 96 && (int) initialCharacter < 123) {
            System.out.println(initialCharacter + " - маленькая буква");
        } else if ((int) initialCharacter > 47 && (int) initialCharacter < 58) {
            System.out.println(initialCharacter + " - цифра");
        } else {
            System.out.println(initialCharacter + " - ни буква и ни цифра");
        }

        System.out.println("\nЗадача No. 6: ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        double depositValue = 321123.59;
        double interestOfRate = 0;
        if (depositValue < 10_000) {
            interestOfRate = 5;
        } else if (depositValue > 100_000 && depositValue < 300_000) {
            interestOfRate = 7;
        } else if (depositValue > 30_000) {
            interestOfRate = 10;
        }
        double interestIncome = depositValue * (interestOfRate / 100.0);
        double totalDepositValue = depositValue + interestIncome;
        System.out.printf("Сумма вклада: %.2f руб." +
                "\nСумму начисленного %%: %.2f руб." +
                "\nИтоговую сумму с %%: %.2f руб.\n",
                 depositValue, interestIncome, totalDepositValue);

        System.out.println("\nЗадача No. 7: ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        int pctHistory = 59;
        int historyAssessment = 0;
        int pctProgramming = 92;
        int programmingAssessment = 0;

        if (pctHistory <= 60) {
            historyAssessment = 2;
        } else if (pctHistory > 60 && pctHistory <= 73) {
            historyAssessment = 3;
        } else if (pctHistory > 73 && pctHistory <= 91) {
            historyAssessment = 4;
        } else {
            historyAssessment = 5;
        }

        if (pctProgramming <= 60) {
            programmingAssessment = 2;
        } else if (pctProgramming > 60 && pctProgramming <= 73) {
            programmingAssessment = 3;
        } else if (pctProgramming > 73 && pctProgramming <= 91) {
            programmingAssessment = 4;
        } else {
            programmingAssessment = 5;
        }

        System.out.println("Предмет: История. Оценка по предмету: " + historyAssessment + ".");
        System.out.println("Предмет: Программирование. Оценка по предмету: " + programmingAssessment + ".");
        double avgMark = (double) (historyAssessment + programmingAssessment) / 2.0;
        System.out.printf("Cредний балл оценок по предметам: %.2f\n", avgMark);
        double avgPct = (double) (pctProgramming + pctHistory) / 2.0;
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
        double percent = 0;
        if (depositValueBd.compareTo(BigDecimal.valueOf(10000)) < 0) {
            percent = 5;
        } else if (depositValueBd.compareTo(BigDecimal.valueOf(100000)) > 0 &&
                depositValueBd.compareTo(BigDecimal.valueOf(300000)) < 0) {
            percent = 7;
        } else if (depositValueBd.compareTo(BigDecimal.valueOf(300000)) > 0) {
            percent = 10;
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
        if (yearlyProfitBd.compareTo(BigDecimal.valueOf(0)) != 0) {
            System.out.printf("Прибыль за год: %+.2f руб.\n", yearlyProfitBd);
        } else {
            System.out.println("Прибыль за год: 0,00 руб.");
        }
    }
}