package main;

import main.Enum.MomentOfTheDay;

import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

import static main.CheckPalindrome.determineMomentOfTheDay;

public class Main {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        LanguageInterface language = locale.getLanguage().equals(new Locale("fr").getLanguage()) ? new FrLanguage() : new EnLanguage();

        MomentOfTheDay momentOfTheDay = determineMomentOfTheDay(LocalTime.now());

        CheckPalindrome checker = new CheckPalindrome(language, momentOfTheDay);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un mot pour vérifier s'il s'agit d'un palindrome :");
        String inputString = scanner.nextLine();

        String result = checker.verify(inputString);

        System.out.print(result);
    }
}