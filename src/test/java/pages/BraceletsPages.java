package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class BraceletsPages {
    SubscriptionPages subscriptionPages = new SubscriptionPages();


    @Step("Открытие страницы")
    public BraceletsPages openPage() {

        open("/catalog/braslet");
        subscriptionPages.closeSubscriptionPopupIfPresent();

        return this;
    }

    @Step("Проверка заголовка страницы Браслеты")
    public BraceletsPages checkTittlePage() {

        $("[  class=\"catalog-header__title\"]").shouldHave(text("Браслеты"));
        return this;
    }

    @Step("Проверка работы сортировки")
    public BraceletsPages checkSortingPagePriceAscending() {
        $(".sort").click();
        $$(".sort-popup__item").findBy(text("По возрастанию цены")).click();
        return this;
    }

    @Step("Проверка работы сортировки")
    public BraceletsPages checkSortingPagePriceDescending() {
        $(".sort-title").click();
        $$(".sort-popup__item").findBy(text("По убыванию цены")).click();
        return this;
    }

    @Step("Проверка работы сортировки")
    public BraceletsPages checkSortingPagePopular() {
        $(".sort-title").click();
        $$(".sort-popup__item").findBy(text("По популярности")).click();
        return this;
    }

    @Step("Проверка работы фильтра")
    public BraceletsPages checkFiltersPage(int size) {

        $(".filter-button").click();
        $$(".balloon").shouldHave(sizeLessThan(size));

        return this;
    }

    @Step("Установка фильтра 'Тип изделия'")
    public BraceletsPages choiceFiltersPageBracelet() {

        $$(".filter-item__list a").findBy(text("Браслет")).click();
        return this;
    }

    @Step("Установка фильтра'Бренд'")
    public BraceletsPages choiceFiltersPageBrand() {

        $$(".filter-item__list div.checkbox").findBy(text("Efremov")).click();
        return this;
    }


}
