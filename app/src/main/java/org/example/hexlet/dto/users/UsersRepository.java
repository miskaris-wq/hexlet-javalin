package org.example.hexlet.dto.users;

import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    private static List<User> users = new ArrayList<>();


    public List<User> getUsers() {
        return users;
    }

    public static void save(User user) {
        users.add(user);
    }

}
