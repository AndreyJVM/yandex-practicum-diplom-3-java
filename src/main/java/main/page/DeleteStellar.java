package main.page;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

public class DeleteStellar {
    private final WebDriver driver;

    public DeleteStellar(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получить accessToken из Local Storage")
    public String getTokenAccess() {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessTokenWithBearer = localStorage.getItem("accessToken");
        String accessToken = accessTokenWithBearer.replace("Bearer ", "");
        System.out.println(accessToken);
        return accessToken;
    }

    @Step("Отправка HTTP-запроса на удаление пользователя")
    public void deleteUserStellar(String accessToken) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String url = TestValue.URL_DELETE_USER_REQUEST;
        String authHeader = "Authorization: " + accessToken;
        jsExecutor.executeScript("var xhr = new XMLHttpRequest();"
                + "xhr.open('DELETE', '" + url + "', true);"
                + "xhr.setRequestHeader('Authorization', '" + authHeader + "');"
                + "xhr.send();");
    }
}
