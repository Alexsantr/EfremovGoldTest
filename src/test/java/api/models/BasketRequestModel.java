package api.models;

import lombok.Data;

import java.util.List;
@Data
public class BasketRequestModel {
    private String basket;
    private List<BasketGroup> groups;
    private boolean change;

    @Data
    public static class BasketGroup {
        private int id;
        private int count;
    }
}
