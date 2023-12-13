package main;

public class FrLanguage implements LanguageInterface {
    @Override
    public String getCongrats() {
        return Expression.Felicitations;
    }

    public String getGreeting() {
        return Expression.Bonjour;
    }

    public String getGoodbye() {
        return Expression.AuRevoir;
    }

    public String getWellSaid() {
        return Expression.BienDit;
    }

    @Override
    public String toString() {
        return "Langue Française";
    }
}
