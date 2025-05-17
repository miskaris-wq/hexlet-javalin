// src/main/java/org/example/hexlet/repository/UserRepository.java
package org.example.hexlet.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.hexlet.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class UserRepository {
    private static AtomicLong counter = new AtomicLong(1);
    @Getter
    private static List<User> entities = new ArrayList<>();

    public static void save(User user) {
        user.setId(counter.getAndIncrement());
        entities.add(user);
    }

    public static Optional<User> find(Long id) {
        return entities.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    public static void delete(Long id) {
        entities.removeIf(u -> u.getId().equals(id));
    }
}