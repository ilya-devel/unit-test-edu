package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberInIntervalTest {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 55, 71, 100})
    void testNumberIsInInterval(int num) {
        assertTrue(mainHW.numberInInterval(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -25, 0, 24, 101, Integer.MAX_VALUE})
    void testNumberIsOutInterval(int num) {
        assertFalse(mainHW.numberInInterval(num));
    }
}
