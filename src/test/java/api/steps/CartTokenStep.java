package api.steps;

import io.qameta.allure.Step;
import io.restassured.http.Cookies;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class CartTokenStep {

    @Step("Получить cart_token из cookies ответа")
    public String getCartTokenFromCookies() {
        Cookies cookies = given().when().get("").then().extract().detailedCookies();
        return cookies.getValue("cart_token_efremov-gold");


    }
}