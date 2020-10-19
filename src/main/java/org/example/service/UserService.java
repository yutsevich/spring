package org.example.service;

import java.util.List;
import org.example.model.User;

public interface UserService {
    void add(User user);

    List<User> getAll();
}
