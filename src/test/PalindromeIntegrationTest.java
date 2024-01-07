package test;

import main.CheckPalindrome;
import main.EnLanguage;
import main.Enum.Greetings;
import main.Enum.MomentOfTheDay;
import main.FrLanguage;
import main.LanguageInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.stream.Stream;

import static main.CheckPalindrome.determineMomentOfTheDay;
import static main.CheckPalindrome.getSystemLanguage;
import static main.Main.main;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PalindromeIntegrationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private static Stream<Arguments> provideCasesForTesting() {
        return Stream.of(
                Arguments.of("radar", new FrLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("hello", new EnLanguage(), MomentOfTheDay.SOIREE),
                Arguments.of("anna", new FrLanguage(), MomentOfTheDay.NUIT),
                Arguments.of("anna", new EnLanguage(), MomentOfTheDay.MATIN)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCasesForTesting")
    public void testPalindromeWithConsole(String inputString, LanguageInterface language, MomentOfTheDay moment) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        CheckPalindrome checker = new CheckPalindrome(language, moment);
        String result = checker.verify(inputString);

        assertTrue("La sortie doit contenir le mot inversé", result.contains(new StringBuilder(inputString).reverse().toString()));
    }

    @Test
    public void testCompleteIntegrationWithConsole() {
        String input = "radar";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        main(new String[]{});

        String output = outContent.toString();
        assertTrue("La sortie doit contenir le mot 'radar'", output.contains("radar"));
    }

    @Test
    public void testNoFinalNewLine() {
        System.setIn(new ByteArrayInputStream("radar".getBytes()));

        main(new String[]{});

        String result = outContent.toString();

        if (result.length() > 1) {
            char secondLastChar = result.charAt(result.length() - 2);
            boolean hasNoExtraFinalNewLine = secondLastChar != '\n' && secondLastChar != '\r';
            assertTrue("Il ne devrait pas y avoir de saut de ligne supplémentaire avant le saut de ligne automatique", hasNoExtraFinalNewLine);
        } else {
            fail("La sortie est trop courte pour être testée");
        }
    }


    @Test
    public void testSystemLanguageAndTimeWithConsole() {
        LanguageInterface systemLanguage = getSystemLanguage();
        MomentOfTheDay systemMoment = determineMomentOfTheDay(LocalTime.now());

        String inputString = "radar";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        CheckPalindrome checker = new CheckPalindrome(systemLanguage, systemMoment);
        String result = checker.verify(inputString);

        String expectedStart = Greetings.getGreetingByLanguageAndTime(systemLanguage.getLanguageEnum(), systemMoment);
        String expectedEnd = Greetings.getGoodByeByLanguageAndTime(systemLanguage.getLanguageEnum(), systemMoment);

        assertTrue("La sortie doit commencer par la salutation appropriée", result.startsWith(expectedStart));
        assertTrue("La sortie doit se terminer par l'au revoir approprié", result.endsWith(expectedEnd));
    }


}
