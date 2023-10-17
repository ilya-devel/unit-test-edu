package seminars.first._Homework.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatingDiscountTest {
    public static void main(String[] args) {
        assertThat(Calculator.calculatingDiscount(100, 15)).isEqualTo(85.0);
        assertThat(Calculator.calculatingDiscount(0, 15)).isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(100, 0)).isEqualTo(100.0);
        assertThat(Calculator.calculatingDiscount(100, 100)).isEqualTo(0);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-100, 0)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, -10)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, 110)).isInstanceOf(ArithmeticException.class);
    }
}
