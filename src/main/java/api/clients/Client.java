package api.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * The class contains a link to the site under test and the RestAssured setting
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