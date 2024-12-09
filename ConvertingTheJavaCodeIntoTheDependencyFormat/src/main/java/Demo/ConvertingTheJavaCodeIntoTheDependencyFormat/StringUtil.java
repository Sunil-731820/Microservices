package Demo.ConvertingTheJavaCodeIntoTheDependencyFormat;

public class StringUtil {
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return false;
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }
}