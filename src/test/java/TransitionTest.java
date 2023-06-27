import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import main.page.RegistrationStellar;
import main.page.LoginStellar;
import main.page.Transition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransitionTest extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
        RegistrationStellar page = new RegistrationStellar(driver);
        LoginStellar pageLogin = new LoginStellar(driver);
        page.open();
        page.clickButtonPersonalAccount();
        pageLogin.waitForLoadEntrance();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Переход по клику на Личный кабинет")
    public void transitionByClickPersonalAccount() {
        LoginStellar pageLogin = new LoginStellar(driver);
        String expected = "Вход";
        String actual = pageLogin.getTextEntrance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Переход по клику на Конструктор")
    public void transitionOnConstructor() {
        Transition pageTransition = new Transition(driver);
        pageTransition.clickTransConstructor();
        String expected = "Соберите бургер";
        String actual = pageTransition.getTextCollectBurger();
        Assert.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Переход из личного кабинета на логотип")
    @Description("Переход по клику на логотип")
    public void transitionOnLogo() {
        Transition pageTransition = new Transition(driver);
        pageTransition.clickLogotip();
        String expected = "Соберите бургер";
        String actual = pageTransition.getTextCollectBurger();
        Assert.assertEquals(expected, actual);
    }
}