// TestData.java
package tests.api;

import java.util.Map;

public class TestData {
    public static final int TEST_PRODUCT_ID = 32647;
    public static final String EXPECTED_TITLE = "210040002207 Кольцо (Золото 585К)";
    public static final String EXPECTED_PRODUCT_CODE = "210040002207_kolco_zoloto_585k_32647";
    public static final int TEST_GROUP_ID = 252161;
    public static final int EXPECTED_CATEGORY_ID_LENGTH = 3;
    public static final int EXPECTED_PRODUCT_COUNT = 2;

    public static class Products {
        public static final Map<Integer, Integer> MULTIPLE_PRODUCTS = Map.of(
                252997, 1,
                252998, 2,
                253000, 1
        );
    }

    public static class Auth {
        public static final String INVALID_EMAIL = "ASDASD@MAIL.RT";
        public static final String EXPECTED_ERROR_CODE = "P_USERS_0002";
        public static final String EXPECTED_ERROR_MESSAGE = "Пользователя с таким e-mail не существует";
    }
}