package seminars.third.hw;

import java.util.Objects;

public class User {

    String name;
    String password;

    Boolean isAdmin;

    boolean isAuthenticate = false;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.isAdmin = false;
    }

    public User(String name, String password, boolean isAdmin) {
        this(name, password);
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        isAuthenticate = Objects.equals(this.name, name) && Objects.equals(this.password, password);
        return isAuthenticate;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

}