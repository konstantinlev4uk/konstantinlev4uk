package utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {
    public static ApiResponse sendGet(String endPoint){
        RestAssured.baseURI = endPoint;
        RequestSpecification httpReguest = RestAssured.given();
        Response response = httpReguest.request(Method.GET);
        return new ApiResponse(response);
    }
}
