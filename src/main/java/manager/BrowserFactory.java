package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Паттерн Фабрика:
 * реализуем выбор бразера yandex/chrome
 */
public class BrowserFactory {

    public static WebDriver getDriver(String browserName){
        ChromeOptions options;
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*", "start-maximized");
                return new ChromeDriver(options);
            case "yandex":
                options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
                options.addArguments("--remote-allow-origins=*", "start-maximized");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
}
