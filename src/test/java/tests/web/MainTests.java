package tests.web;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPages;

@Tag("UI_Tests")
@DisplayName("Главная страница")
public class MainTests extends TestBase {

    MainPages mainPages = new MainPages();

    @Test
    @Story("Базовые элементы")
    @DisplayName("Проверка отображения заголовка главной страницы")
    void checkMainPageTitle() {
        mainPages.openMainPage().checkTittleMain();
    }

    @Test
    @Story("Поиск")
    @DisplayName("Проверка функциональности поиска изделий")
    void checkSearchProduct() {
        mainPages.openMainPage().checkSearchProduct();
    }

    @Test
    @Story("Блок новинок")
    @DisplayName("Проверка текста блока новинок")
    void checkNewProduct() {
        mainPages.openMainPage().checkNewProduct();
    }

    @Test
    @Story("Каталог")
    @DisplayName("Проверка отображения и структуры каталога")
    void checkCatalog() {
        mainPages.openMainPage().openCatallogPage().checkCatalog();
    }

    @Test
    @Story("Каталог")
    @DisplayName("Проверка корректности ссылок в каталоге")
    void catalogLinksShouldBeCorrect() {
        mainPages.openMainPage().openCatallogPage().catalogLinksShouldBeCorrect();
    }

    @Test
    @Story("Каталог")
    @DisplayName("Проверка отображения иконок в спецразделах каталога")
    void specialSectionsShouldHaveIcons() {
        mainPages
                .openMainPage()
                .openCatallogPage()
                .specialSectionsShouldHaveIcons();
    }
}