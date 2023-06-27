package main.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationStellar {
    //Личный кабинет
    private static final By BUTTON_PERSONAL_ACCOUNT = By.xpath("//a/p[text()='Личный Кабинет']");
    //зарегистрироваться(после клика в личный кабинет):
    private static final By BUTTON_REGISTRATION = By.xpath("//p/a[text()='Зарегистрироваться']");
    //поле имя
    private static final By FOLDER_NAME = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //поле логин/почта:
    private static final By FOLDER_LOGIN = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //поле пароль:
    private static final By FOLDER_PASSWORD = By.xpath("//div/input[@name='Пароль']");
    //кнопка зарегистрироваться:
    private static final By BUTTON_REGISTRATION_BY_TWO = By.xpath("//button[text()='Зарегистрироваться']");
    //надпись некорректный пароль:
    private static final By INCORRECT_PASSWORD = By.xpath("//div/p[text()='Некорректный пароль']");

    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    private final WebDriver driver;

    public RegistrationStellar(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы")
    public void open() {
        driver.get(PAGE_URL);
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickButtonPersonalAccount() {
        driver.findElement(BUTTON_PERSONAL_ACCOUNT).click();
    }

    @Step("Регистрация после клика по кнопке Личный кабинет")
    public void clickButtonPersonalAccountRegistration() {
        driver.findElement(BUTTON_REGISTRATION).click();
    }

    @Step("Ввод имени")
    public String inputNameUserRegistration(String name) {
        driver.findElement(FOLDER_NAME).click();
        driver.findElement(FOLDER_NAME).sendKeys(name);
        return name;
    }

    @Step("Ввод почты/логина")
    public String inputEmailUserRegistration(String email) {
        driver.findElement(FOLDER_LOGIN).click();
        driver.findElement(FOLDER_LOGIN).sendKeys(email);
        return email;
    }

    @Step("Ввод пароля")
    public String inputPasswordUserRegistration(String password) {
        driver.findElement(FOLDER_PASSWORD).click();
        driver.findElement(FOLDER_PASSWORD).sendKeys(password);
        return password;
    }

    @Step("Нажать кнопку зарегистрироваться")
    public void clickButtonRegistrationByFullFolder() {
        driver.findElement(BUTTON_REGISTRATION_BY_TWO).click();
    }

    @Step("Нажать кнопку войти после нажатия в Личный кабинет")
    public void LoginAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_PERSONAL_ACCOUNT));
        driver.findElement(BUTTON_PERSONAL_ACCOUNT).click();
    }

    @Step("Получение надписи - Некорректный пароль")
    public String getTextIncorrectPass() {
        return driver.findElement(INCORRECT_PASSWORD).getText();
    }

    @Step("Переход на стартовую страницу")
    public void transitionMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='AppHeader_header__logo__2D0X2']")));
        driver.findElement(By.cssSelector("#root > div > header > nav > div > a > svg")).click();

    }
}