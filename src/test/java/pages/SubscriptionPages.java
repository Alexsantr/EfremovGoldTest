package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
public class SubscriptionPages  {

    @Step("Закрыть всплывающее окно подписки, если оно отобразилось")
    public SubscriptionPages closeSubscriptionPopupIfPresent() {
        SelenideElement popup = $("#normal-slidedown");
        SelenideElement closeButton = $("#onesignal-slidedown-cancel-button");
        try {
            popup.should(Condition.appear, Duration.ofSeconds(12));
            Selenide.sleep(200);
            closeButton.click();
            popup.should(Condition.disappear);
        } catch (Throwable e) {
            System.out.println("Всплывающее окно не появилось в течение 20 секунд. Продолжаем выполнение.");
        }
        return this;
    }
}
