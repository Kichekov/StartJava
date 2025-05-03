public class MethodsNameTest {
    public static void main(String[] args) {
        MethodsNameTest testMethodsNaming = new MethodsNameTest();

        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        testMethodsNaming.printmethods();

        System.out.println("\nBOOLEAN-МЕТОДЫ");
        testMethodsNaming.printBoolMethods();
    }

    public void printBoolMethods() {
        BoolMethods boolMethodTest = new BoolMethods();
        System.out.println(boolMethodTest.isRunning());;
        System.out.println(boolMethodTest.isFileRemoved());
        System.out.println(boolMethodTest.hasUniqueDigit());
        System.out.println(boolMethodTest.isLetterEntered());
        System.out.println(boolMethodTest.areNumbersEqual());
        System.out.println(boolMethodTest.hasAttempts());
        System.out.println(boolMethodTest.isEmpty());
        System.out.println(boolMethodTest.isEvenNumber());
        System.out.println(boolMethodTest.isPathValid());;
        System.out.println(boolMethodTest.doesFileExist());
    }

    public void printmethods() {
        NonBoolMethods nonBoolMethodTest = new NonBoolMethods();
        nonBoolMethodTest.findLongestWord();
        nonBoolMethodTest.chooseMenuItem();
        nonBoolMethodTest.calculateAverageGrade();
        nonBoolMethodTest.countUniqueWords();
        nonBoolMethodTest.showErrorMessage();
        nonBoolMethodTest.synchronizeData();
        nonBoolMethodTest.restoreBackupData();
        nonBoolMethodTest.pauseDownload();
        nonBoolMethodTest.restoreDefaultSettings();
        nonBoolMethodTest.writeContentToFile();
        nonBoolMethodTest.convertCelsiusToFahrenheit();
        nonBoolMethodTest.inputMathematicalExpression();
        nonBoolMethodTest.identifyWinner();
        nonBoolMethodTest.findBooksByAuthorName();
    }
}