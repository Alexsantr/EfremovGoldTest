package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasketPage {


    public BasketPage deleteProductInBasket() {
        $$("[type=\"button\"]").findBy(text("Очистить корзину")).click();
        $$(".btn ").findBy(text(" Да, я хочу очистить корзину ")).click();
        $(".complete-title").shouldBe(text(" В корзине пусто "));
        $(".complete-text").shouldBe(text(" Воспользуйтесь каталогом, чтобы добавить понравившийся товар в корзину "));
        return this;
    }


    public BasketPage checkRroductInBasket() {
        $("[href=\"/cart\"]").click();
        $$("[class=box-title]").findBy(text("Товары в заказе")).shouldBe(visible);
        return this;
    }


}
