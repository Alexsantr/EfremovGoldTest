package tests.web;


import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.BasketPage;
import pages.RingsPages;

@Tag("UI_Tests")
@DisplayName("Каталог колец")
public class RingsTests extends TestBase {
    RingsPages ringsPages = new RingsPages();
    BasketPage basketPage = new BasketPage();

    @Test
    @Story("Проверка страницы каталога")
    @DisplayName("Проверка отображения заголовка страницы каталога колец")
    void checkMainPageTitle() {
        ringsPages.openPage().checkTittlePage();

    }

    @Test
    @Story("Проверка страницы каталога")
    @DisplayName("Проверка отображения заголовка страницы каталога колец")
    void checkaMainPageTitle() {
        ringsPages.openPage().closeSubscriptionPopupIfPresent();

    }

    @Test
    @Story("Функциональность сортировки")
    @DisplayName("Проверка работы сортировки товаров в каталоге колец")
    void checkSortingPage() {
        ringsPages.openPage().checkSortingPage();

    }

    @Test
    @Story("Функциональность фильтрации")
    @DisplayName("Проверка работы фильтров в каталоге колец")
    void checkFiltersPage() {
        ringsPages.openPage().checkFiltersPage();
    }

    @Test
    @Story("Функциональность добавления товара в корзину")
    @DisplayName("Проверка добавления товара в корзину")
    void addProduct() {
        ringsPages.openPage().addProduct();
        basketPage
                .checkRroductInBasket();
    }

    @Test
    @Story("Функциональность удаление товара из корзину")
    @DisplayName("Проверка удаление товара из корзину")
    void deleteProductInBasket() {

        ringsPages
                .openPage()
                .addProduct();
        basketPage
                .checkRroductInBasket()
                .deleteProductInBasket();

    }


}