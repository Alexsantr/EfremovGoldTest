package tests.web;


import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.RingsPages;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Каталог колец")
public class RingsTests extends TestBase {
    RingsPages ringsPages = new RingsPages();

    @Test
    @Story("Проверка страницы каталога")
    @DisplayName("Проверка отображения заголовка страницы каталога колец")
    void checkMainPageTitle() {
        ringsPages.openPage().checkTittlePage();

    }

    @Test
    @Order(1)
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
    @Story("Функциональность добаления товара в корзину")
    @DisplayName("Проверка добавления товара в корзину")
    void addProduct() {
        ringsPages.openPage().addProduct();
    }

    @Test
    @Story("Функциональность добаления товара в корзину")
    @DisplayName("Проверка добавления товара в корзину")
    void deleteProductInBasket() {
        ringsPages.openPage().addProduct().deleteProductInBasket();
    }


}