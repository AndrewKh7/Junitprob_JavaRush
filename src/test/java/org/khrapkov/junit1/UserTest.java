package org.khrapkov.junit1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private User u1;
    private User u2;
    private User u3;

    @Before
    public void init(){
        this.u1 = new User("Anna",23, User.Sex.FEMALE);
        this.u2 = new User("John",25, User.Sex.MALE);
        this.u3 = new User("Kate",23, User.Sex.FEMALE);
    }

    @Test
    public void testGetSummaryAgeOfUsers() {
        Assert.assertTrue("getSummaryAgeOfUsers wrong",
                this.u1.getSummaryAgeOfUsers() == (this.u1.getAge()
                        + this.u2.getAge()
                        + this.u3.getAge())
        );
    }

    @Test
    public void testGetAverageAgeOfUsers() {
        int average = (this.u1.getAge() + this.u3.getAge() + this.u2.getAge()) / 3;
        Assert.assertTrue("getSummaryAgeOfUsers wrong",
                this.u1.getAverageAgeOfUsers() == average);
    }

    @Test
    public void allUsersNoNull(){
       List<User> users = User.getAllUsers();

       Assert.assertNotNull(users);
    }

    @Test
    public void testGetAllUsers() {
        List<User> expected = User.getAllUsers();
        List<User> actual = new ArrayList<>();
        actual.add(u1);
        actual.add(u2);
        actual.add(u3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testHowManyUsers() {
        Assert.assertTrue("quantity of users wrong", this.u1.howManyUsers() == 3);
    }

    @Test
    public void testHowManyMale() {
        Assert.assertTrue("quantity of male wrong", this.u1.howManyMale() == 1);
    }

    @Test
    public void testHowManyFemale() {
        Assert.assertTrue("quantity of female wrong", this.u1.howManyFemale() == 2);
    }

}