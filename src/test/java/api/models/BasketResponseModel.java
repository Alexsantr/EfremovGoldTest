package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class BasketResponseModel {
    public List<BasketItem> data;
    public TotalInfo total;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class BasketItem {
        public boolean inStock;
        public List<Product> products;
        public List<Object> constructorSets; // Замените Object на конкретный тип, если известна структура
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Product {
        private int id;
        private String title;
        private String code;
        private String description;
        private String vendorCode;
        private List<Image> images;
        private int categoryId;
        private List<Integer> stickerIds;
        private List<Option> options;
        private List<Object> tags; // Замените Object на конкретный тип, если известна структура
        private List<Category> categories;
        private List<CardPrice> cardPrices;
        private List<Group> groups;
        private List<Integer> setProductIds;
        private List<ProductParam> productParams;
        private SeoPage seoPage;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Image {
        private int fileId;
        private int sort;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Option {
        private int id;
        private String title;
        private String code;
        private int sort;
        private List<OptionValue> values;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class OptionValue {
        private int id;
        private String title;
        private String code;
        private int sort;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Category {
        private int id;
        private String title;
        private String code;
        private Integer parentId;
        private List<Object> childrenIds; // Замените Object на конкретный тип, если известна структура
        private Integer mainPageImageId;
        private CategoryParams params;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class CategoryParams {
        private boolean useMainPageImage;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class CardPrice {
        private double oldPrice;
        private double price;
        private int bonusesForAccrual;
        private double limit;
        private int groupIndex;
        private double promoPercent;
        private double setDiscountPercent;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Group {
        public int id;
        public String title;
        public boolean selected;
        public List<Offer> offers;
        public int count;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Offer {
        private int id;
        private String barcode;
        private String vendorCode;
        private String title;
        private String description;
        private double weight;
        private int len;
        private int width;
        private int height;
        private int groupId;
        private List<Option> options;
        private boolean isBlank;
        private List<CardPrice> prices;
        private int remnants;
        private int count;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class ProductParam {
        private String content;
        private int id;
        private int sort;
        private String title;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class SeoPage {
        private String url;
        private String title;
        private String description;
        private String keywords;
        private String h1;
        private String ogTitle;
        private String ogDescription;
        private boolean isActive;
        private SeoPageParams params;
        private List<SeoText> text;
        private AdditionalFields additionalFields;
        private SeoPageConfig config;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class SeoPageParams {
        private int category;
        private Object filtersGo; // Замените Object на конкретный тип, если известна структура
        private Object stickerIds; // Замените Object на конкретный тип, если известна структура
        private boolean hasFilters;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class SeoText {
        private int id;
        private String title;
        private String description;
        private String target;
        private boolean index;
        private Object seoPageId; // Замените Object на конкретный тип, если известна структура
        private Object siteId; // Замените Object на конкретный тип, если известна структура
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class AdditionalFields {
        private String categoryTitle;
        private String seodescr;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class SeoPageConfig {
        private boolean replaceDescription;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class TotalInfo {
        public double price;
        public double discountExcludingBonuses;
        public double oldPrice;
        public double onlinePaymentDiscount;
        public int count;
        public int productsCountInBasket;
        public double multiplier;
        public Object groups; // Замените Object на конкретный тип, если известна структура
        public double calculationalLimitPrice;
        public double factualLimitPrice;
        public int bonusesForWriteOff;
        public int bonusesBalance;
        public int bonusesForAccrual;
        public double remainsUntilFreeDelivery;
        public int promoCodeDiscountValue;
        private double weight;
        private double len;
        private double width;
        private double height;
        private double volume;
        private boolean promocodeUsed;
    }
}