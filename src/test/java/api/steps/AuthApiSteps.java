package api.steps;

import api.models.AuthErrorResponseModel;
import api.models.AuthRequestModel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static api.spec.BaseSpec.requestSpec;
import static api.spec.BaseSpec.statusCode404Spec;
import static io.restassured.RestAssured.given;


public class AuthApiSteps {
    @Step
    @DisplayName("Авторизация не существующего клиента")
    public AuthErrorResponseModel authUnsuccessfulClent(String mail) {
        AuthRequestModel requestBody = new AuthRequestModel();
        requestBody.setEmail(mail);
        return given(requestSpec)
                .body(requestBody)
                .when()
                .post("api/users/v1/password/send-temp")
                .then()
                .spec(statusCode404Spec)
                .extract()
                .as(AuthErrorResponseModel.class);
    }

}
