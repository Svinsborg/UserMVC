package ml.viktorov.usermvc.service;

import ml.viktorov.usermvc.dao.UserDao;
import ml.viktorov.usermvc.dao.UserDaoEMImpl;
import ml.viktorov.usermvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
public class UserServiceImp implements UserService{

    private final UserDao UserDao;

    public UserServiceImp(UserDaoEMImpl userDaoImp) {
        this.UserDao = userDaoImp;
    }


    @Override
    public User findById(Long id) {
        return UserDao.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return UserDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(String firstName, String lastName) {
        UserDao.saveUser(firstName, lastName);
    }

    @Override
    @Transactional
    public void updateUser(Long id, String firstName, String lastName) {
        UserDao.updateUser(id, firstName, lastName);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        UserDao.deleteById(id);
    }
}
