package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EvenOddNumberTest {

    MainHW mainHW;
    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 13, 123})
    void testOddNumber (int num) {
        assertFalse(mainHW.evenOddNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 10, 120, 1000})
    void testEvenNumber (int num) {
        assertTrue(mainHW.evenOddNumber(num));
    }
}
