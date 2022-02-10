package utils;

import io.restassured.response.Response;

public class ApiResponse {

    private Response response;

    public ApiResponse() {
    }

    public ApiResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public int getStatusCode(){
        return response.getStatusCode();
    }

}
