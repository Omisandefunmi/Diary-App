package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.Diary;
import org.example.firstMavenProject.data.model.User;

public interface UserRepository {
    void addUsers(User user);
    boolean checkIfUserExists(String username, String userid);
    User fetchUserWith(String userId);

    int countUsers();


    void deleteUserBy(int id);


    String fetchUserId(User user);
}
