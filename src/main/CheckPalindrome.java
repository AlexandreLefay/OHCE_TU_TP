package main;

public class CheckPalindrome {
    public static String verify(String inputString) {

        String mirror = new StringBuilder(inputString).reverse().toString();
        String greeting = Expression.Bonjour + System.lineSeparator() + Expression.AuRevoir;

        if (mirror.equals(inputString)) {
            return greeting + mirror + System.lineSeparator() + Expression.BienDit;
        }
        return greeting + mirror;
    }
    }
