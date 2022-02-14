package test;

import constant.StatusCodeAndId;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import step.ApiSteps;

public class GetInvalidPostTest {

    @Test
    public void getInvalidPostTest() {
        Response apiResponse = ApiSteps.getNotFoundPost(StatusCodeAndId.ID_150);
        Assert.assertEquals(apiResponse.getBody().print(), "{}", "Response body is not empty");
    }
}
