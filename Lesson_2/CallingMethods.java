public class CallingMethods {
    private NonBoolMethods nonBoolMethods;
    private BoolMethods boolMethods;

    public CallingMethods(NonBoolMethods nonBoolMethods, BoolMethods boolMethods) {
        this.nonBoolMethods = nonBoolMethods;
        this.boolMethods = boolMethods;
    }

    public void printNonBoolMethods() {
        nonBoolMethods.findLongestWord();
        nonBoolMethods.chooseMenuItem();
        nonBoolMethods.calculateAverageGrade();
        nonBoolMethods.countUniqueWords();
        nonBoolMethods.showErrorMessage();
        nonBoolMethods.synchronizeData();
        nonBoolMethods.restoreBackupData();
        nonBoolMethods.pauseDownload();
        nonBoolMethods.restoreDefaultSettings();
        nonBoolMethods.writeContentToFile();
        nonBoolMethods.convertCelsiusToFahrenheit();
        nonBoolMethods.inputMathematicalExpression();
        nonBoolMethods.identifyWinner();
        nonBoolMethods.findBooksByAuthorName();
    }

    public void printBoolMethods() {
        boolMethods.isRunning();
        boolMethods.isFileRemoved();
        boolMethods.hasUniqueDigit();
        boolMethods.isLetterEntered();
        boolMethods.areNumbersEqual();
        boolMethods.hasAttempts();
        boolMethods.isEmpty();
        boolMethods.isEvenNumber();
        boolMethods.isPathValid();
        boolMethods.doesFileExist();
    }
}