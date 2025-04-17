package tests.web;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BraceletsPages;

@Tag("UI_Tests")
@DisplayName("Каталог браслетов")
public class BraceletsTests extends TestBase {

    BraceletsPages braceletsPages = new BraceletsPages();

    @Test
    @Story("Навигация")
    @DisplayName("Проверка заголовка главной страницы")
    void checkMainPageTitle() {

        braceletsPages.openPage().checkTittlePage();

    }

    @Test
    @Story("Навигация")
    @DisplayName("Проверка работы сортировки")
    void checkSortingPage() {

        braceletsPages.openPage().checkSortingPage();

    }

    @Test
    @Story("Навигация")
    @DisplayName("Проверка работы фильтра")
    void checkFiltersPage() {

        braceletsPages.openPage().checkFiltersPage();

    }
}
