package step;

import org.testng.Assert;
import post.ApiPost;
import utils.ApiResponse;
import utils.ApiUtils;

import java.util.List;

public class ApiSteps {

    public static ApiPost getPost(int postId) {
        ApiResponse apiResponse = ApiUtils.sendGet("https://jsonplaceholder.typicode.com" + "/posts/" + postId);
        ApiPost apiPost = apiResponse.getResponse().getBody().as(ApiPost.class);
        Assert.assertEquals(apiResponse.getResponse().statusCode(), 200, "Status code is not 200");
        return apiPost;
    }

    public static ApiResponse getNotFoundPost(int postId) {
        ApiResponse apiResponse = ApiUtils.sendGet("https://jsonplaceholder.typicode.com" + "/posts/" + postId);
        Assert.assertEquals(apiResponse.getStatusCode(), 404, "Status code is not 404");
        return apiResponse;
    }

    public static List<ApiPost> getAllPosts() {
        ApiResponse apiResponse = ApiUtils.sendGet("https://jsonplaceholder.typicode.com" + "/posts");
        Assert.assertEquals(apiResponse.getResponse().statusCode(), 200, "Status code is not 200");
        return apiResponse.getResponse().getBody().jsonPath().getList(".", ApiPost.class);
    }
}
