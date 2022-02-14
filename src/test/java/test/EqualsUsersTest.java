package test;

import business.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import step.ApiSteps;

import java.util.List;

public class EqualsUsersTest {
   /* private int id;

    @BeforeMethod
    public void initTestData() {
        id = סקטעגûאוט
    }*/

    @Test
    public void equalsUsersTest(){

        List<User> allUsers = ApiSteps.getAllUsers();
        User selectedUser = allUsers.stream().filter(i -> i.id == 5).findAny().orElse(null);

        User user=ApiSteps.getUser(5);
        Assert.assertEquals(selectedUser,user,"User different");
    }
}
