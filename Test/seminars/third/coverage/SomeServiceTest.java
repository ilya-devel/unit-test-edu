package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {

    SomeService service;

    @BeforeEach
    public void setUp() {
        service = new SomeService();
    }

    // 3.1.
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 21})
    void multipleThreeNotFiveReturnsFizz(int n) {
        String actual = service.fizzBuzz(n);

        assertThat(actual).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25})
    void multipleThreeNotFiveReturnsBuzz(int n) {
        String actual = service.fizzBuzz(n);

        assertThat(actual).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60})
    void multipleThreeNotFiveReturnsFizzBuzz(int n) {
        String actual = service.fizzBuzz(n);

        assertThat(actual).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 49, 101, 121})
    void multipleThreeNotFiveReturnsNum(int n) {
        String actual = service.fizzBuzz(n);

        assertThat(actual).isEqualTo(String.valueOf(n));
    }

    @Test
    void checkNullableArray() {
        boolean actual = service.firstLast6(null);
        assertFalse(actual);
    }

    @Test
    void checkFirst6Array() {
        boolean actual = service.firstLast6(new int[]{6, 0, 0});
        assertTrue(actual);
    }

    @Test
    void checkLast6Array() {
        boolean actual = service.firstLast6(new int[]{0, 0, 6});
        assertTrue(actual);
    }

    @Test
    void checkMiddle6Array() {
        boolean actual = service.firstLast6(new int[]{0, 6, 0});
        assertFalse(actual);
    }

    @Test
    void checkEmptyArray() {
        boolean actual = service.firstLast6(new int[]{});
        assertFalse(actual);
    }

    @Test
    void checkWithout6Array() {
        boolean actual = service.firstLast6(new int[]{7, 0, 0});
        assertFalse(actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"100, 50", "200, 50", "1000, 20"})
    void checkCalculateDiscountPositive(double purchase, int discount) {
        double actual = service.calculatingDiscount(purchase, discount);
        assertThat(actual).isEqualTo(purchase - purchase * discount / 100);
    }

    @ParameterizedTest
    @CsvSource(value = {"-100, 50", "-200, 50", "-1000, 20"})
    void checkCalculateWithNegPurchase(double purchase, int discount) {
        Exception exc = assertThrows(IllegalArgumentException.class, () -> service.calculatingDiscount(purchase, discount));
        assertEquals(exc.getMessage(), "purchase can't bew less than zero");
    }

    @ParameterizedTest
    @CsvSource(value = {"100, -50", "200, -50", "1000, -20"})
    void checkCalculateWithNegDiscount(double purchase, int discount) {
        Exception exc = assertThrows(IllegalArgumentException.class, () -> service.calculatingDiscount(purchase, discount));
        assertEquals(exc.getMessage(), "discount can't bew less than zero");
    }

    @ParameterizedTest
    @CsvSource(value = {"-100, -50", "-200, -50", "-1000, -20"})
    void checkCalculateWithNegPurchaseAndDiscount(double purchase, int discount) {
        Exception exc = assertThrows(IllegalArgumentException.class, () -> service.calculatingDiscount(purchase, discount));
        assertEquals(exc.getMessage(), "purchase and discount can't bew less than zero");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "4,5,6", "7,8,9"})
    void checkSumThreeNumbers(int a, int b, int c) {
        int actual = service.sumThreeNumbers(a, b, c);
        assertEquals(a + b + c, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"13,2,3", "4,13,6", "7,8,13"})
    void checkSumThreeNumbersWith13One(int a, int b, int c) {
        int actual = service.sumThreeNumbers(a, b, c);
        assertEquals(a + b + c - 13, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"13,13,3", "13,5,13", "7,13,13"})
    void checkSumThreeNumbersWith13Two(int a, int b, int c) {
        int actual = service.sumThreeNumbers(a, b, c);
        assertEquals(a + b + c - 26, actual);
    }

}