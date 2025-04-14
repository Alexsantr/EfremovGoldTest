package api.steps;

import api.models.ProductResponseModel;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static api.spec.EfremovGoldSpec.requestSpec;
import static io.restassured.RestAssured.given;

public class CatalogSteps {


    private static final String COMPARE_ENDPOINT = "/api/compare-products/v1";

    @Step("Получить список продуктов для сравнения")
    public List<ProductResponseModel> getProductsForComparison(int productId) {
        Response response = given(requestSpec)
                .when()
                .get(COMPARE_ENDPOINT + "?ids=" + productId);

        return Arrays.asList(response
                .then()
                .statusCode(200)
                .extract()
                .as(ProductResponseModel[].class));
    }

    @Step("Получить первый продукт из списка сравнения")
    public ProductResponseModel getFirstComparedProduct(int productId) {
        return getProductsForComparison(productId).get(0);
    }
}










