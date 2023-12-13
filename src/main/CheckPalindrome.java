package main;

public class CheckPalindrome {
    public static String ReturnPalindrome(String string) {
        return new StringBuilder(string)
                .reverse()
                .toString();
    }
}