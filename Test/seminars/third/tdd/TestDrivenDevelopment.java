package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {

    MoodAnalyser moodAnalyser;
    @BeforeEach
    void SetUp(){
        moodAnalyser = new MoodAnalyser();
    }

    //3.5. Red-Green-Refactor
    @ParameterizedTest
    @ValueSource(strings = {"Good", "Cool", "Beautiful"})
    void testCheckGoodMood (String input) {
        String actual = moodAnalyser.analyseMood(input);
        assertThat(actual).isEqualTo("Great");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Sad", "Boring", "Apathy"})
    void testCheckBadMood (String input) {
        String actual = moodAnalyser.analyseMood(input);
        assertThat(actual).isEqualTo("Bad");
    }

    @ParameterizedTest
    @ValueSource(strings = {"View", "Except", "--"})
    void testCheckNoneMood (String input) {
        String actual = moodAnalyser.analyseMood(input);
        assertThat(actual).isEqualTo("None");
    }
}