package test;

import business.User;
import org.testng.annotations.BeforeMethod;
import utils.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;
import step.ApiSteps;
import utils.PropertyUtil;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class GetAllUsersTest {

    private int idUser;
    private String pathUserJson;

    @BeforeMethod
    public void initTestData() {
        Properties dataTest = PropertyUtil.getProperties("testData.properties");
        idUser = Integer.parseInt(dataTest.getProperty("idUser"));
        pathUserJson = dataTest.getProperty("pathUserJson");
    }

    @Test
    public void getAllUsersTest() throws IOException {
        List<User> allUsers = ApiSteps.getAllUsers();
        User selectedUser = allUsers.stream().filter(i -> i.id == idUser).findAny().orElse(null);
        User userData = Helper.getUserFromFile(pathUserJson);
        Assert.assertEquals(selectedUser, userData, "User different");
    }
}
