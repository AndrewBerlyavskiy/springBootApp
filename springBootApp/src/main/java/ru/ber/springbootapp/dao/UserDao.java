package ru.ber.springbootapp.dao;


import ru.ber.springbootapp.model.User;

import java.util.List;

public interface UserDao {
    void userRemoval(User user);
    void createUser(User user);
    void updateUser (User user);
    List<User> listOfUsers ();

    User getUserById (Long id);

}
