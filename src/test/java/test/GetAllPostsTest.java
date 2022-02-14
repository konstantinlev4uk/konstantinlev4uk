package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import business.ApiPost;
import step.ApiSteps;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllPostsTest {

    @Test
    public void getAllPost() {
        List<ApiPost> allPosts = ApiSteps.getAllPosts();
        List<Integer> idPosts = allPosts.stream().map(e -> e.id).collect(Collectors.toList());
        boolean isIdSorted = idPosts.stream().sorted().collect(Collectors.toList()).equals(idPosts);
        Assert.assertTrue(isIdSorted, "List is not sorted by ID ascending");
    }
}
