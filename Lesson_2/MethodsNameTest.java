class MethodsNameTest {
    public static void main(String[] args) {
        NonBoolMethods nonBoolMethods = new NonBoolMethods();
        BoolMethods boolMethods = new BoolMethods();

        CallingMethods callingMethods = new CallingMethods(nonBoolMethods, boolMethods);

        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        callingMethods.printNonBoolMethods();

        System.out.println("\nBOOLEAN-МЕТОДЫ");
        callingMethods.printBoolMethods();
    }
}