package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    //5.1.
    List<Integer> lstInt;

    @BeforeEach
    void setUp() {
        lstInt = Arrays.asList(1, 3, 4, 2, 8, 9);
    }


    @Test
    void maxNumberModuleTest() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        int maxValue = maxNumberModule.getMaxValue(lstInt);

        assertThat(maxValue).isEqualTo(9);
    }

    @Test
    void randomNumberModuleTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();

        List<Integer> lstRandomInt = randomNumberModule.generateRandomIntList(10);

        assertThat(lstRandomInt).isNotEmpty().hasSize(10);
    }

    @Test
    void maxRandomTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        lstInt = randomNumberModule.generateRandomIntList(10);
        int maxValue = maxNumberModule.getMaxValue(lstInt);

        assertThat(Collections.max(lstInt)).isEqualTo(maxValue);
    }

    //5.2.

    @ParameterizedTest
    @ValueSource(ints = {23, 44, 666})
    void userServiceTest(int id) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String answer = userService.getUserName(id);

        assertThat(answer).isEqualTo("User " + id);
    }

    //5.3.

    @Test
    void orderServiceTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("id111", 12.3);

        assertThat(result).isTrue();
    }

}