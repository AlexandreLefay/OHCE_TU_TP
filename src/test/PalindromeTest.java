package test;

import main.CheckPalindrome;
import main.Expression;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.TestCase.assertEquals;

/**
 * QUAND on saisit une chaîne ALORS celle-ci est renvoyée en miroir
 * QUAND on saisit un palindrome ALORS celui-ci est renvoyé ET «Bien dit» est envoyé ensuite
 * QUAND on saisit une chaîne ALORS «Bonjour» est envoyé avant toute réponse
 * QUAND on saisit une chaîne ALORS «Au revoir» est envoyé en dernier
 */


public class PalindromeTest {
    @ParameterizedTest
    @ValueSource(strings = { "radar", "non", "test", "epsi" })
    public void testMirror(String inputString) {

        String result = CheckPalindrome.verify(inputString);

        String reverse = new StringBuilder(inputString).reverse().toString();

        assertEquals(reverse, result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "radar", "non", "anna" })
    public void testPalindrome(String inputString) {

        String result = CheckPalindrome.verifyPalindrome(inputString);

        String expectedString = inputString + System.lineSeparator() + Expression.BienDit;

        assertEquals(expectedString, result);
    }
}