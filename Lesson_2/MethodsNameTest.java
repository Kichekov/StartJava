class MethodsNameTest {
    public static void main(String[] args) {
        MethodsForTest methods = new MethodsForTest();

        CallingMethods callingMethods = new CallingMethods(methods);

        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        callingMethods.printNonBoolMethods();

        System.out.println("\nBOOLEAN-МЕТОДЫ");
        callingMethods.printBoolMethods();
    }
}