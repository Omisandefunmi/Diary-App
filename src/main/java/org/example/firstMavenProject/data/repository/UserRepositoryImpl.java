package org.example.firstMavenProject.data.repository;

import org.example.firstMavenProject.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    List <User> users = new ArrayList<>();
    @Override
    public void addUsers(User user) {
        users.add(user);
        user.setUserId(generateIdForEachUser());
    }

    @Override
    public boolean checkIfUserExists(String username, String userid) {
        return false;
    }

    @Override
    public User fetchUserWith(String userId) {
        StringBuilder id = extractNumbersFromStringId(userId);

        int index = convertStringIdToInteger(id);
        return users.get(index);

    }

    @Override
    public int countUsers() {
        return users.size();
    }

    @Override
    public void deleteUserBy(int id) {
        users.remove(id-1);
    }

    @Override
    public String fetchUserId(User user) {
        return user.getUserId();
    }

    private String generateIdForEachUser() {
        String idPrefix = "SCD";
        return idPrefix +(users.size());
    }

    private int convertStringIdToInteger(StringBuilder id) {
        return Integer.parseInt(id.toString()) - 1;
    }

    private StringBuilder extractNumbersFromStringId(String userId) {
        StringBuilder id = new StringBuilder();
        for (int i = 3; i < userId.length(); i++) {
            char letter = userId.charAt(i);
            id.append(letter);
        }
        return id;
    }
}
