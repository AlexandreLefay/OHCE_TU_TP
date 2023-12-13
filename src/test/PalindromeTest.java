package test;

import main.CheckPalindrome;
import main.Expression;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(result.contains(reverse));
    }

    @Test
    public void testPalindrome() {
        String palindrome = "anna";

        String result = CheckPalindrome.verify(palindrome);

        String expected = palindrome + System.lineSeparator() + Expression.BienDit;

        assertTrue(result.contains(expected), result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "radar", "non", "anna" })
    public void testHello(String inputString) {

        String result = CheckPalindrome.verify(inputString);

        assertTrue(result.contains(Expression.Bonjour));
    }

    @ParameterizedTest
    @ValueSource(strings = { "radar", "non", "anna" })
    public void testGoodBye(String inputString) {

        String result = CheckPalindrome.verify(inputString);

        assertTrue(result.contains(Expression.AuRevoir));
    }


}