package api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static api.spec.EfremovGoldSpec.requestSpec;
import static api.spec.EfremovGoldSpec.statusCode200Spec;
import static io.restassured.RestAssured.given;

public class CartTokenStep {
    // Глобальная thread-safe переменная для хранения токена
    private static final Map<String, String> GLOBAL_COOKIES = new ConcurrentHashMap<>();

    // Локальная переменная экземпляра
    private Map<String, String> instanceCookies;

    @Step("Получить cart_token")
    public Map<String, String> getCartToken() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/")
                .then()
                .spec(statusCode200Spec)
                .extract()
                .response();

        this.instanceCookies = response.getCookies();
        GLOBAL_COOKIES.putAll(instanceCookies); // Сохраняем в глобальную переменную
        return instanceCookies;
    }

    // Метод для получения глобального токена
    public static String getGlobalToken(String tokenName) {
        return GLOBAL_COOKIES.get(tokenName);
    }

}