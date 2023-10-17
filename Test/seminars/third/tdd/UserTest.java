package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    static UserRepository repo;

    @BeforeAll
    static void setUp() {
        repo = new UserRepository();
    }

    @Test
    void checkAuthenticatedUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void checkAuthenticatedUserNegative() {
        String name = "name";
        String password = "password";
        String wrongpass = "pass";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, wrongpass);
        assertFalse(accept);
    }

    @Test
    void checkRepoAddUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);
        int currentCount = repo.data.size();
        repo.addUser(user);

        assertThat(repo.data.size()).isEqualTo(currentCount + 1);

        if (!repo.data.isEmpty()) {
            User userInRepo = repo.data.get(currentCount);
            assertEquals(user, userInRepo);
        }


    }

    @Test
    void checkRepoAddUserNegative() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);
        int currentCount = repo.data.size();

        User userInRepo;

        if (!repo.data.isEmpty()) {
            userInRepo = repo.data.get(currentCount - 1);
        } else {
            userInRepo = null;
        }
        assertNotEquals(user, userInRepo);
    }
}