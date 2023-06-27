package main.page;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorSectionStellar {
    private final WebDriver driver;

    public ConstructorSectionStellar(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка перехода конструктора в раздел Соусы:
    private static final By BUTTON_TRANS_SAUCE_CONSTRUCTOR = By.xpath("//span[text()='Соусы']");
    //кнопка перехода конструктора в раздел Начинки:
    private static final By BUTTON_TRANS_FILING_CONSTRUCTOR = By.xpath("//span[text()='Начинки']");
    //кнопка перехода конструктора в раздел Булки:
    private static final By BUTTON_TRANS_BUN_CONSTRUCTOR = By.xpath("//span[text()='Булки']");

    private static final By VISIBILITY_SECTION_CONSTRUCTOR_SAUCE = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Соусы']");

    //видимый раздел Начинки:
    private static final By VISIBILITY_SECTION_CONSTRUCTOR_FILING = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Начинки']");

    //видимый раздел Булки:
    private static final By VISIBILITY_SECTION_CONSTRUCTOR_BUN = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Булки']");

    @Step("Выбор раздела Соусы")
    public void selectSectionConstructorSauce() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_TRANS_SAUCE_CONSTRUCTOR));
        driver.findElement(BUTTON_TRANS_SAUCE_CONSTRUCTOR).click();
    }

    @Step("Выбор раздела Начинки")
    public void selectSectionConstructorFiling() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_TRANS_FILING_CONSTRUCTOR));
        driver.findElement(BUTTON_TRANS_FILING_CONSTRUCTOR).click();
    }

    @Step("Выбор раздела Булки")
    public void selectSectionConstructorBun() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_TRANS_BUN_CONSTRUCTOR));
        driver.findElement(BUTTON_TRANS_BUN_CONSTRUCTOR).click();
    }

    @Step("Проверка на видимость раздела Начинки в самом конструкторе")
    public boolean checkSectionFiling() {
        return driver.findElement(VISIBILITY_SECTION_CONSTRUCTOR_FILING).isDisplayed();
    }

    @Step("Проверка на видимость раздела Соусы в самом конструкторе")
    public boolean checkSectionSauce() {
        return driver.findElement(VISIBILITY_SECTION_CONSTRUCTOR_SAUCE).isDisplayed();
    }

    @Step("Проверка на видимость раздела Булки в самом конструкторе")
    public boolean checkSectionBun() {
        return driver.findElement(VISIBILITY_SECTION_CONSTRUCTOR_BUN).isDisplayed();
    }
}