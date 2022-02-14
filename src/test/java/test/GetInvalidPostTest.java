package test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import step.ApiSteps;

public class GetInvalidPostTest {

    private static final int POST_ID_150 = 150;
//вынести в тест двтв
    @Test
    public void getInvalidPostTest() {
       Response apiResponse=ApiSteps.getNotFoundPost(POST_ID_150);
        Assert.assertEquals(apiResponse.getBody().print(),"{}","Response body is not empty");
    }
}
