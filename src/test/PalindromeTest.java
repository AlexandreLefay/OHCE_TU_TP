package test;

import main.CheckPalindrome;
import main.EnLanguage;
import main.Enum.Greetings;
import main.Enum.Language;
import main.Enum.MomentOfTheDay;
import main.FrLanguage;
import main.LanguageInterface;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import test.utilities.CheckPalindromeBuilder;

import java.time.LocalTime;
import java.util.Locale;
import java.util.stream.Stream;

import static main.CheckPalindrome.determineMomentOfTheDay;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ETAPE 1 - DONE
 * <p>
 * QUAND on saisit une chaîne ALORS celle-ci est renvoyée en miroir
 * QUAND on saisit un palindrome ALORS celui-ci est renvoyé ET «Bien dit» est envoyé ensuite
 * QUAND on saisit une chaîne ALORS «Bonjour» est envoyé avant toute réponse
 * QUAND on saisit une chaîne ALORS «Au revoir» est envoyé en dernier
 * /
 * <p>
 * <p>
 * /** ETAPE 2 - DONE
 * <p>
 * ETANT DONNE un utilisateur parlant une langue
 * QUAND on entre un palindrome
 * ALORS il est renvoyé
 * ET le <bienDit> de cette langue est envoyé
 * <p>
 * ETANT DONNE un utilisateur parlant une langue
 * QUAND on saisit une chaîne
 * ALORS <bonjour> de cette langue est envoyé avant tout
 * <p>
 * ETANT DONNE un utilisateur parlant une langue
 * QUAND on saisit une chaîne
 * ALORS <auRevoir> dans cette langue est envoyé en dernier
 * ETAPE 3 - DONE
 * <p>
 * On poursuit en complexifiant, grâce aux builders qui permettent d’ajouter des cas de manière indolore.
 * <p>
 * ETANT DONNE un utilisateur parlant une langue
 * ET que la période de la journée est <période>
 * QUAND on saisit une chaîne ALORS <salutation> de cette langue à cette période est envoyé avant tout
 * CAS {‘matin’, ‘bonjour_am’}
 * CAS {‘après-midi’, ‘bonjour_pm’}
 * CAS {‘soirée’, ‘bonjour_soir’}
 * CAS {‘nuit’, ‘bonjour_nuit’}
 * <p>
 * ETANT DONNE un utilisateur parlant une langue
 * ET que la période de la journée est <période>
 * QUAND on saisit une chaîne ALORS <auRevoir> dans cette langue à cette période est envoyé en dernier
 * CAS {‘matin’, ‘auRevoir_am’}
 * CAS {‘après-midi’, ‘auRevoir _pm’}
 * CAS {‘soirée’, ‘auRevoir _soir’}
 * CAS {‘nuit’, ‘auRevoir _nuit’}
 */

/** ETAPE 3 - DONE
 *
 * On poursuit en complexifiant, grâce aux builders qui permettent d’ajouter des cas de manière indolore.
 *
 * ETANT DONNE un utilisateur parlant une langue
 * ET que la période de la journée est <période>
 * QUAND on saisit une chaîne ALORS <salutation> de cette langue à cette période est envoyé avant tout
 * CAS {‘matin’, ‘bonjour_am’}
 * CAS {‘après-midi’, ‘bonjour_pm’}
 * CAS {‘soirée’, ‘bonjour_soir’}
 * CAS {‘nuit’, ‘bonjour_nuit’}
 *
 * ETANT DONNE un utilisateur parlant une langue
 * ET que la période de la journée est <période>
 * QUAND on saisit une chaîne ALORS <auRevoir> dans cette langue à cette période est envoyé en dernier
 * CAS {‘matin’, ‘auRevoir_am’}
 * CAS {‘après-midi’, ‘auRevoir _pm’}
 * CAS {‘soirée’, ‘auRevoir _soir’}
 * CAS {‘nuit’, ‘auRevoir _nuit’}
 *
 */

/** ETAPE 4 - IN PROGRESS
 *
 * Reliez La langue à celle du système
 * Le moment de la journée à l’horloge
 * L’entrée et la sortie à la console
 *
 * Les tests d’intégration sont des points bonus.
 *
 * Il n’y a pas de saut de ligne final après le dernier output. Rédigez
 * un test de défaut
 */
public class PalindromeTest {

