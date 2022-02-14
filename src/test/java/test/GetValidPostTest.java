package test;

import business.ApiPost;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import step.ApiSteps;
import constant.StatusCodeAndId;
import utils.PropertyUtil;

import java.util.Properties;

public class GetValidPostTest {

    private int userId10;

    @BeforeMethod
    public void initTestData() {
        Properties dataTest = PropertyUtil.getProperties("testData.properties");
        userId10 = Integer.parseInt(dataTest.getProperty("userId10"));
    }

    @Test
    public void getAllPostsTest1() {
        ApiPost apiPost = ApiSteps.getPost(StatusCodeAndId.ID_99);
        Assert.assertEquals(apiPost.userId, userId10, "UserID is not" + userId10);
        Assert.assertEquals(apiPost.id, StatusCodeAndId.ID_99, "Id is not" + StatusCodeAndId.ID_99);
        Assert.assertNotNull(apiPost.body, "Body is not null");
        Assert.assertNotNull(apiPost.title, "UserId is not null");
    }
}
