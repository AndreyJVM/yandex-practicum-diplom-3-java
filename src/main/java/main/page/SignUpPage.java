package main.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;


public class SignUpPage {

    public final static String SIGN_UP_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following-sibling::input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//*[text()='Email']/following-sibling::input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//*[text()='Пароль']/following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement confirmSignUpButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement signUpPageEnterButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement errorMessage;

    @Step("Ввод имени")
    public SignUpPage setName(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Ввод Email")
    public SignUpPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Ввод пароля")
    public SignUpPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Клик по кнопке Зарегистрироваться и переход на страницу Регистрации")
    public SignInPage clickConfirmSignUpButton() {
        confirmSignUpButton.click();
        return page(SignInPage.class);
    }

    @Step("Клик по кнопке Войти")
    public SignInPage clickSignUpPageEnterButton() {
        signUpPageEnterButton.click();
        return page(SignInPage.class);
    }
}