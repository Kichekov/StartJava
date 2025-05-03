public class BoolMethods {
    public boolean isRunning() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean isFileRemoved() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> удалился ли файл на жестком диске или флешке? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> последовательность содержит уникальную цифру? ");
        return true;
    }

    public boolean isLetterEntered() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean areNumbersEqual() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return false;
    }

    public boolean hasAttempts() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> в игре \"Марио\" остались попытки? ");
        return false;
    }

    public boolean isEmpty() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEvenNumber() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return false;
    }

    public boolean isPathValid() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return false;
    }

    public boolean doesFileExist() {
        System.out.print(MethodNameResolver.currentMethodName() + 
                "() -> файл по указанному адресу существует? ");
        return false;
    }
}