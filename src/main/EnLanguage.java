package main;

public class EnLanguage implements LanguageInterface {
    @Override
    public String getCongrats() {
        return Expression.Congrats;
    }

    public String getGreeting() {
        return Expression.Hello;
    }

    public String getGoodbye() {
        return Expression.Goodbye;
    }

    public String getWellSaid() {
        return Expression.WellSaid;
    }

    @Override
    public String toString() {
        return "English Language";
    }
}
