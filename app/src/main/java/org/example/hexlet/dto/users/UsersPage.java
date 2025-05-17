// src/main/java/org/example/hexlet/dto/users/UsersPage.java
package org.example.hexlet.dto.users;

import lombok.Getter;
import lombok.Setter;
import org.example.hexlet.model.User;

import java.util.List;
@Setter
@Getter
public class UsersPage {
    private final List<User> users;
    private String flashMessage;

    public UsersPage(List<User> users) {
        this.users = users;
    }

}