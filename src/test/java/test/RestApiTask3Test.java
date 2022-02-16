package test;

import business.ApiPost;
import business.User;
import constant.UserId;
import org.testng.Assert;
import org.testng.annotations.Test;
import step.ApiSteps;
import utils.Helper;
import utils.PropertyUtil;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class RestApiTask3Test {

    Properties dataTest = PropertyUtil.getProperties("testData.properties");

    @Test
    public void restApiTask3Test() {

        List<ApiPost> allPosts = ApiSteps.getAllPosts();
        List<Integer> idPosts = allPosts.stream().map(e -> e.id).collect(Collectors.toList());
        boolean isIdSorted = idPosts.stream().sorted().collect(Collectors.toList()).equals(idPosts);
        Assert.assertTrue(isIdSorted, "List is not sorted by ID ascending");

        ApiPost apiPost = ApiSteps.getPost(UserId.POST);
        Assert.assertEquals(apiPost.userId, UserId.USER_ID_FROM_POST, "UserID is not" + UserId.USER_ID_FROM_POST);
        Assert.assertEquals(apiPost.id, UserId.POST, "Id is not" + UserId.POST);
        Assert.assertNotNull(apiPost.body, "Body is not null");
        Assert.assertNotNull(apiPost.title, "UserId is not null");

        ApiPost apiPost2 = ApiSteps.getPost(UserId.NON_EXISTENT_POST);
        Assert.assertNull(apiPost2.body, "Response Body not empty");

        ApiPost apiPostData = new ApiPost(Helper.generateString(), Helper.generateString(), UserId.CONTAIN_IN_USER_ID);
        ApiPost apiPost3 = ApiSteps.createPost(apiPostData.body, apiPostData.title, UserId.CONTAIN_IN_USER_ID);
        Assert.assertEquals(apiPost3, apiPostData, "title, body, userId match those passed in the request");
        Assert.assertNotEquals(String.valueOf(apiPost.id), "", "Id is present in the response");

        List<User> allUsers = ApiSteps.getAllUsers();
        User selectedUser = allUsers.stream().filter(i -> i.getId() == UserId.SELECT_USER).findAny().orElse(null);
        User userData = Helper.getUserFromFile(dataTest.getProperty("pathUserJson"));
        Assert.assertEquals(selectedUser, userData, "User different");

        User user = ApiSteps.getUser(UserId.SELECT_USER);
        Assert.assertEquals(selectedUser, user, "User different");
    }
}
