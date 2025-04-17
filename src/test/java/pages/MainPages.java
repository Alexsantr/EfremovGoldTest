package pages;

import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPages {
    SubscriptionPages subscriptionPages =new SubscriptionPages();

    @Step("Открыть главную страницу Efremov")
    public MainPages openMainPage() {
        open("");
        subscriptionPages.closeSubscriptionPopupIfPresent();
        return this;
    }

    @Step("Открытие каталога")
    public MainPages openCatallogPage() {
        $("[class=menu-item]").click();
        return this;
    }

    @Step("Проверка каталога")
    public MainPages checkCatalog() {

        List<String> expectedSections = List.of(
                "Все товары", "Кольца", "Серьги", "Подвески", "Броши",
                "Браслеты", "Кресты", "Колье", "Аксессуары"
        );
        expectedSections.forEach(section -> $$(".menu-popup__item").findBy(text(section)).shouldBe(visible));
        return this;
    }


    @Step("Проверка корректности ссылок в каталоге на разделы ")
    public MainPages catalogLinksShouldBeCorrect() {

        $("a[href='/catalog/kolco']").shouldHave(attribute("href", "https://efremov.gold/catalog/kolco"));
        $("a[href='/catalog/sergi']").shouldHave(attribute("href", "https://efremov.gold/catalog/sergi"));
        $("a[href='/catalog/braslet']").shouldHave(attribute("href", "https://efremov.gold/catalog/braslet"));

        return this;
    }

    @Step("Проверка отображения иконок у спец разделов в каталоге")
    public MainPages specialSectionsShouldHaveIcons() {

        $(".garniture").shouldBe(visible);
        $(".novelties").shouldBe(visible);
        $(".stock").shouldBe(visible);
        return this;
    }

    @Step("Проверка новинок изделий")
    public MainPages checkNewProduct() {
        $$(".head-title").get(1).shouldHave(text("новинки изделий "));


        return this;
    }

    @Step("Проверка заголовка")
    public MainPages checkTittleMain() {
        $("[class=category-header__text]").shouldHave(text(" Огромный выбор ювелирных украшений, выполненных из классического красного, модного белого и авангардного лимонного золота. Кроме того, в ассортименте EFREMOV есть модели, в которых сочетаются сразу несколько видов этого драгоценного металла! "));

        return this;
    }

    @Step("Проверка поиска изделий ")
    public MainPages checkSearchProduct() {
        $("[data-toggle=search]").click();
        $(".header-search__input").setValue("212000002622");
        $(".element-bottom").shouldHave(text("Серьги из красного золота 585 пробы 212000002622"));

        return this;
    }

}
