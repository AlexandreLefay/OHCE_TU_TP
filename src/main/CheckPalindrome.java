package main;

import main.Enum.MomentOfTheDay;

import java.time.LocalTime;
import java.util.Locale;

public class CheckPalindrome {
    private final LanguageInterface language;
    private final MomentOfTheDay momentOfTheDay; // Ajoutez un champ pour stocker le moment de la journée

    public CheckPalindrome(LanguageInterface language, MomentOfTheDay momentOfTheDay) {
        this.language = language;
        this.momentOfTheDay = momentOfTheDay; // Stockez le moment de la journée passé au constructeur
    }
    public static LanguageInterface getSystemLanguage() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().equals(new Locale("fr").getLanguage()) ? new FrLanguage() : new EnLanguage();
    }

    public String verify(String string) {
        String mirror = new StringBuilder(string).reverse().toString();
        StringBuilder result = new StringBuilder(); // Initialise StringBuilder pour construire la réponse

        result.append(language.getGreeting(momentOfTheDay)).append(System.lineSeparator());
        result.append(mirror);

        if (mirror.equalsIgnoreCase(string)) {
            result.append(System.lineSeparator()).append(language.getWellSaid());
            result.append(System.lineSeparator()).append(language.getCongrats());
        }

        result.append(System.lineSeparator()).append(language.getGoodbye(momentOfTheDay));
        return result.toString();
    }

    public static MomentOfTheDay determineMomentOfTheDay(LocalTime time) {
        if (time.getHour() < 12) {
            return MomentOfTheDay.MATIN;
        } else if (time.getHour() < 18) {
            return MomentOfTheDay.APRES_MIDI;
        } else if (time.getHour() < 22) {
            return MomentOfTheDay.SOIREE;
        } else {
            return MomentOfTheDay.NUIT;
        }
    }
}
