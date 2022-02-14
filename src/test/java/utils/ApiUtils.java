package utils;

import endPoint.EndPoint;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class ApiUtils {

    public static Response sendGet(String endPoint) {
        RestAssured.baseURI = EndPoint.BASE_URL.getEndPoint();
        return RestAssured.given().when().get(endPoint).then().extract().response();
    }

    public static Response sendPost(String endPoint, JSONObject object) {
        RestAssured.baseURI = EndPoint.BASE_URL.getEndPoint() + endPoint;
        RequestSpecification httpReguest = RestAssured.given().header("Content-Type", "application/json");
        httpReguest.body(object.toJSONString());
        return httpReguest.request(Method.POST);
    }
}
