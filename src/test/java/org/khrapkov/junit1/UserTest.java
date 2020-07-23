package org.khrapkov.junit1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void howManyUsers() {
    }

    @Test
    public void howManyMale() {
    }

    @Test
    public void howManyFemale() {
    }

    @Test
    public void getSummaryAgeOfUsers() {
    }

    @Test
    public void testGetSummaryAgeOfUsers() {
    }

    @Test
    public void getAverageAgeOfUsers() {
    }

    @Test
    public void testGetAverageAgeOfUsers() {
    }

    @Test
    public void getAllUsers() {
        User u1 = new User("Anna",23, User.Sex.FEMALE);
        User u2 = new User("John",25, User.Sex.MALE);
        User u3 = new User("Kate",23, User.Sex.FEMALE);

        List<User> extended = User.getAllUsers();

        List<User> actual = new ArrayList<>();
        actual.add(u1);
        actual.add(u2);
        actual.add(u3);

        Assert.assertEquals(extended,actual);
    }

    @Test
    public void testGetAllUsers() {
    }

    @Test
    public void testHowManyUsers() {
    }

    @Test
    public void testHowManyMale() {
    }

    @Test
    public void testHowManyFemale() {
    }

    @Test
    public void testGetSummaryAgeOfUsers1() {
    }

    @Test
    public void testGetSummaryAgeOfUsers2() {
    }

    @Test
    public void testGetAverageAgeOfUsers1() {
    }

    @Test
    public void testGetAverageAgeOfUsers2() {
    }
}