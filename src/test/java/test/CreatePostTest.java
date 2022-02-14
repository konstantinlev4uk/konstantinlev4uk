package test;

import utils.Helper;
import utils.PropertyUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import business.ApiPost;
import step.ApiSteps;

import java.util.Properties;

public class CreatePostTest {

    private String body;
    private String title;
    private int userId;

    @BeforeMethod
    public void initTestData() {
        Properties dataTest = PropertyUtil.getProperties("testData.properties");
        userId = Integer.parseInt(dataTest.getProperty("userId1"));
        body = Helper.generateString();
        title = Helper.generateString();
    }

    @Test
    public void createPostTest() {
        ApiPost apiPostData = new ApiPost(body, title, userId);
        ApiPost apiPost = ApiSteps.createPost(body, title, userId);
        Assert.assertEquals(apiPost, apiPostData, "title, body, userId match those passed in the request");
        Assert.assertNotEquals(String.valueOf(apiPost.id), "", "Id is present in the response");
    }
}
