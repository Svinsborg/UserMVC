package ml.viktorov.usermvc.service;

import ml.viktorov.usermvc.dao.UserDaoImpl;
import ml.viktorov.usermvc.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
public class UserServiceImp implements UserService{

    private final UserDaoImpl userDao;
    private final SessionFactory sessionFactory;


    @Autowired
    public UserServiceImp(UserDaoImpl userDao, SessionFactory sessionFactory) {
        this.userDao = userDao;
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
