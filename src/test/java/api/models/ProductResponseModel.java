package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ProductResponseModel {
    private Integer id;
    private String title;
    private String code;
    private Integer rate;
    private String vendorCode;
    private Integer categoryId;
    private String description;
    private List<Image> images;
    private List<Object> videos; // или создайте класс Video, если нужно
    private List<Integer> stickerIds;
    private List<ProductOption> options;

    @Data
    public static class Image {
        private Integer fileId;
        private Integer sort;
    }

    @Data
    public static class ProductOption {
        private String code;
        private Integer id;
        private String title;
        private Boolean showInCard;
        private List<OptionValue> values;
    }

    @Data
    public static class OptionValue {
        private Integer id;
        private String code;
        private String title;
    }
}