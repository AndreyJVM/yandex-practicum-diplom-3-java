import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import mainPage.LoginStellar;
import mainPage.RegistrationStellar;
import mainPage.TestValue;
import mainPage.DeleteStellar;

public class RegistrationWebTest extends BaseTest {
    @Test
    @DisplayName("Регистрация пользователя - успешная")
    @Description("Успешная регистрация пользователя")
    public void checkSuccessRegistrationPersonalAccountButton() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        DeleteStellar pageDelete = new DeleteStellar(driver);
        page.open();
        page.clickButtonPersonalAccount();
        page.clickButtonPersonalAccountRegistration();
        page.inputNameUserRegistration(TestValue.NAME);
        page.inputEmailUserRegistration(TestValue.LOGIN);
        page.inputPasswordUserRegistration(TestValue.PASSWORD);
        page.clickButtonRegistrationByFullFolder();
        pageLogin.waitForLoadEntrance();
        boolean actual = driver.findElement(LoginStellar.TITLE_ENTRANCE).isDisplayed();
        System.out.println(actual);
        Assert.assertTrue(actual);
        page.clickButtonPersonalAccount();
        pageLogin.inputEmailLoginAccount(TestValue.LOGIN);
        pageLogin.inputPasswordLoginAccount(TestValue.PASSWORD);
        pageLogin.clickLoginInAccount();
        pageLogin.waitForInvisibilityLoadingAnimation();
        String accessToken = pageDelete.getTokenAccess();
        if (accessToken != null) {
            pageDelete.deleteUserStellar(accessToken);
        }

    }

    @Test
    @DisplayName("Регистрация пользователя - некорректная")
    @Description("Ошибку для некорректного пароля. Минимальный пароль — шесть символов")
    public void checkErrorRegistrationStellar() {
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        page.open();
        page.clickButtonPersonalAccount();
        page.clickButtonPersonalAccountRegistration();
        page.inputNameUserRegistration(TestValue.NAME);
        page.inputEmailUserRegistration(TestValue.LOGIN);
        page.inputPasswordUserRegistration(TestValue.PASSWORD_ERROR);
        page.clickButtonRegistrationByFullFolder();
        String actual = page.getTextIncorrectPass();
        System.out.println(actual);
        String expected = "Некорректный пароль";
        Assert.assertEquals(expected, actual);
    }
}
