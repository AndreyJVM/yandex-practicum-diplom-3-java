import api.clients.Client;
import api.clients.UserClient;
import api.generator.UserGenerator;
import api.models.User;
import io.qameta.allure.Step;
import manager.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static final User user = UserGenerator.getUser();
    public WebDriver driver;
    public UserClient userClient;

    @Before
    @Step("Открыть страницу")
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get(Client.BASE_URL);
        userClient = new UserClient();
        userClient.createUser(user);
    }

    @After
    @Step("Закрытие браузера")
    public void cleanUp() {
        driver.quit();
    }
}