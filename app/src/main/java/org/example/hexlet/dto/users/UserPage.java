package org.example.hexlet.dto.users;

import lombok.Getter;
import lombok.Setter;
import org.example.hexlet.model.User;

@Setter
@Getter
public class UserPage {
    // Геттеры и сеттеры
    private User user;
    private String flashMessage;
    private String flashType;

    public UserPage(User user) {
        this.user = user;
    }

    // Дополнительные удобные методы
    public boolean hasFlash() {
        return flashMessage != null && !flashMessage.isEmpty();
    }
}