    private LanguageInterface getSystemLanguage() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().equals(new Locale("fr").getLanguage()) ? new FrLanguage() : new EnLanguage();
    }

    @ParameterizedTest
    @ValueSource(strings = {"radar", "non", "test", "epsi"})
    public void testMirror(String inputString) {
        CheckPalindrome checker = new CheckPalindromeBuilder(new FrLanguage())
                .withMomentOfTheDay(MomentOfTheDay.MATIN)
                .build();
        String result = checker.verify(inputString);

        String reverse = new StringBuilder(inputString).reverse().toString();
        assertTrue(result.contains(reverse));
    }

    @Test
    public void testFrenchPalindrome() {
        CheckPalindrome checker = new CheckPalindromeBuilder(new FrLanguage())
                .withMomentOfTheDay(MomentOfTheDay.MATIN)
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

    // Méthode fournissant les données pour les tests
    static Stream<Arguments> fournirCasPourSalutations() {
        return Stream.of(
                Arguments.of("radar", new FrLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("non", new FrLanguage(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("anna", new FrLanguage(), MomentOfTheDay.SOIREE),
                Arguments.of("anna", new FrLanguage(), MomentOfTheDay.NUIT),
                Arguments.of("radar", new EnLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("non", new EnLanguage(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("anna", new EnLanguage(), MomentOfTheDay.SOIREE),
                Arguments.of("anna", new EnLanguage(), MomentOfTheDay.NUIT)
        );
    }

    @ParameterizedTest
    @MethodSource("fournirCasPourSalutations")
    public void testHelloAtTheBeginningWithTheCorrectLanguage(String inputString, LanguageInterface language, MomentOfTheDay moment) {
        CheckPalindrome checker = new CheckPalindromeBuilder(language)
                .withMomentOfTheDay(moment)
                .build();
        String result = checker.verify(inputString);

        String expected = Greetings.getGreetingByLanguageAndTime(language.getLanguageEnum(), moment);

        assertTrue(result.startsWith(expected));
    }

    // Méthode fournissant les données pour les tests
    static Stream<Arguments> fournirCasPourAuRevoir() {
        return Stream.of(
                Arguments.of("radar", new FrLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("non", new FrLanguage(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("anna", new FrLanguage(), MomentOfTheDay.SOIREE),
                Arguments.of("anna", new FrLanguage(), MomentOfTheDay.NUIT),
                Arguments.of("radar", new EnLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("non", new EnLanguage(), MomentOfTheDay.APRES_MIDI),
                Arguments.of("anna", new EnLanguage(), MomentOfTheDay.SOIREE),
                Arguments.of("anna", new EnLanguage(), MomentOfTheDay.NUIT)
        );
    }

    @ParameterizedTest
    @MethodSource("fournirCasPourAuRevoir")
    public void testGoodbyeWithTheCorrectLanguage(String inputString, LanguageInterface language, MomentOfTheDay moment) {
        CheckPalindrome checker = new CheckPalindromeBuilder(language)
                .withMomentOfTheDay(moment)
                .build();
        String result = checker.verify(inputString);

        String expected = Greetings.getGoodByeByLanguageAndTime(language.getLanguageEnum(), moment);

        assertTrue(result.endsWith(expected));
    }

    @Test
    public void testMorningGreetingInEnglish() {
        CheckPalindrome checker = new CheckPalindromeBuilder(new EnLanguage())
                .withMomentOfTheDay(MomentOfTheDay.MATIN)
                .build();
        String palindrome = "radar";
        String result = checker.verify(palindrome);

        String expectedStart = Greetings.getGreetingByLanguageAndTime(Language.ENGLISH, MomentOfTheDay.MATIN);

        assertTrue(result.startsWith(expectedStart));
    }

    @Test
    public void testSystemLanguageAndTime() {
        LanguageInterface systemLanguage = getSystemLanguage();
        MomentOfTheDay systemMoment = determineMomentOfTheDay(LocalTime.now());
        CheckPalindrome checker = new CheckPalindrome(systemLanguage, systemMoment);

        String inputString = "radar";
        String result = checker.verify(inputString);

        String expectedStart = Greetings.getGreetingByLanguageAndTime(systemLanguage.getLanguageEnum(), systemMoment);
        String expectedEnd = Greetings.getGoodByeByLanguageAndTime(systemLanguage.getLanguageEnum(), systemMoment);

        assertTrue(result.startsWith(expectedStart));
        assertTrue(result.endsWith(expectedEnd));
    }

    @Test
    public void testNoFinalNewLine() {
        LanguageInterface systemLanguage = getSystemLanguage();
        MomentOfTheDay systemMoment = determineMomentOfTheDay(LocalTime.now());
        CheckPalindrome checker = new CheckPalindrome(systemLanguage, systemMoment);

        String inputString = "radar";
        String result = checker.verify(inputString);

        // Check que le dernier caractère n'est pas un saut de ligne
        char lastChar = result.charAt(result.length() - 1);
        boolean hasNoFinalNewLine = lastChar != '\n' && lastChar != '\r';
        assertTrue(hasNoFinalNewLine, "Le dernier caractère ne devrait pas être un saut de ligne");
    }

}