package api.clients;

import api.models.Credentials;
import api.models.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * Configuring the handle for registration, deletion, logging of the user
 */
public class UserClient extends Client {

    private static final String REGISTER = "auth/register/";
    private static final String LOGIN = "auth/login/";
    private static final String DELETE = "auth/user/";

    @Step("Регистрация пользователя")
    public Response createUser(User user) {
        return (Response) given()
                .spec(getSpecSettings())
                .body(user)
                .when()
                .post(REGISTER)
                .then()
                .extract();
    }

    @Step("Логин пользователя")
    public static Response login(Credentials credentials) {
        return (Response) given()
                .spec(getSpecSettings())
                .body(credentials)
                .when()
                .post(LOGIN)
                .then()
                .extract();
    }

    @Step("Удаление пользователя")
    public void delete(Response response) {
        String accessToken = response.body().jsonPath().getString("accessToken");
        if (accessToken == null) {
            return;
        }
        given()
                .spec(getSpecSettings())
                .header("authorization", accessToken)
                .when()
                .delete(DELETE);
    }
}