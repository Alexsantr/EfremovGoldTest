package api.steps;

import api.models.BasketRequestModel;
import api.models.BasketResponseModel;
import api.models.RemoveFromBasketRequest;
import io.qameta.allure.Step;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static api.spec.EfremovGoldSpec.requestSpec;
import static api.spec.EfremovGoldSpec.statusCode200Spec;
import static io.restassured.RestAssured.given;

public class BasketSteps {
    @Step("Добавить товар в корзину для дальнейшего удаления")
    public RemoveFromBasketRequest addProductToCartRequest(String cartToken, int productId, int quantity) {

        BasketRequestModel.BasketGroup group = new BasketRequestModel.BasketGroup();
        group.setId(productId);
        group.setCount(quantity);


        BasketRequestModel requestBody = new BasketRequestModel();
        requestBody.setBasket(cartToken);
        requestBody.setGroups(List.of(group));
        requestBody.setChange(true);

        BasketResponseModel responseModel = given(requestSpec).body(requestBody).when().post("api/basket/v1/products").then().extract().as(BasketResponseModel.class);

        RemoveFromBasketRequest removeFromBasketRequest = new RemoveFromBasketRequest();
        removeFromBasketRequest.setBasket(cartToken);
        removeFromBasketRequest.setGroupIds(Collections.singletonList(responseModel.getData().get(0).getProducts().get(0).getGroups().get(0).getId()));
        removeFromBasketRequest.setNotInStock(false);

        return removeFromBasketRequest;
    }

    @Step("Добавить товар в корзину")
    public BasketResponseModel addProductToCart(String cartToken, int productId, int quantity) {
        BasketRequestModel.BasketGroup group = new BasketRequestModel.BasketGroup();
        group.setId(productId);
        group.setCount(quantity);
        BasketRequestModel requestBody = new BasketRequestModel();
        requestBody.setBasket(cartToken);
        requestBody.setGroups(Collections.singletonList(group));
        requestBody.setChange(true);

        return given(requestSpec).body(requestBody).when().post("/api/basket/v1/products").then().spec(statusCode200Spec).extract().as(BasketResponseModel.class);


    }


    @Step("Удалить товары из корзины")
    public BasketResponseModel removeProductsFromCart(RemoveFromBasketRequest removeFromBasketRequest) {
        return given(requestSpec).body(removeFromBasketRequest).when().delete("api/basket/v1/products").then().extract().as(BasketResponseModel.class);

    }


    @Step("Добавить несколько товаров в корзину")
    public BasketResponseModel addMultipleProductsToCart(String cartToken, Map<Integer, Integer> products) {

        List<BasketRequestModel.BasketGroup> groups = products.entrySet().stream().map(entry -> {
            BasketRequestModel.BasketGroup group = new BasketRequestModel.BasketGroup();
            group.setId(entry.getKey());
            group.setCount(entry.getValue());
            return group;
        }).collect(Collectors.toList());

        BasketRequestModel requestBody = new BasketRequestModel();
        requestBody.setBasket(cartToken);
        requestBody.setGroups(groups);
        requestBody.setChange(true);

        return given(requestSpec).body(requestBody).when().post("/api/basket/v1/products").then().spec(statusCode200Spec).extract().as(BasketResponseModel.class);
    }
}