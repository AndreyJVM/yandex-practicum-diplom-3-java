package api.generator;

import api.models.User;
import manager.TestValue;

public class UserGenerator {

    public static User getUser() {
        String name = TestValue.TEST_NAME_ONE;
        String email = TestValue.TEST_EMAIL_ONE;
        String password = TestValue.TEST_PASSWORD_ONE;

        return new User(email, password, name );
    }
}