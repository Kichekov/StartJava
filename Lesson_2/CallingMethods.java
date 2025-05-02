public class CallingMethods {
    private MethodsForTest methods;

    public CallingMethods(MethodsForTest methods) {
        this.methods = methods;
    }

    public void printNonBoolMethods() {
        methods.findLongestWord();
        methods.chooseMenuItem();
        methods.calculateAverageGrade();
        methods.countUniqueWords();
        methods.showErrorMessage();
        methods.synchronizeData();
        methods.restoreBackupData();
        methods.pauseDownload();
        methods.restoreDefaultSettings();
        methods.writeContentToFile();
        methods.convertCelsiusToFahrenheit();
        methods.inputMathematicalExpression();
        methods.identifyWinner();
        methods.findBooksByAuthorName();
    }

    public void printBoolMethods() {
        methods.isRunning();
        methods.isFileRemoved();
        methods.hasUniqueDigit();
        methods.isLetterEntered();
        methods.areNumbersEqual();
        methods.hasAttempts();
        methods.isEmpty();
        methods.isEvenNumber();
        methods.isPathValid();
        methods.doesFileExist();
    }
}