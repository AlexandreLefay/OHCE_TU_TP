package test.utilities;

import main.LanguageInterface;
public class LangueStub implements LanguageInterface {
    @Override
    public String getCongrats() {
        return "";
    }

    @Override
    public String getGreeting() {
        return "";
    }

    @Override
    public String getGoodbye() {
        return "";
    }

    @Override
    public String getWellSaid() {
        return "";
    }
}