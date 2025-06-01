package pages;


import io.qameta.allure.Step;


import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class RingsPages extends SubscriptionPages {
    SubscriptionPages subscriptionPages = new SubscriptionPages();

    @Step("Открытие страницы")
    public RingsPages openPage() {
        open("/catalog/kolco");
        subscriptionPages.closeSubscriptionPopupIfPresent();
        return this;
    }

    @Step("Проверка заголовка страницы Кольца")
    public RingsPages checkTittlePage() {

        $("[  class=\"catalog-header__title\"]").shouldHave(text("Кольца"));
        return this;
    }

    @Step("Проверка работы сортировки")
    public RingsPages checkSortingPage() {
        $(".catalog-navigation").click();
        $$(".sort-popup__item").findBy(text("По возрастанию цены")).click();
        $(".sort-title").click();
        $$(".sort-popup__item").findBy(text("По убыванию цены")).click();
        $(".sort-title").click();
        $$(".sort-popup__item").findBy(text("По популярности")).click();
        return this;
    }

    @Step("Проверка работы фильтра ")
    public RingsPages checkFiltersPage() {

        $$(".filter-item__list a").findBy(text("Кольцо")).click();
        $$(".filter-item__list div.checkbox").findBy(text("Efremov")).click();
        $$(".filter-item__list div.checkbox").findBy(text("Детей")).click();
        $("[class=filter-button]").click();
        $$(".balloon").shouldHave(sizeLessThan(5));

        return this;
    }

    @Step("Добавление товара в корзину")
    public RingsPages addProduct() {
        $$("[data-link=product]").first().click();
        $("[data-button=add-to-cart]").shouldBe(text("Добавить в корзину")).click();
        $$(".header-user__count").findBy(text("1")).shouldBe(visible);

        return this;
    }


}

