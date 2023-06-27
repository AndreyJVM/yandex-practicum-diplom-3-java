import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.page.LoginStellar;
import main.page.RegistrationStellar;
import main.page.TestValue;
import main.page.ExitStellar;
import main.page.DeleteStellar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExitTest extends BaseTest {
    @Before
    @DisplayName("Предусловие. Создать пользователя")
    public void setUp() {
        super.setUp();
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        page.open();
        page.clickButtonPersonalAccount();
        page.clickButtonPersonalAccountRegistration();
        page.inputNameUserRegistration(TestValue.NAME);
        page.inputEmailUserRegistration(TestValue.TEST_LOGIN_ONE);
        page.inputPasswordUserRegistration(TestValue.TEST_PASSWORD_ONE);
        page.clickButtonRegistrationByFullFolder();
        pageLogin.waitForLoadEntrance();
        page.transitionMainPage();
    }

    @After
    @DisplayName("Постусловие.Удаление пользователя")
    public void cleanUp() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        DeleteStellar pageDelete = new DeleteStellar(driver);
        page.open();
        page.transitionMainPage();
        try {
            page.clickButtonPersonalAccount();
            pageLogin.inputEmailLoginAccount(TestValue.TEST_LOGIN_ONE);
            pageLogin.inputPasswordLoginAccount(TestValue.TEST_PASSWORD_ONE);
            pageLogin.clickLoginInAccount();
        } catch (Exception e) {
        }
        pageLogin.waitForInvisibilityLoadingAnimation();
        String accessToken = pageDelete.getTokenAccess();
        if (accessToken != null) {
            pageDelete.deleteUserStellar(accessToken);
        }
        driver.quit();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверить выход по кнопке Выйти в личном кабинете")
    public void checkExitLogin() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        ExitStellar pageExit = new ExitStellar(driver);
        page.open();
        page.clickButtonPersonalAccount();
        pageLogin.inputEmailLoginAccount(TestValue.TEST_LOGIN_ONE);
        pageLogin.inputPasswordLoginAccount(TestValue.TEST_PASSWORD_ONE);
        pageLogin.clickLoginInAccount();
        pageLogin.waitForInvisibilityLoadingAnimation();
        page.clickButtonPersonalAccount();
        pageExit.clickExitAccount();
        pageLogin.waitForInvisibilityLoadingAnimation();
        String expected = "Войти";
        String actual = pageExit.getTextButtonEntrance();
        Assert.assertEquals(expected, actual);
    }
}