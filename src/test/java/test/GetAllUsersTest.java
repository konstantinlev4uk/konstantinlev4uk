package test;

import business.User;
import help.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;
import step.ApiSteps;
import java.io.IOException;
import java.util.List;

public class GetAllUsersTest {
//вынести путь
    @Test
    public void getAllUsersTest() throws IOException {

        List<User> allUsers = ApiSteps.getAllUsers();
        User selectedUser = allUsers.stream().filter(i -> i.id == 5).findAny().orElse(null);

        User userData= Helper.getUserFromFile("src/test/java/properties/userData.json");

        Assert.assertEquals(selectedUser, userData, "User different");
    }
}
