package manager;

import org.apache.commons.lang3.RandomStringUtils;

public class TestValue extends RandomStringUtils {
    /**
     * Contains test data for creating a user such as: login, password, name
     */
    public static final String
            TEST_EMAIL_ONE = randomAlphabetic(10).toLowerCase() + "@yandex.ru",
            TEST_PASSWORD_ONE = "123qwe",
            PASSWORD_ERROR = "123",
            TEST_NAME_ONE = randomAlphabetic(10);
}