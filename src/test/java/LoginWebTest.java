import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import mainPage.DeleteStellar;
import mainPage.LoginStellar;
import mainPage.RegistrationStellar;
import mainPage.TestValue;
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
    @DisplayName("Вход по кнопке Войти в аккаунт ")
    @Description("С главной страницы")
    public void loginInAccountMainPage() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        pageLogin.clickButtonEntranceMainPage();
        pageLogin.inputEmailLoginAccount(TestValue.LOGIN);
        pageLogin.inputPasswordLoginAccount(TestValue.PASSWORD);
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
        pageLogin.inputEmailLoginAccount(TestValue.LOGIN);
        pageLogin.inputPasswordLoginAccount(TestValue.PASSWORD);
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
        pageLogin.inputEmailLoginAccount(TestValue.LOGIN);
        pageLogin.inputPasswordLoginAccount(TestValue.PASSWORD);
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
        pageLogin.inputEmailLoginAccount(TestValue.LOGIN);
        pageLogin.inputPasswordLoginAccount(TestValue.PASSWORD);
        pageLogin.clickLoginInAccount();
        String actual = pageLogin.getTextPlaceOnOrder();
        System.out.println(actual);
        String excepted = "Оформить заказ";
        Assert.assertEquals(excepted, actual);
    }
}