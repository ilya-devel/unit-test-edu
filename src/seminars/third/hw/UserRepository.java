package seminars.third.hw;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void removeByName(String username) {
        data.removeIf(user -> user.name.equals(username));
    }

    public void logOutAll() {
        for (User user : data) {
            if (!user.isAdmin) {
                user.isAuthenticate = false;

            }
        }
    }

}