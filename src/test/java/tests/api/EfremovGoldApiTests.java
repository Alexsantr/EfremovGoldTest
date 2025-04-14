package tests.api;

import api.models.BasketRequestModel;
import api.models.BasketResponseModel;
import api.models.ProductResponseModel;
import api.steps.BasketSteps;
import api.steps.CartTokenStep;
import api.steps.CatalogSteps;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class EfremovGoldApiTests extends TestBaseApi {
    private final BasketSteps basketSteps = new BasketSteps();
    private final CartTokenStep tokenStep = new CartTokenStep();
    String token = String.valueOf(tokenStep.getCartToken());
    private static final int TEST_PRODUCT_ID = 32647;
    private static final String EXPECTED_TITLE = "210040002207 Кольцо (Золото 585К)";
    private final CatalogSteps catalogSteps = new CatalogSteps();
    private static final String Code ="210040002207_kolco_zoloto_585k_32647";


    @Test
    public void CheckProductTittle() {
        ProductResponseModel responseModel = catalogSteps.getFirstComparedProduct(TEST_PRODUCT_ID);
        assertThat("Заголовок продукта не соответствует ожидаемому",
                responseModel.getTitle(),equalTo(EXPECTED_TITLE));
        assertThat("categoryId должен состоять из 3 цифр",
                String.valueOf(responseModel.getCategoryId()).length(),
                equalTo(3));
        assertThat("Заголовок дискрипшен не соответствует ожидаемому",
                responseModel.getCode(),equalTo(Code));


    }

    private static final int TEST_GROUP_ID = 252161; // ID товарной группы



    @Test
    public void addProductToBasket_shouldSuccess() {
        // Подготовка данных
        BasketRequestModel.BasketGroup group = new BasketRequestModel.BasketGroup();
        group.setId(TEST_GROUP_ID);
        group.setCount(1); // Добавляем 1 товар

        List<BasketRequestModel.BasketGroup> groups = Collections.singletonList(group);

        // Выполнение запроса
        BasketResponseModel response = basketSteps.addToBasket(token, groups);

        // Проверки
        assertThat("Запрос должен быть успешным",
                response.isSuccess(), is(true));

        assertThat("Сообщение об успешном добавлении",
                response.getMessage(), not(emptyOrNullString()));

        assertThat("Должна увеличиться общая сумма",
                response.getData().getTotalPrice(), greaterThan(0.0));

        assertThat("Должно увеличиться количество товаров",
                response.getData().getTotalCount(), equalTo(1));
    }



}
