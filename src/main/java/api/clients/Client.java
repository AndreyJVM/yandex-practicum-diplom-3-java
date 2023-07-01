package api.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * Класс содержит ссылку на тестируемый сайт и настройку RestAssured
 */
public class Client {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static RequestSpecification getSpecSettings() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL + "api/")
                .build();
    }
}