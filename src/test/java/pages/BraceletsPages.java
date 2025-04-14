package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class BraceletsPages {

    private static final String BASE_URL = "/catalog/braslet";


    @Step("Открытие страницы")
    public BraceletsPages openPage() {

        open("" + BASE_URL);
        return this;
    }

    @Step("Проверка заголока страницы Браслеты")
    public BraceletsPages checkTittlePage() {

        $("[  class=\"catalog-header__title\"]").shouldHave(text("Браслеты"));
        return this;
    }

    @Step("Проверка работы сортировки")
    public BraceletsPages checkSortingPage() {
        $(".sort").click();
        $$(".sort-popup__item").findBy(text("По возрастанию цены")).click();
        $(".sort-title").click();
        $$(".sort-popup__item").findBy(text("По убыванию цены")).click();
        $(".sort-title").click();
        $$(".sort-popup__item").findBy(text("По популярности")).click();
        return this;
    }

    @Step("Проверка работы сортировки")
    public BraceletsPages checkFiltersPage() {

        $$(".filter-item__list a").findBy(text("Браслет")).click();
        $$(".filter-item__list div.checkbox").findBy(text("Efremov")).click();
        $(".filter-button").click();
        $$(".balloon").shouldHave(sizeLessThan(4));

        return this;
    }


}
