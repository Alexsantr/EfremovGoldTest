package tests.api;

import api.models.AuthErrorResponseModel;
import api.models.BasketResponseModel;
import api.models.ProductResponseModel;
import api.models.RemoveFromBasketRequest;
import api.steps.AuthApiSteps;
import api.steps.BasketSteps;
import api.steps.CartTokenStep;
import api.steps.CatalogSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("API_Tests")
@DisplayName("API тесты для интернет-магазина Efremov Gold")
public class EfremovGoldApiTests extends TestBaseApi {

    private final BasketSteps basketSteps = new BasketSteps();
    private final CartTokenStep tokenStep = new CartTokenStep();
    private final CatalogSteps catalogSteps = new CatalogSteps();
    private final AuthApiSteps authApiSteps = new AuthApiSteps();
    private String cartToken;

    @BeforeEach
    void setUp() {
        cartToken = tokenStep.getCartTokenFromCookies();
    }

    @Test
    @DisplayName("Проверка данных списка товара 'колец'")
    void checkProductData() {
        ProductResponseModel product =
                catalogSteps.getFirstComparedProduct(TestData.TEST_PRODUCT_ID);

        assertThat(product.getTitle(),
                equalTo(TestData.EXPECTED_TITLE));
        assertThat(String.valueOf(product.getCategoryId()).length(),
                equalTo(TestData.EXPECTED_CATEGORY_ID_LENGTH));
        assertThat(product.getCode(),
                equalTo(TestData.EXPECTED_PRODUCT_CODE));
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void addProductToCartTest() {
        BasketResponseModel response =
                basketSteps.addProductToCart(
                        cartToken,
                        TestData.TEST_GROUP_ID,
                        TestData.EXPECTED_PRODUCT_COUNT);

        assertThat("Количество товаров в корзине не совпадает",
                response.getTotal().getCount(),
                equalTo(TestData.EXPECTED_PRODUCT_COUNT));

        assertThat("ID группы товаров не совпадает",
                response.getData().get(0).getProducts().get(0).getGroups().get(0).getId(),
                equalTo(TestData.TEST_GROUP_ID));
    }

    @Test
    @DisplayName("Удаление товара из корзины")
    void removeProductFromCartTest() {
        RemoveFromBasketRequest removeFromBasketRequest =
                basketSteps.addProductToCartRequest(
                        cartToken,
                        TestData.TEST_GROUP_ID,
                        TestData.EXPECTED_PRODUCT_COUNT);

        BasketResponseModel response =
                basketSteps.removeProductsFromCart(removeFromBasketRequest);

        assertThat("Корзина должна быть пустой",
                response.getData().get(0).getProducts(),
                empty());

        assertThat("Счетчик товаров должен быть 0",
                response.getTotal().getProductsCountInBasket(),
                equalTo(0));
    }

    @Test
    @DisplayName("Добавление нескольких товаров в корзину")
    void addMultipleProductsToCart() {
        BasketResponseModel responseModel =
                basketSteps.addMultipleProductsToCart(
                        cartToken,
                        TestData.Products.MULTIPLE_PRODUCTS);

        assertThat("Счетчик товаров должен быть 4",
                responseModel.getTotal().getCount(),
                equalTo(4));
    }

    @Test
    @DisplayName("Авторизация не существующего клиента")
    void authUnsuccessfulClient() {
        AuthErrorResponseModel response =
                authApiSteps.authUnsuccessfulClent(TestData.Auth.INVALID_EMAIL);

        assertThat(response.code,
                equalTo(TestData.Auth.EXPECTED_ERROR_CODE));
        assertThat(response.message,
                equalTo(TestData.Auth.EXPECTED_ERROR_MESSAGE));
    }
}