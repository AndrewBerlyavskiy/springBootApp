package ru.ber.springbootapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ber.springbootapp.dao.UserDao;
import ru.ber.springbootapp.model.User;


import java.util.List;

@Component
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;
    @Transactional(readOnly = true)
    @Override
    public List<User> listOfUsers () {
        return userDao.listOfUsers();
    }
    @Transactional
    @Override
    public void userRemoval(User user) {
        userDao.userRemoval(user);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Transactional
    @Override
    public void updateUser (User user) {
        userDao.updateUser(user);
    }
    @Transactional
    @Override
    public User getUserById (Long id) {
        return userDao.getUserById(id);
    }



}
