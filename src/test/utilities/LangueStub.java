package test.utilities;

import main.Enum.Language;
import main.Enum.MomentOfTheDay;
import main.LanguageInterface;

public class LangueStub implements LanguageInterface {

    private Language language;

    public LangueStub(Language language) {
        this.language = language;
    }

    @Override
    public String getCongrats() {
        return "Stubbed Congrats";
    }

    @Override
    public String getGreeting(MomentOfTheDay time) {
        return "Stubbed Greeting for " + time;
    }

    @Override
    public String getGreeting() {
        return null;
    }

    @Override
    public String getGoodbye(MomentOfTheDay momentOfTheDay) {
        return "Stubbed Goodbye";
    }

    @Override
    public String getWellSaid() {
        return "Stubbed Well Said";
    }

    @Override
    public Language getLanguageEnum() {
        return language;
    }
}
