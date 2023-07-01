package main.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    public static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //Локаторы
    //Кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']") //
    private SelenideElement enterAccountButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Оформить заказ')]") //
    private SelenideElement createOrderButton;

    //Кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']") //
    private SelenideElement accountButton;;

    //Заголовок Соберите бургер
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    private SelenideElement constructorHeader;

    // Раздел Булки
    @FindBy(how = How.XPATH, using = "//div[span[text()='Булки']]")
    private SelenideElement bunsButton;

    // Раздел Соусы
    @FindBy(how = How.XPATH, using = "//div[span[text()='Соусы']]")
    private SelenideElement sauceButton;

    //Раздел Начинки
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement fillingsButton;

    //Заголовки
    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    private SelenideElement bunsHeader;

    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    private SelenideElement sauceHeader;

    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    private SelenideElement fillingsHeader;

    //Наименования класса  после выбора раздела
    @FindBy(how = How.CLASS_NAME, using = "tab_tab_type_current__2BEPc")
    private SelenideElement sectionIngredients;

    @FindBy(how = How.XPATH, using = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']")
    private SelenideElement constructorContainer;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement errorMessage;

    @Step("Клик по кнопке Войти в аккаунт")
    public SignInPage clickEnterAccountButton() {
        enterAccountButton.click();
        return page(SignInPage.class);
    }

    @Step("Проверка кнопки Оформить заказ")
    public boolean isCreateOrderButtonExist() {
        createOrderButton.shouldBe(Condition.visible);
        return createOrderButton.exists();
    }

    @Step("Клик по кнопке Личного кабинета до авторизации")
    public SignInPage clickAccountButtonBeforeAuthorization() {
        accountButton.click();
        return page(SignInPage.class);
    }

    @Step("Клик по кнопке Личного кабинета после авторизации")
    public UserProfilePage clickAccountButtonAfterAuthorization() {
        accountButton.click();
        return page(UserProfilePage.class);
    }

    @Step("Проверка заголовка Конструктор")
    public boolean isConstructorHeaderExist() {
        return constructorHeader.exists();
    }

    @Step("Клик по кнопке Булки в конструторе")
    public MainPage clickBunsButton() {
        bunsButton.click();
        return this;
    }

    @Step("Клик по кнопке соусы в конструкторе")
    public MainPage clickSaucesButton() {
        sauceButton.click();
        return this;
    }

    @Step("Клик по кнопке Начинки в конструкторе")
    public MainPage clickFillingsButton() {
        fillingsButton.click();
        return this;
    }

    @Step("Проверка появления заголовка Булки")
    public boolean isBunsHeaderIsDisplayed() {
        return sectionIngredients.getText().contentEquals("Булки");
    }

    @Step("Проверка появления заголовка Соусы")
    public boolean isSaucesHeaderIsDisplayed() {
        return sectionIngredients.getText().contentEquals("Соусы");
    }

    @Step("Проверка появления заголовка Начинки")
    public boolean isFillingsHeaderIsDisplayed() {
        return sectionIngredients.getText().contentEquals("Начинки");
    }

    @Step("Скролл до заголовка Булки")
    public MainPage scrollToBunsHeader() {
        constructorContainer.click();
        bunsHeader.scrollIntoView(false);
        return this;
    }

    @Step("Скролл до заголовка Соусы")
    public MainPage scrollToSaucesHeader() {
        constructorContainer.click();
        sauceHeader.scrollIntoView(false);
        return this;
    }

    @Step("Скролл до заголовка Начинки")
    public MainPage scrollToFillingsHeader() {
        constructorContainer.click();
        fillingsHeader.scrollIntoView(false);
        return this;
    }

    @Step("Загрузка конструктора")
    public MainPage constructionShouldBeVisible() {
        constructorContainer.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка сообщения об ошибке")
    public boolean isErrorMessageExist() {
        return errorMessage.exists();
    }
}