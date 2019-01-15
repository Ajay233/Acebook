package com.makersacademy.acebook.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void user(){
        User user = new User("Ajay123", "1234abcd",
                             "Ajay", "ajay123@hotmail.com");
    }

    @Test
    public void name(){
        User user = new User("Ajay123", "1234abcd",
                "Ajay", "ajay123@hotmail.com");
        user.setName("Test");
        assertEquals("Test", user.getName());
    }

    @Test
    public void userName(){
        User user = new User("Ajay123", "1234abcd",
                "Ajay", "ajay123@hotmail.com");
        user.setUsername("123Ajay");
        assertEquals("123Ajay", user.getUsername());
    }

    @Test
    public void password(){
        User user = new User("Ajay123", "1234abcd",
                "Ajay", "ajay123@hotmail.com");
        user.setPassword("abcd1234");
        assertEquals("abcd1234", user.getPassword());
    }

    @Test
    public void email(){
        User user = new User("Ajay123", "1234abcd",
                "Ajay", "ajay123@hotmail.com");
        user.setEmail("123ajay@gmail.com");
        assertEquals("123ajay@gmail.com", user.getEmail());
    }

}