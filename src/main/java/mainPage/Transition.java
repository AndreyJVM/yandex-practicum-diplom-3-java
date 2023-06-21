package mainPage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Transition {

    private final WebDriver driver;

    public Transition(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка на переход в конструктор:
    private static final By BUTTON_TRANS_CONSTRUCTOR = By.xpath("//a/p[text()='Конструктор']");

    //надпись соберите бургер
    private static final By TITLE_COLLECT_BURGER = By.xpath("//h1[text()='Соберите бургер']");

    //надпись переход по логотипу на стартовую страницу
    private static final By TITLE_LOGO = By.cssSelector("div > a > svg");

    @Step("Клик на кнопку Конструктор")
    public void clickTransConstructor() {
        driver.findElement(BUTTON_TRANS_CONSTRUCTOR).click();
    }

    @Step("Клик на Логотип")
    public void clickLogotip() {
        driver.findElement(TITLE_LOGO).click();
    }

    @Step("Получить видимой надпись - Соберите бургер ")
    public String getTextCollectBurger() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(TITLE_COLLECT_BURGER));
        return driver.findElement(TITLE_COLLECT_BURGER).getText();
    }
}