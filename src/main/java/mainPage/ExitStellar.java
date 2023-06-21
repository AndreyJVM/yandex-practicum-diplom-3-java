package mainPage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExitStellar {
    //кнопка выход из профиля:
    private static final By BUTTON_EXIT = By.xpath(".//button[text()='Выход']");
    //кнопка Войти
    private static final By BUTTON_ENTRANCE = By.xpath("//button[text()='Войти']");

    private final WebDriver driver;

    public ExitStellar(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по Выход (из акаунта)")
    public void clickExitAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_EXIT));
        driver.findElement(BUTTON_EXIT).click();
    }

    @Step("Получение текста надписи с кнопки Вход")
    public String getTextButtonEntrance() {
        return driver.findElement(BUTTON_ENTRANCE).getText();
    }
}