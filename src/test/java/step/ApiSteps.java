package step;

import business.ApiPost;
import business.User;
import endPoint.EndPoint;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import utils.ApiUtils;
import constant.StatusCodeAndId;

import java.util.List;
import java.util.logging.Logger;

public class ApiSteps {

    static Logger log = Logger.getLogger(ApiSteps.class.getName());

    public static ApiPost getPost(int postId) {
        log.info("getting post");
        Response apiResponse = ApiUtils.sendGet(EndPoint.POSTS.getEndPoint() + postId);
        log.info("Create ApiPost");
        ApiPost apiPost = apiResponse.getBody().as(ApiPost.class);
        log.info("checking StatusCode");
        Assert.assertEquals(apiResponse.statusCode(), StatusCodeAndId.CODE_200, "Status code is not " + StatusCodeAndId.CODE_200);
        log.info("post received");
        return apiPost;
    }

    public static Response getNotFoundPost(int postId) {
        log.info("getting post");
        Response apiResponse = ApiUtils.sendGet(EndPoint.POSTS.getEndPoint() + postId);
        log.info("checking StatusCode");
        Assert.assertEquals(apiResponse.getStatusCode(), StatusCodeAndId.CODE_404, "Status code is not" + StatusCodeAndId.CODE_404);
        log.info("post received");
        return apiResponse;
    }

    public static List<ApiPost> getAllPosts() {
        log.info("getting all posts");
        Response apiResponse = ApiUtils.sendGet(EndPoint.POSTS.getEndPoint());
        log.info("checking StatusCode");
        Assert.assertEquals(apiResponse.statusCode(), StatusCodeAndId.CODE_200, "Status code is not " + StatusCodeAndId.CODE_200);
        log.info("posts all received");
        return apiResponse.getBody().jsonPath().getList(".", ApiPost.class);
    }

    public static ApiPost createPost(String body, String title, int userId) {
        log.info("create JSONObject");
        JSONObject requestParams = new JSONObject();
        log.info("fill in the parameters JSONObject");
        requestParams.put("title", title);
        requestParams.put("body", body);
        requestParams.put("userId", userId);
        log.info("Send a POST");
        Response apiResponse = ApiUtils.sendPost(EndPoint.POSTS.getEndPoint(), requestParams);
        log.info("Create ApiPost");
        ApiPost apiPost = apiResponse.getBody().as(ApiPost.class);
        log.info("checking StatusCode");
        Assert.assertEquals(apiResponse.getStatusCode(), StatusCodeAndId.CODE_201, "Status code is not" + StatusCodeAndId.CODE_201);
        return apiPost;
    }

    public static List<User> getAllUsers() {
        log.info("getting users");
        Response apiResponse = ApiUtils.sendGet(EndPoint.USERS.getEndPoint());
        log.info("create List<User>");
        List<User> allUsers = apiResponse.getBody().jsonPath().getList(".", User.class);
        log.info("checking StatusCode");
        Assert.assertEquals(apiResponse.statusCode(), StatusCodeAndId.CODE_200, "Status code is not" + StatusCodeAndId.CODE_200);
        return allUsers;
    }

    public static User getUser(int userID) {
        log.info("getting user");
        Response apiResponse = ApiUtils.sendGet(EndPoint.USERS.getEndPoint() + userID);
        return apiResponse.getBody().as(User.class);
    }
}
