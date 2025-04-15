package api.models;

import lombok.Data;

import java.util.List;

@Data
public class RemoveFromBasketRequest {
    private String basket;
    private List<Integer> groupIds;
    private boolean notInStock;
}