import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    @Before
    @Step("Открыть страницу")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    @Step("Закрытие браузера")
    public void cleanUp() {
        driver.quit();
    }
}