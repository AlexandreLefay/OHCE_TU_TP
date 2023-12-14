package test.utilities;

import main.EnLanguage;
import main.Enum.MomentOfTheDay;
import main.FrLanguage;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.*;

public class TestDataProviders {

    static Stream<Arguments> fournirCasPourSalutationsMatinales() {
        return Stream.of(
                Arguments.of("radar", new FrLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("non", new FrLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("anna", new FrLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("radar", new EnLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("non", new EnLanguage(), MomentOfTheDay.MATIN),
                Arguments.of("anna", new EnLanguage(), MomentOfTheDay.MATIN)
        );
    }
}
