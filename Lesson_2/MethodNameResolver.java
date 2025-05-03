public class MethodNameResolver {
    public static String currentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}