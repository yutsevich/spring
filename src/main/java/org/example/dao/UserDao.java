package org.example.dao;

import java.util.List;
import java.util.Optional;
import org.example.model.User;

public interface UserDao {
    User add(User user);

    List<User> getAll();

    Optional<User> getById(Long id);
}
