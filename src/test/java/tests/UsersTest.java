package tests;

import dto.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static adapters.UserAPI.*;

public class UsersTest {

    @Test
    public void checkCreateUser() {
        CreateUserRq rq = CreateUserRq.builder()
                .name("Liza")
                .job("QA")
                .build();
        CreateUserRs rs = createUser(rq);
        Assert.assertEquals(rs.getName(), "Liza");
        Assert.assertEquals(rs.getJob(), "QA");
    }

    @Test
    public void checkDeleteUser() {
        deleteUser(2);
    }

    @Test
    public void checkUpdateUser() {
        UpdateUserRq rq = UpdateUserRq.builder()
                .name("Test User")
                .job("AQA")
                .build();
        UpdateUserRs rs = updateUser(rq);
        Assert.assertEquals(rs.getName(), "Test User");
        Assert.assertEquals(rs.getJob(), "AQA");
    }

    @Test
    public void checkUpdateViaPatch() {
        UpdateUserRq request = UpdateUserRq.builder()
                .name("My Test")
                .build();
        UpdateUserRs response = updateUserViaPatch(request);
        Assert.assertEquals(response.getName(), "My Test");
    }

    @Test
    public void checkGetUser() {
        GetSingleUserRs rs = getSingleUser(2);
        Assert.assertEquals(rs.getUser().getFirstName(), "Janet");
    }
}
