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
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("API тесты для интернет-магазина Efremov Gold")
public class EfremovGoldApiTests extends TestBaseApi {

    private static final int TEST_PRODUCT_ID = 32647;
    private static final String EXPECTED_TITLE = "210040002207 Кольцо (Золото 585К)";
    private static final String EXPECTED_PRODUCT_CODE = "210040002207_kolco_zoloto_585k_32647";
    private static final int TEST_GROUP_ID = 252161;
    private static final int EXPECTED_CATEGORY_ID_LENGTH = 3;
    private static final int EXPECTED_PRODUCT_COUNT = 2;


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
    @DisplayName("Проверка данных продукта")
    void checkProductData() {
        ProductResponseModel product = catalogSteps.getFirstComparedProduct(TEST_PRODUCT_ID);

        assertThat(product.getTitle(), equalTo(EXPECTED_TITLE));
        assertThat(String.valueOf(product.getCategoryId()).length(), equalTo(EXPECTED_CATEGORY_ID_LENGTH));
        assertThat(product.getCode(), equalTo(EXPECTED_PRODUCT_CODE));
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    void addProductToCartTest() {
        BasketResponseModel response = basketSteps.addProductToCart(cartToken, TEST_GROUP_ID, EXPECTED_PRODUCT_COUNT);

        assertThat("Количество товаров в корзине не совпадает", response.getTotal().getCount(), equalTo(EXPECTED_PRODUCT_COUNT));

        assertThat("ID группы товаров не совпадает", response.getData().get(0).getProducts().get(0).getGroups().get(0).getId(), equalTo(TEST_GROUP_ID));

    }

    @Test
    @DisplayName("Удаление товара из корзины")
    void removeProductFromCartTest() {

        RemoveFromBasketRequest removeFromBasketRequest = basketSteps.addProductToCartRequest(cartToken, TEST_GROUP_ID, EXPECTED_PRODUCT_COUNT);
        BasketResponseModel response = basketSteps.removeProductsFromCart(removeFromBasketRequest);


        assertThat("Корзина должна быть пустой", response.getData().get(0).getProducts(), empty());

        assertThat("Счетчик товаров должен быть 0", response.getTotal().getProductsCountInBasket(), equalTo(0));
    }

    @Test
    @DisplayName("Добавление нескольких товаров в корзину")
    void addMultipleProductsToCarst() {
        Map<Integer, Integer> productsToAdd = new HashMap<>();
        productsToAdd.put(252997, 1);
        productsToAdd.put(252998, 2);
        productsToAdd.put(253000, 1);
        BasketResponseModel responseModel = basketSteps.addMultipleProductsToCart(cartToken, productsToAdd);


        assertThat("Счетчик товаров должен быть 4", responseModel.getTotal().getCount(), equalTo(4));
    }

    @Test
    @DisplayName("Авторизация не существующего клиента")
    void authUnsuccessfulClent() {
        AuthErrorResponseModel response = authApiSteps.authUnsuccessfulClent("ASDASD@MAIL.RT");
        System.out.println(response);
        assertThat(response.code,equalTo("P_USERS_0002"));
        assertThat(response.message,equalTo("Пользователя с таким e-mail не существует"));


    }
}