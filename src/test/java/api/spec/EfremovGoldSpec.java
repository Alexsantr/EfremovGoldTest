package api.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class EfremovGoldSpec {
    public static RequestSpecification requestSpec = with()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .filter(withCustomTemplates())
            .log().all();


    public static ResponseSpecification statusCode200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification statusCode201Spec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.ALL)
            .build();


    public static ResponseSpecification statusCode404Spec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(LogDetail.ALL)
            .build();

    public static ResponseSpecification statusCode400Spec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.ALL)
            .build();


}