package test;

import main.CheckPalindrome;
import main.EnLanguage;
import main.Enum.Greetings;
import main.Enum.Language;
import main.Enum.MomentOfTheDay;
import main.FrLanguage;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import test.utilities.CheckPalindromeBuilder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ETAPE 1 - DONE
 * <p>
 * QUAND on saisit une chaîne ALORS celle-ci est renvoyée en miroir
 * QUAND on saisit un palindrome ALORS celui-ci est renvoyé ET «Bien dit» est envoyé ensuite
 * QUAND on saisit une chaîne ALORS «Bonjour» est envoyé avant toute réponse
 * QUAND on saisit une chaîne ALORS «Au revoir» est envoyé en dernier
 * /


 /** ETAPE 2 - DONE
 *
 * ETANT DONNE un utilisateur parlant une langue
 * QUAND on entre un palindrome
 * ALORS il est renvoyé
 * ET le <bienDit> de cette langue est envoyé
 *
 * ETANT DONNE un utilisateur parlant une langue
 * QUAND on saisit une chaîne
 * ALORS <bonjour> de cette langue est envoyé avant tout
 *
 * ETANT DONNE un utilisateur parlant une langue
 * QUAND on saisit une chaîne
 * ALORS <auRevoir> dans cette langue est envoyé en dernier
 */

/**
 *
 *
 */
public class PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = { "radar", "non", "test", "epsi" })
    public void testMirror(String inputString) {
        CheckPalindrome checker = new CheckPalindromeBuilder(new FrLanguage())
                .avecMomentDeLaJournee(MomentOfTheDay.MATIN)
                .build();
        String result = checker.verify(inputString);

        String reverse = new StringBuilder(inputString).reverse().toString();
        assertTrue(result.contains(reverse));
    }

    @Test
    public void testFrenchPalindrome() {
        CheckPalindrome checker = new CheckPalindromeBuilder(new FrLanguage())
                .avecMomentDeLaJournee(MomentOfTheDay.MATIN)
                .build();
        String palindrome = "radar";
        String result = checker.verify(palindrome);

        String expectedStart = Greetings.getGreetingByLanguageAndTime(Language.FRENCH, MomentOfTheDay.MATIN);
        String confirm = Greetings.getConfirmPalindrom(Language.FRENCH);
        String congrats = Greetings.getCongratsByLanguageAndTime(Language.FRENCH);
        String expectedEnd = Greetings.getGoodByeByLanguageAndTime(Language.FRENCH, MomentOfTheDay.MATIN);


        assertTrue(result.startsWith(expectedStart));
        assertTrue(result.contains(palindrome));
        assertTrue(result.contains(confirm));
        assertTrue(result.contains(congrats));
        assertTrue(result.endsWith(expectedEnd));
    }

    @ParameterizedTest
    @ValueSource(strings = { "radar", "non", "anna" })
    public void testHelloAtTheBeginningInFrench(String inputString) {
        CheckPalindrome checker = new CheckPalindromeBuilder(new FrLanguage())
                .avecMomentDeLaJournee(MomentOfTheDay.MATIN)
                .build();
        String result = checker.verify(inputString);

        String expected = Greetings.getGreetingByLanguageAndTime(Language.FRENCH, MomentOfTheDay.MATIN);

        assertTrue(result.startsWith(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = { "radar", "non", "anna" })
    public void testGoodbyeInFrench(String inputString) {
        CheckPalindrome checker = new CheckPalindromeBuilder(new FrLanguage())
                .avecMomentDeLaJournee(MomentOfTheDay.MATIN)
                .build();
        String result = checker.verify(inputString);

        String expected = Greetings.getGoodByeByLanguageAndTime(Language.FRENCH, MomentOfTheDay.MATIN);

        assertTrue(result.endsWith(expected));
    }

    @Test
    public void testMorningGreetingInEnglish() {
        CheckPalindrome checker = new CheckPalindromeBuilder(new EnLanguage())
                .avecMomentDeLaJournee(MomentOfTheDay.MATIN)
                .build();
        String palindrome = "radar";
        String result = checker.verify(palindrome);

        String expectedStart = Greetings.getGreetingByLanguageAndTime(Language.ENGLISH, MomentOfTheDay.MATIN);

        assertTrue(result.startsWith(expectedStart));
    }
}