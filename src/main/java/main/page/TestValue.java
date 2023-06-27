package main.page;

import org.apache.commons.lang3.RandomStringUtils;

public class TestValue extends RandomStringUtils {

    public static final String
            TEST_LOGIN_ONE = randomAlphabetic(10).toLowerCase() + "@yandex.ru",
            TEST_PASSWORD_ONE = "123qwe",
            PASSWORD_ERROR = "123",
            NAME = randomAlphabetic(10),
            URL_DELETE_USER_REQUEST = "https://stellarburgers.nomoreparties.site/api/auth/user";
}