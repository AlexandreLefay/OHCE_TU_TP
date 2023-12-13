package test;

import main.CheckPalindrome;
import main.Expression;
import main.FrLanguage;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ETAPE 1 - DONE
 *
 * QUAND on saisit une chaîne ALORS celle-ci est renvoyée en miroir
 * QUAND on saisit un palindrome ALORS celui-ci est renvoyé ET «Bien dit» est envoyé ensuite
 * QUAND on saisit une chaîne ALORS «Bonjour» est envoyé avant toute réponse
 * QUAND on saisit une chaîne ALORS «Au revoir» est envoyé en dernier
 */

/**
 * ETAPE 2 - IN PROGRESS
 *
 * ETANT DONNE un utilisateur parlant une langue
 * QUAND on entre un palindrome
 * ALORS il est renvoyé
 * ET le <bienDit> de cette langue est envoyé
 *
 *ETANT DONNE un utilisateur parlant une langue
 * QUAND on saisit une chaîne
 * ALORS <bonjour> de cette langue est envoyé avant tout
 *
 * ETANT DONNE un utilisateur parlant une langue
 * QUAND on saisit une chaîne
 * ALORS <auRevoir> dans cette langue est envoyé en dernier
 */

public class PalindromeTest {

    // Test for mirror functionality
    @ParameterizedTest
    @ValueSource(strings = {"radar", "non", "test", "epsi"})
    public void testMirror(String inputString) {
        FrLanguage language = new FrLanguage();
        CheckPalindrome checker = new CheckPalindrome(language);
        String result = checker.verify(inputString);

        String reverse = new StringBuilder(inputString).reverse().toString();
        assertTrue(result.contains(reverse));
    }

    // Test for French palindrome with specific language greetings
    @Test
    public void testFrenchPalindrome() {
        String palindrome = "radar";
        FrLanguage language = new FrLanguage();
        CheckPalindrome checker = new CheckPalindrome(language);
        String result = checker.verify(palindrome);

        String expected = Expression.Bonjour + System.lineSeparator() +
                palindrome + System.lineSeparator() +
                Expression.Felicitations + System.lineSeparator() +
                Expression.AuRevoir;

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"radar", "non", "anna"})
    public void testHello(String inputString) {
        FrLanguage language = new FrLanguage();
        CheckPalindrome checker = new CheckPalindrome(language);
        String result = checker.verify(inputString);

        assertTrue(result.startsWith(Expression.Bonjour));
    }

    // Test for language-specific goodbye
    @ParameterizedTest
    @ValueSource(strings = {"radar", "non", "anna"})
    public void testGoodbye(String inputString) {
        FrLanguage language = new FrLanguage();
        CheckPalindrome checker = new CheckPalindrome(language);
        String result = checker.verify(inputString);

        assertTrue(result.endsWith(Expression.AuRevoir));
    }
}