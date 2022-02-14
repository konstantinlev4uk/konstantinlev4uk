package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Map;

public class ApiUtils {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static Response sendGet(String endPoint) {
        RestAssured.baseURI = BASE_URL;// + endPoint;

        // request().get().then().extract().response();
        // RequestSpecification httpReguest = RestAssured.given();
        //   Response response = httpReguest.request(Method.GET);
        //  valideteTo
        return RestAssured.given().when().get(endPoint).then().extract().response();
    }

    public static Response sendPost(String endPoint, JSONObject object) {
        RestAssured.baseURI = BASE_URL + endPoint;
        RequestSpecification httpReguest = RestAssured.given().header("Content-Type", "application/json");
        httpReguest.body(object.toJSONString());
        return httpReguest.request(Method.POST);
    }
}
