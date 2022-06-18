package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    @BeforeEach
    public void alwaysStartWith(){
        userRepository = new UserRepositoryImpl();
    }

    @Test
    public void testThatRepositoryIsEmptyByDefault(){
        assertEquals(0, userRepository.countUsers());
    }

    @Test
    public void testThatRepositoryIsNotEmptyAfterSavingUser(){
        User user = new User("Olaide", "0000");
        userRepository.addUsers(user);
        assertEquals(1, userRepository.countUsers());
    }

    @Test
    public void testThatRepositoryCanSaveMultipleUser(){
        User user = new User("Olaide", "0000");
        User user2 = new User("Olaide", "0000");
        userRepository.addUsers(user);
        userRepository.addUsers(user2);
        assertEquals(2, userRepository.countUsers());
    }

    @Test
    public void testThatRepositoryCanDeleteUser(){
        User user = new User("Olaide", "0000");
        userRepository.addUsers(user);
        userRepository.deleteUserBy(1);
        assertEquals(0, userRepository.countUsers());
    }

    @Test
    public void testThatRepositoryCanGenerateIdForUsers(){
        User user = new User("Olaide", "0000");
        userRepository.addUsers(user);
        assertEquals("SCD1", userRepository.fetchUserId(user));
    }

    @Test
    public void testThatRepositoryCanFetchMultipleUserByIndex(){
        User user = new User("Olaide", "0000");
        User user2 = new User("Olaife", "9900");
        userRepository.addUsers(user);
        userRepository.addUsers(user2);

        assertEquals(user, userRepository.fetchUserWith("SCD1"));
        assertEquals(user2, userRepository.fetchUserWith("SCD2"));
    }

}