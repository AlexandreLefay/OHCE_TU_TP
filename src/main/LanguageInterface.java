package main;

import main.Enum.MomentOfTheDay;

public interface LanguageInterface {
    String getCongrats();
    String getGreeting(MomentOfTheDay time);
    String getGreeting();
    String getGoodbye(MomentOfTheDay momentOfTheDay);
    String getWellSaid();
}
