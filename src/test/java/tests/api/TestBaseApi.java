package tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseApi {

    @BeforeAll
    static void configParams() {

        RestAssured.baseURI = "https://efremov.gold/";
        RestAssured.basePath ="/api";
    }
}
