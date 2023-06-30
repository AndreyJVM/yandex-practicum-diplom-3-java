package api.generator;

import api.models.User;
import main.page.TestValue;

public class UserGenerator {

    public static User getUser() {
        String name = TestValue.NAME;
        String email = TestValue.TEST_EMAIL_ONE;
        String password = TestValue.TEST_PASSWORD_ONE;

        return new User(email, password, name );
    }
}