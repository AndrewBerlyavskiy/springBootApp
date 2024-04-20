package ru.ber.springbootapp.service;


import ru.ber.springbootapp.model.User;

import java.util.List;

public interface UserService {
    List<User> listOfUsers ();
    void userRemoval(User user);
    void createUser(User user);
    void updateUser (User user);

    User getUserById (Long id);
}
