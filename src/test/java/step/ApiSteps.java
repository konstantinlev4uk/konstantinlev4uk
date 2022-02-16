package step;

import business.ApiPost;
import business.User;
import endPoint.EndPoint;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
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
        ApiPost apiPost = new ApiPost();
        if (apiResponse.statusCode() == HttpStatus.SC_OK) {
            log.info("Create ApiPost");
            apiPost = apiResponse.getBody().as(ApiPost.class);
            log.info("checking StatusCode");
            Assert.assertEquals(apiResponse.statusCode(), HttpStatus.SC_OK, "Status code is not " + HttpStatus.SC_OK);
        } else if (apiResponse.getStatusCode() == HttpStatus.SC_NOT_FOUND) {
            log.info("Create ApiPost");
            apiPost = apiResponse.getBody().as(ApiPost.class);
            log.info("checking StatusCode");
            Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NOT_FOUND, "Status code is not" + HttpStatus.SC_NOT_FOUND);
            log.info("checking response body");
            Assert.assertEquals(apiResponse.getBody().print(), "{}", "Response body is not empty");
        } else {
            log.info("StatusCode is different" + HttpStatus.SC_OK + "or" + HttpStatus.SC_NOT_FOUND);
        }
        return apiPost;
    }


    public static List<ApiPost> getAllPosts() {
        log.info("getting all posts");
        Response apiResponse = ApiUtils.sendGet(EndPoint.POSTS.getEndPoint());
        log.info("checking StatusCode");
        Assert.assertEquals(apiResponse.statusCode(), HttpStatus.SC_OK, "Status code is not " + HttpStatus.SC_OK);
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
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_CREATED, "Status code is not" + HttpStatus.SC_CREATED);
        return apiPost;
    }

    public static List<User> getAllUsers() {
        log.info("getting users");
        Response apiResponse = ApiUtils.sendGet(EndPoint.USERS.getEndPoint());
        log.info("create List<User>");
        List<User> allUsers = apiResponse.getBody().jsonPath().getList(".", User.class);
        log.info("checking StatusCode");
        Assert.assertEquals(apiResponse.statusCode(), HttpStatus.SC_OK, "Status code is not" + HttpStatus.SC_OK);
        return allUsers;
    }

    public static User getUser(int userID) {
        log.info("getting user");
        Response apiResponse = ApiUtils.sendGet(EndPoint.USERS.getEndPoint() + userID);
        return apiResponse.getBody().as(User.class);
    }
}
