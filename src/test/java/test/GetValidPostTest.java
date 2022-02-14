package test;

import business.ApiPost;
import org.testng.Assert;
import org.testng.annotations.Test;
import step.ApiSteps;

public class GetValidPostTest {


    private static final int POST_ID_99 = 99;
//вынести в тест дата
    @Test
    public void getAllPostsTest1() {
        ApiPost apiPost = ApiSteps.getPost(POST_ID_99);
        Assert.assertEquals(apiPost.userId, 10, "UserID is not 10");
        Assert.assertEquals(apiPost.id, 99, "Id is not 99");
      //  Assert.assertNotEquals(apiPost.title, null, "UserId is null");
        //переделать
        Assert.assertNotEquals(apiPost.body, null, "Body is null");
        Assert.assertNotNull(apiPost.title,"UserId is null");
        int i = 0;
    }
}
