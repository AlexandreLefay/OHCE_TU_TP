package test;

import main.CheckPalindrome;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.TestCase.assertEquals;

public class PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = {"radar", "non", "test", "epsi"})
    public void testPalindrome(String inputString) {
        // ETANT DONNE une chaîne
        // QUAND on vérifie si c'est un palindrome
        String result = CheckPalindrome.ReturnPalindrome(inputString);

        String reverse = new StringBuilder(inputString).reverse().toString();

        // ALORS le résultat doit être vrai pour un palindrome et faux sinon
        assertEquals(reverse, result);
    }
}