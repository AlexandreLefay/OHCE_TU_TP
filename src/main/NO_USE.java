package main;

import main.Enum.MomentOfTheDay;

import java.util.*;

public class NO_USE {
    private static final Map<MomentOfTheDay, String> greetingsByMoment;

    static {
        greetingsByMoment = new HashMap<>();
        greetingsByMoment.put(MomentOfTheDay.MATIN, "bonjour_am");
        greetingsByMoment.put(MomentOfTheDay.APRES_MIDI, "bonjour_pm");
        greetingsByMoment.put(MomentOfTheDay.SOIREE, "bonjour_soir");
        greetingsByMoment.put(MomentOfTheDay.NUIT, "bonjour_nuit");
    }

    public static String getGreeting(MomentOfTheDay moment) {
        return greetingsByMoment.getOrDefault(moment, "Bonjour");
    }
}