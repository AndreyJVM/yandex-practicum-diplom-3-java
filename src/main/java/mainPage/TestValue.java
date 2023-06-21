package mainPage;

import org.openqa.selenium.WebDriver;

public class TestValue {
    private final WebDriver driver;

    public TestValue(WebDriver driver) {
        this.driver = driver;
    }

    public static final String LOGIN = "james-bond@yandex.ru";
    public static final String PASSWORD = "123qwe";
    public static final String PASSWORD_ERROR = "123";
    public static final String NAME = "james-bond";
    public static final String URL_DELETE_USER_REQUEST = "https://stellarburgers.nomoreparties.site/api/auth/user";
}