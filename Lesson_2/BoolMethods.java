class BoolMethods {
    public static String currentMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();
    }

    public boolean isRunning() {
        boolean result = true;
        System.out.println(currentMethodName() + 
                "() -> программа выполняется далее или завершается? " + result);
        return result;
    }

    public boolean isFileRemoved() {
        boolean result = false;
        System.out.println(currentMethodName() + 
                "() -> удалился ли файл на жестком диске или флешке? " + result);
        return result;
    }

    public boolean hasUniqueDigit() {
        boolean result = true;
        System.out.println(currentMethodName() + 
                "() -> последовательность содержит уникальную цифру? " + result);
        return result;
    }

    public boolean isLetterEntered() {
        boolean result = true;
        System.out.println(currentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? " + result);
        return result;
    }

    public boolean areNumbersEqual() {
        boolean result = false;
        System.out.println(currentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? " + result);
        return result;
    }

    public boolean hasAttempts() {
        boolean result = false;
        System.out.println(currentMethodName() + 
                "() -> в игре \"Марио\" остались попытки? " + result);
        return result;
    }

    public boolean isEmpty() {
        boolean result = false;
        System.out.println(currentMethodName() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? " + result);
        return result;
    }

    public boolean isEvenNumber() {
        boolean result = false;
        System.out.println(currentMethodName() + 
                "() -> на кубике, который бросил компьютер, выпало четное число? " + result);
        return result;
    }

    public boolean isPathValid() {
        boolean result = false;
        System.out.println(currentMethodName() + 
                "() -> путь до файла, который вы ищите на ssd, действительный? " + result);
        return result;
    }

    public boolean doesFileExist() {
        boolean result = false;
        System.out.println(currentMethodName() + 
                "() -> файл по указанному адресу существует? " + result);
        return result;
    }
}

