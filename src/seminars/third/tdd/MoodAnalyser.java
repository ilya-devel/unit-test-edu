package seminars.third.tdd;

import java.util.Arrays;

public class MoodAnalyser {

    String[] good = new String[] {"Good", "Cool", "Beautiful"};
    String[] bad = new String[] {"Sad", "Boring", "Apathy"};

    public String analyseMood(String message) {
        if (Arrays.asList(good).contains(message)) return "Great";
        if (Arrays.asList(bad).contains(message)) return "Bad";
        return "None";
    }

}