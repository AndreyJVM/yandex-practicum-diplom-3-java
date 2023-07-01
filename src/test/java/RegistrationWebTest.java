import api.clients.UserClient;
import api.generator.UserGenerator;
import api.models.Credentials;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;

import org.junit.After;
import org.junit.Test;
import manager.TestValue;
import main.page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Проверяем:
 * Регистрация пользователя - успешная
 * Регистрация пользователя - некорректная
 * Удаляем пользователей после того как создали
 */
public class RegistrationWebTest{

    private UserClient userClient;

    protected String name = UserGenerator.getUser().getName();
    protected String email = UserGenerator.getUser().getEmail();
    protected String password = UserGenerator.getUser().getPassword();

    @Test
    @DisplayName("Регистрация пользователя - успешная")
    @Description("Успешная регистрация пользователя")
    public void checkSuccessRegistrationPersonalAccountButton() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickEnterAccountButton()
                .clickSignUpButton()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickConfirmSignUpButton()
                .signUpUser(email, password);


        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals("https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

    @Test
    @DisplayName("Регистрация пользователя - некорректная")
    @Description("Ошибку для некорректного пароля. Минимальный пароль — шесть символов")
    public void checkErrorRegistrationStellar() {
        boolean inValidDataRegister = open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickEnterAccountButton()
                .clickSignUpButton()
                .setName(name)
                .setEmail(email)
                .setPassword(TestValue.PASSWORD_ERROR)
                .clickConfirmSignUpButton()
                .errorMessageGetText()
                .clickEnterLinkButton()
                .signUpUser(email, TestValue.PASSWORD_ERROR)
                .isErrorMessageExist();
        assertTrue(inValidDataRegister);
    }

    @After
    public void tearDown() {
        userClient = new UserClient();
        Credentials credentials = new Credentials(email, password);
        Response response = userClient.login(credentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }

        Credentials userInValidCredentials = new Credentials(email, TestValue.PASSWORD_ERROR);
        Response inValidResponse = userClient.login(userInValidCredentials);
        if (inValidResponse.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(inValidResponse);
        }
    }
}