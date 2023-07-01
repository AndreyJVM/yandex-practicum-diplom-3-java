import io.qameta.allure.junit4.DisplayName;
import main.page.MainPage;
import main.page.ResetPasswordPage;
import main.page.SignUpPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginWebTest extends BaseTest {

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void signInButtonMainPageTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickEnterAccountButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .isCreateOrderButtonExist();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void signInButtonUserProfileTest() {

        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickAccountButtonBeforeAuthorization()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .isCreateOrderButtonExist();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void signInButtonSignUpTest() {

        open(SignUpPage.SIGN_UP_PAGE_URL, SignUpPage.class)
                .clickSignUpPageEnterButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .isCreateOrderButtonExist();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void signInButtonResetPasswordTest() {
        open(ResetPasswordPage.RESET_PASSWORD_PAGE_URL, ResetPasswordPage.class)
                .clickResetPasswordButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .isCreateOrderButtonExist();
    }
}