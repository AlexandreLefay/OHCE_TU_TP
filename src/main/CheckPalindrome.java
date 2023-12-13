package main;

public class CheckPalindrome {
    public static String verify(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }

    public static String verifyPalindrome(String inputString) {
        String mirror = verify(inputString);
        if (mirror.equals(inputString)) {
            return mirror + System.lineSeparator() + Expression.BienDit;
        }
        return mirror;
    }
}