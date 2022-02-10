package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import step.ApiSteps;
import utils.ApiResponse;

public class GetInvalidPostTest {

    private static final int POST_ID_150 = 150;

    @Test
    public void getInvalidPostTest() {
        ApiResponse apiResponse=ApiSteps.getNotFoundPost(POST_ID_150);
        Assert.assertEquals(apiResponse.getResponse().getBody().print(),"{}","Response body is empty");
    }
}
