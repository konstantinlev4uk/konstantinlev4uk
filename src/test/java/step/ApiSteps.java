package step;

import business.ApiPost;
import business.User;
import endPoint.EndPoint;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import utils.ApiUtils;

import java.util.List;
import java.util.logging.Logger;

public class ApiSteps {
    static Logger log = Logger.getLogger(ApiSteps.class.getName());


    public static ApiPost getPost(int postId) {
        log.info("getting post");
        Response apiResponse = ApiUtils.sendGet(EndPoint.POSTS.getEndPoint() + postId);
        ApiPost apiPost = apiResponse.getBody().as(ApiPost.class);
        Assert.assertEquals(apiResponse.statusCode(), 200, "Status code is not 200");
        log.info("post received");
        return apiPost;
    }

    public static Response getNotFoundPost(int postId) {
        Response apiResponse = ApiUtils.sendGet(EndPoint.POSTS.getEndPoint() + postId);
        Assert.assertEquals(apiResponse.getStatusCode(), 404, "Status code is not 404");
        return apiResponse;
    }

    public static List<ApiPost> getAllPosts() {
        Response apiResponse = ApiUtils.sendGet(EndPoint.POSTS.getEndPoint());
        Assert.assertEquals(apiResponse.statusCode(), 200, "Status code is not 200");
        return apiResponse.getBody().jsonPath().getList(".", ApiPost.class);
    }

    public static ApiPost createPost(String body, String title, int userId) {
        /*Map<String, String> params = new HashMap<>();
        params.put("title", title);
        params.put("body", body);
        params.put("userId", String.valueOf(userId));*/
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", title);
        requestParams.put("body", body);
        requestParams.put("userId", userId);
        Response apiResponse = ApiUtils.sendPost(EndPoint.POSTS.getEndPoint(), requestParams);
        ApiPost apiPost = apiResponse.getBody().as(ApiPost.class);
        Assert.assertEquals(apiResponse.getStatusCode(), 201, "Status code is not 201");
        return apiPost;
    }

    public static List<User> getAllUsers() {
        Response apiResponse = ApiUtils.sendGet(EndPoint.USERS.getEndPoint());
        List<User> allUsers = apiResponse.getBody().jsonPath().getList(".", User.class);
        Assert.assertEquals(apiResponse.statusCode(), 200, "Status code is not 200");
        return allUsers;
    }

    public static User getUser(int userID) {
        Response apiResponse = ApiUtils.sendGet(EndPoint.USERS.getEndPoint() + userID);
        return apiResponse.getBody().as(User.class);
    }
}
