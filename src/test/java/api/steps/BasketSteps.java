package api.steps;

import api.models.BasketRequestModel;
import api.models.BasketResponseModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BasketSteps {
    private static final String BASE_URL = "https://efremov.gold";
    private static final String BASKET_ENDPOINT = "/api/basket/v1/products";

    @Step("Добавить товары в корзину")
    public BasketResponseModel addToBasket(String basketToken, List<BasketRequestModel.BasketGroup> groups) {
        BasketRequestModel request = new BasketRequestModel();
        request.setBasket(basketToken);
        request.setGroups(groups);
        request.setChange(true);

        Response response = given()
                .baseUri(BASE_URL)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Currency-Id", "1")
                .header("Site-Id", "1")
                .cookie("cart_token_efremov-gold", basketToken)
                .body(request)
                .when()
                .post(BASKET_ENDPOINT);

        return response.then()
                .statusCode(200)
                .extract()
                .as(BasketResponseModel.class);
    }
}