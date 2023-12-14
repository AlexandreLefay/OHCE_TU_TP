package main;

import main.Enum.Language;
import main.Enum.MomentOfTheDay;

import static main.Enum.Greetings.*;
import static main.Enum.Language.ENGLISH;

public class EnLanguage implements LanguageInterface {
    @Override
    public String getCongrats() {
        return getCongratsByLanguageAndTime(ENGLISH);
    }

    @Override
    public String getGreeting(MomentOfTheDay time) {
        return getGreetingByLanguageAndTime(ENGLISH, time);
    }

    @Override
    public String getGreeting() {
        return null;
    }

    @Override
    public String getGoodbye(MomentOfTheDay time) {
        return getGoodByeByLanguageAndTime(ENGLISH, time);
    }

    @Override
    public String getWellSaid() {
        return getConfirmPalindrom(ENGLISH);
    }

    @Override
    public String toString() {
        return "English language";
    }
}
