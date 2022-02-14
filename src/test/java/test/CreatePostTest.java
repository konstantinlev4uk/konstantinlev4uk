package test;

import help.PropertyUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import business.ApiPost;
import step.ApiSteps;

public class CreatePostTest {
    private String body;
    private String title;
    private int userId;

/*    @BeforeMethod
    public void initTestData() {
        PropertyUtil propertyUtil=new PropertyUtil();
        propertyUtil.
        body = סקטעגûאוט
    }*/

    @Test
    public void createPostTest() {

        ApiPost apiPost = ApiSteps.createPost("body", "title", 1);
        Assert.assertEquals(apiPost.body, "body", "Body is not as expected");
        Assert.assertEquals(apiPost.title, "title", "Title is not as expected");
        Assert.assertEquals(apiPost.userId, 1, "userId is not as expected");
        Assert.assertNotEquals(String.valueOf(apiPost.id), "", "sdad");
    }
}
