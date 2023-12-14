package main;

import main.Enum.MomentOfTheDay;

public class CheckPalindrome {
    private final LanguageInterface language;
    private MomentOfTheDay momentOfTheDay; // Ajoutez un champ pour stocker le moment de la journée

    public CheckPalindrome(LanguageInterface language, MomentOfTheDay momentOfTheDay) {
        this.language = language;
        this.momentOfTheDay = momentOfTheDay; // Stockez le moment de la journée passé au constructeur
    }

    public String verify(String string) {
        String mirror = new StringBuilder(string).reverse().toString();
        StringBuilder result = new StringBuilder(); // Initialisez StringBuilder pour construire la réponse

        // Utilisez getGreeting avec le moment de la journée stocké
        result.append(language.getGreeting(momentOfTheDay)).append(System.lineSeparator());
        result.append(mirror);

        if (mirror.equals(string)) {
            result.append(System.lineSeparator()).append(language.getWellSaid());
            result.append(System.lineSeparator()).append(language.getCongrats());
        }

        // Utilisez getGoodbye avec le moment de la journée stocké
        result.append(System.lineSeparator()).append(language.getGoodbye(momentOfTheDay));
        return result.toString();
    }

    // Cette méthode devrait mettre à jour le moment de la journée
    public void setMomentOfTheDay(MomentOfTheDay momentOfTheDay) {
        this.momentOfTheDay = momentOfTheDay;
    }
}

