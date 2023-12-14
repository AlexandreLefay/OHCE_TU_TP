package test.utilities;

import main.CheckPalindrome;
import main.LanguageInterface;
import main.Enum.MomentOfTheDay;

public class CheckPalindromeBuilder {
    private LanguageInterface language;
    private MomentOfTheDay momentOfTheDay;

    public CheckPalindromeBuilder(LanguageInterface language) {
        this.language = language;
        this.momentOfTheDay = MomentOfTheDay.MATIN; // Valeur par défaut
    }

    public CheckPalindromeBuilder avecMomentDeLaJournee(MomentOfTheDay momentOfTheDay) {
        this.momentOfTheDay = momentOfTheDay;
        return this;
    }

    public CheckPalindrome build() {
        return new CheckPalindrome(this.language, this.momentOfTheDay);
    }
}
