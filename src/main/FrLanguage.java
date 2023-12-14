package main;

import main.Enum.Language;
import main.Enum.MomentOfTheDay;

import static main.Enum.Greetings.*;
import static main.Enum.Language.FRENCH;

public class FrLanguage implements LanguageInterface {
    @Override
    public String getCongrats() {
        return getCongratsByLanguageAndTime(FRENCH);
    }

    @Override
    public String getGreeting(MomentOfTheDay time) {
        return getGreetingByLanguageAndTime(FRENCH, time);
    }

    @Override
    public String getGreeting() {
        return null;
    }

    @Override
    public String getGoodbye(MomentOfTheDay time) {
        return getGoodByeByLanguageAndTime(FRENCH, time);
    }

    @Override
    public String getWellSaid() {
        return getConfirmPalindrom(FRENCH);
    }

    @Override
    public String toString() {
        return "Langue Française";
    }
}
