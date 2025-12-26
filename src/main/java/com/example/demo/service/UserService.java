package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User registerUser(User user);

    User findByEmail(String email);
}
