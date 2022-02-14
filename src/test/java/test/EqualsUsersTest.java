package test;

import business.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import step.ApiSteps;
import utils.PropertyUtil;

import java.util.List;
import java.util.Properties;

public class EqualsUsersTest {

   private int idUser;

    @BeforeMethod
    public void initTestData() {
        Properties dataTest = PropertyUtil.getProperties("testData.properties");
        idUser = Integer.parseInt(dataTest.getProperty("idUser"));
    }

    @Test
    public void equalsUsersTest(){

        List<User> allUsers = ApiSteps.getAllUsers();
        User selectedUser = allUsers.stream().filter(i -> i.id == idUser).findAny().orElse(null);
        User user=ApiSteps.getUser(idUser);
        Assert.assertEquals(selectedUser,user,"User different");
    }
}
