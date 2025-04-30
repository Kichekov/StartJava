class NonBoolMethods {
    public static String currentMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();
    }

    public void findLongestWord() {
        System.out.println(currentMethodName() + 
                "() -> найти самое длинное слово в предложении из книги по Java");
    }

    public void chooseMenuItem() {
        System.out.println(currentMethodName() + 
                "() -> выбрать пункт меню в текстовом редакторе на macOS");
    }

    public void calculateAverageGrade() {
        System.out.println(currentMethodName() + 
                "() -> вычислить среднее значение оценок в школе №1234");
    }

    public void countUniqueWords() {
        System.out.println(currentMethodName() + 
                "() ->  подсчитать количество уникальных слов в \"Война и Мир\"");
    }

    public void showErrorMessage() {
        System.out.println(currentMethodName() + 
                "() ->  вывести сообщение об ошибке");
    }

    public void synchronizeData() {
        System.out.println(currentMethodName() + 
                "() -> синхронизировать данные с облачным хранилищем");
    }

    public void restoreBackupData() {
        System.out.println(currentMethodName() + 
                "() -> восстановить данные из резервной копии от 11.03.2024");
    }

    public void pauseDownload() {
        System.out.println(currentMethodName() + 
                "() -> приостановить загрузку mp3-файла группы \"Ария\"");
    }

    public void restoreDefaultSettings() {
        System.out.println(currentMethodName() + 
                "() -> сбросить настройки до заводских для пылесоса Mi");
    }

    public void writeContentToFile() {
        System.out.println(currentMethodName() + 
                "() -> записать содержимое в файл по указанному пути на флешку");
    }

    public void convertCelsiusToFahrenheit() {
        System.out.println(currentMethodName() + 
                "() -> преобразовать температуру из Цельсия в Фаренгейт");
    }

    public void inputMathematicalExpression() {
        System.out.println(currentMethodName() + 
                "() -> ввести математическое выражение с тремя аргументами");
    }

    public void identifyWinner() {
        System.out.println(currentMethodName() + 
                "() -> выявить победителя среди гонщиков игры \"Need For Speed\"");
    }

    public void findBooksByAuthorName() {
        System.out.println(currentMethodName() + 
                "() -> найти книгу по имени писателя");
    }
}
