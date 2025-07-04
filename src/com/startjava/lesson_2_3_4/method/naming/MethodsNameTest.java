package com.startjava.lesson_2_3_4.method.naming;

public class MethodsNameTest {
    public static void main(String[] args) {
        MethodsNameTest mnt = new MethodsNameTest();

        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        mnt.execNonBoolMethods();

        System.out.println("\nBOOLEAN-МЕТОДЫ");
        mnt.execBoolMethods();
    }

    private void execBoolMethods() {
        BoolMethods bm = new BoolMethods();
        System.out.println(bm.isRunning());;
        System.out.println(bm.isFileRemoved());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasAttempts());
        System.out.println(bm.isEmpty());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isValidPath());;
        System.out.println(bm.isExistFile());
    }

    private void execNonBoolMethods() {
        NonBoolMethods nonBm = new NonBoolMethods();
        nonBm.findLongestWord();
        nonBm.chooseMenuItem();
        nonBm.calculateAverageGrade();
        nonBm.countUniqueWords();
        nonBm.showErrorMessage();
        nonBm.synchronizeData();
        nonBm.restoreBackupData();
        nonBm.pauseDownload();
        nonBm.restoreDefaultSettings();
        nonBm.writeToFile();
        nonBm.celsiusToFahrenheit();
        nonBm.inputMathExpression();
        nonBm.identifyWinner();
        nonBm.findBookByAuthor();
    }
}
