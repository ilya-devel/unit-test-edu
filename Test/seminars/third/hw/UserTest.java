package seminars.third.hw;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

        seminars.third.tdd.User user = new seminars.third.tdd.User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void checkAuthenticatedUserNegative() {
        String name = "name";
        String password = "password";
        String wrongpass = "pass";

        seminars.third.tdd.User user = new seminars.third.tdd.User(name, password, false);
        boolean accept = user.authenticate(name, wrongpass);
        assertFalse(accept);
    }

    @Test
    void checkRepoAddUserPositive() {
        String name = "name";
        String password = "password";

        seminars.third.hw.User user = new seminars.third.hw.User(name, password, false);
        user.authenticate(name, password);
        int currentCount = repo.data.size();
        repo.addUser(user);

        assertThat(repo.data.size()).isEqualTo(currentCount + 1);

        if (!repo.data.isEmpty()) {
            seminars.third.hw.User userInRepo = repo.data.get(currentCount);
            assertEquals(user, userInRepo);
        }


    }

    @Test
    void checkRepoAddUserNegative() {
        String name = "name";
        String password = "password";

        seminars.third.tdd.User user = new seminars.third.tdd.User(name, password, false);
        user.authenticate(name, password);
        int currentCount = repo.data.size();

        seminars.third.hw.User userInRepo;

        if (!repo.data.isEmpty()) {
            userInRepo = repo.data.get(currentCount - 1);
        } else {
            userInRepo = null;
        }
        assertNotEquals(user, userInRepo);
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin"})
    void testFindByNameTrue(String name) {
        User user = new User(name, "password");
        repo.addUser(user);
        assertTrue(repo.findByName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"somename"})
    void testFindByNameFalse(String name) {
        assertFalse(repo.findByName(name));
    }

    @Test
    void checkIsAdmin() {
        User user = new User("admin", "password", true);
        assertTrue(user.getIsAdmin());
    }

    @Test
    void checkIsNotAdmin() {
        User user = new User("user", "password");
        assertFalse(user.getIsAdmin());
    }

    @ParameterizedTest
    @ValueSource(strings = {"someuser"})
    void checkRemoveUser(String name) {
        User user = new User(name, "password");
        repo.addUser(user);
        repo.removeByName(name);
        assertFalse(repo.findByName(name));
    }


    @Test
    void checkLogOutAllUsers() {
        User user1 = new User("admin", "password", true);
        user1.authenticate("admin", "password");
        User user2 = new User("user", "password");
        user2.authenticate("user", "password");
        repo.addUser(user1);
        repo.addUser(user2);
        repo.logOutAll();
        for (User user : repo.data) {
            if (!user.isAdmin) {
                assertFalse(user.isAuthenticate);
            }
        }
//        assertTrue(repo.data.get(0).isAuthenticate);
//        assertFalse(repo.data.get(1).isAuthenticate);
    }

    @Test
    void checkLogOutAllAdminsFalse() {
        User user1 = new User("admin", "password", true);
        user1.authenticate("admin", "password");
        User user2 = new User("user", "password");
        user2.authenticate("user", "password");
        repo.addUser(user1);
        repo.addUser(user2);
        repo.logOutAll();
        for (User user : repo.data) {
            if (user.isAdmin) {
                assertTrue(user.isAuthenticate);
            }
        }
    }


}
