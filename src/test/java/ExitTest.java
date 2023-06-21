import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import mainPage.LoginStellar;
import mainPage.RegistrationStellar;
import mainPage.TestValue;
import mainPage.ExitStellar;
import mainPage.DeleteStellar;
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
        page.inputEmailUserRegistration(TestValue.LOGIN);
        page.inputPasswordUserRegistration(TestValue.PASSWORD);
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
            pageLogin.inputEmailLoginAccount(TestValue.LOGIN);
            pageLogin.inputPasswordLoginAccount(TestValue.PASSWORD);
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
        pageLogin.inputEmailLoginAccount(TestValue.LOGIN);
        pageLogin.inputPasswordLoginAccount(TestValue.PASSWORD);
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