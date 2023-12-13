package main;

public class CheckPalindrome {
    private final LanguageInterface language;

    public CheckPalindrome(LanguageInterface language) {
        this.language = language;
    }

    public String verify(String string) {
        String mirror = new StringBuilder(string).reverse().toString();

        StringBuilder result = new StringBuilder();
        result.append(language.getGreeting()).append(System.lineSeparator());
        result.append(mirror);

        if (mirror.equals(string)) {
            result.append(System.lineSeparator()).append(language.getCongrats());
        }

        result.append(System.lineSeparator()).append(language.getGoodbye());
        return result.toString();
    }
}

