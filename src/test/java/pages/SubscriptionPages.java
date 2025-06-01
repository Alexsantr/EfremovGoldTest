package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SubscriptionPages {

    @Step("Закрыть всплывающее окно подписки, если оно отобразилось")
    public SubscriptionPages closeSubscriptionPopupIfPresent() {


        SelenideElement popup = $("#normal-slidedown");
        SelenideElement closeButton = $("#onesignal-slidedown-cancel-button");
        try {
            $(".cook-popup__aside").click();
            popup.should(Condition.appear, Duration.ofSeconds(16));
            closeButton.click();

            popup.should(Condition.disappear);
        } catch (Throwable e) {
            System.out.println("Всплывающее окно не появилось в течение 16 секунд. Продолжаем выполнение.");
        }
        return this;
    }
}
