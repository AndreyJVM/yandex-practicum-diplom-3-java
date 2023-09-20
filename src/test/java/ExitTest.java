import io.qameta.allure.junit4.DisplayName;
import main.page.SignInPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
/**
 * Проверяем:
 * Выход из личного кабинета через кнопку Выйти
 */
public class ExitTest extends BaseTest {
    @Test
    @DisplayName("Выход из личного кабинета через кнопку Выйти")
    public void logoutUserProfileButtonTest(){
        open(SignInPage.URL_SIGN_IN_PAGE, SignInPage.class)
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .clickAccountButtonAfterAuthorization()
                .clickLogOutButton()
                .isEnterButtonExist();
    }
}