package api.models;

import lombok.Data;
@Data
public class BasketResponseModel {

    private boolean success;
    private String message;
    private BasketData data;

    @Data
    public static class BasketData {
        private int totalCount;
        private double totalPrice;
        // Другие поля ответа при необходимости
    }
}
