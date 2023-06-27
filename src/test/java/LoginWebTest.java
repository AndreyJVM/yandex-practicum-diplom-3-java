import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.page.DeleteStellar;
import main.page.LoginStellar;
import main.page.RegistrationStellar;
import main.page.TestValue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginWebTest extends BaseTest {

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
    @DisplayName("Вход по кнопке Войти в аккаунт ")
    @Description("С главной страницы")
    public void loginInAccountMainPage() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        pageLogin.clickButtonEntranceMainPage();
        pageLogin.inputEmailLoginAccount(TestValue.TEST_LOGIN_ONE);
        pageLogin.inputPasswordLoginAccount(TestValue.TEST_PASSWORD_ONE);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт через личный кабинет ")
    @Description("Вход через личный кабинет")
    public void loginInAccount() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        page.clickButtonPersonalAccount();
        pageLogin.inputEmailLoginAccount(TestValue.TEST_LOGIN_ONE);
        pageLogin.inputPasswordLoginAccount(TestValue.TEST_PASSWORD_ONE);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Через форму регистрации, после того как нажать зарегистрировать")
    public void loginThroughFormRegistration() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        pageLogin.clickButtonPersonalAccount();
        page.clickButtonPersonalAccountRegistration();
        pageLogin.clickButtonRegAfterPersonalAccount();
        pageLogin.inputEmailLoginAccount(TestValue.TEST_LOGIN_ONE);
        pageLogin.inputPasswordLoginAccount(TestValue.TEST_PASSWORD_ONE);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Нажать войти -> Восстановить пароль")
    public void loginThroughRecoveryPassword() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        pageLogin.clickButtonEntranceMainPage();
        pageLogin.clickResoveryPassword();
        pageLogin.clickEntranceAfterClickRecoveryPassword();
        pageLogin.inputEmailLoginAccount(TestValue.TEST_LOGIN_ONE);
        pageLogin.inputPasswordLoginAccount(TestValue.TEST_PASSWORD_ONE);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }
}