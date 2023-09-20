import api.clients.Client;
import api.clients.UserClient;
import api.generator.UserGenerator;
import api.models.Credentials;
import api.models.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import manager.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
/**
 * Родительский класс для тестов, содержит
 * создание фейкового пользователя
 * метод для выбора браузера yandex/chrome
 * и метод для удаления пользователя и закрытия браузера
 */
public class BaseTest {
    public static final User user = UserGenerator.getUser();
    public WebDriver driver;
    public UserClient userClient;

    @Before
    @Step("Открыть страницу")
    public void setUp() {
        driver = BrowserFactory.getDriver("yandex");
        driver.get(Client.BASE_URL);
        userClient = new UserClient();
        userClient.createUser(user);
    }

    @After
    @Step("Закрытие браузера")
    public void cleanUp() {
        Credentials credentials = new Credentials(user.getEmail(), user.getPassword());
        Response response = userClient.login(credentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }
        driver.quit();
    }
}