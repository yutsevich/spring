package org.example.dao;

import java.util.List;
import org.example.model.User;

public interface UserDao {
    void add(User user);

    List<User> getAll();
}
