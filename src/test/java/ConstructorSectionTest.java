import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import mainPage.ConstructorSectionStellar;
import mainPage.RegistrationStellar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstructorSectionTest extends BaseTest {
    @Before
    public void setUp() {
        super.setUp();
        RegistrationStellar page = new RegistrationStellar(driver);
        page.open();
    }

    @Test
    @DisplayName("Проверка перехода раздела Соусы в  конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionSauce() {
        ConstructorSectionStellar pageSection = new ConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorSauce();
        Boolean excepted = true;
        Boolean actual = pageSection.checkSectionSauce();
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Проверка перехода раздела Начинки в  конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionFiling() {
        ConstructorSectionStellar pageSection = new ConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorFiling();
        Boolean excepted = true;
        Boolean actual = pageSection.checkSectionFiling();
        Assert.assertEquals(excepted, actual);
    }

    @Test
    @DisplayName("Проверка перехода раздела Булки в конструкторе")
    @Description("Проверка на наличие надписи")
    public void checkTransitionBun() {
        ConstructorSectionStellar pageSection = new ConstructorSectionStellar(driver);
        pageSection.selectSectionConstructorSauce();
        pageSection.selectSectionConstructorBun();
        Boolean excepted = true;
        Boolean actual = pageSection.checkSectionBun();
        Assert.assertEquals(excepted, actual);
    }
}