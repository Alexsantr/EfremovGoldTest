package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RingsPages;

@Feature("Каталог колец")
@DisplayName("Кольца")
public class RingsTests extends TestBase {

    RingsPages ringsPages = new RingsPages();

    @Test
    @Story("Проверка страницы каталога")
    @DisplayName("Проверка отображения заголовка страницы каталога колец")
    void checkMainPageTitle() {
        ringsPages
                .openPage()
                .checkTittlePage();
    }

    @Test
    @Story("Функциональность сортировки")
    @DisplayName("Проверка работы сортировки товаров в каталоге колец")
    void checkSortingPage() {
        ringsPages
                .openPage()
                .checkSortingPage();
    }

    @Test
    @Story("Функциональность фильтрации")
    @DisplayName("Проверка работы фильтров в каталоге колец")
    void checkFiltersPage() {
        ringsPages
                .openPage()
                .checkFiltersPage();
    }
}