package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import post.ApiPost;
import step.ApiSteps;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllPosts {

    @Test
    public void getAllPost() {
        List<ApiPost> allPosts = ApiSteps.getAllPosts();
        List<Integer> idPosts = allPosts.stream().map(e -> e.id).collect(Collectors.toList());
        boolean isIDsorted = idPosts.stream().sorted().collect(Collectors.toList()).equals(idPosts);
        Assert.assertTrue(isIDsorted, "List is not sorted by ID ascending");
    }
}
