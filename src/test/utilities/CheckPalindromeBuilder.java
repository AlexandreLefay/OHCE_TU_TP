package test.utilities;

import main.CheckPalindrome;
import main.LanguageInterface;

public class CheckPalindromeBuilder {
    private LanguageInterface language = new LangueStub();

    public static CheckPalindrome Default() {
        return new CheckPalindromeBuilder().Build();
    }

    public CheckPalindromeBuilder AyantPourLangue(LanguageInterface language){
        this.language = language;
        return this;
    }

    public CheckPalindrome Build() {
        return new CheckPalindrome(this.language);
    }
}