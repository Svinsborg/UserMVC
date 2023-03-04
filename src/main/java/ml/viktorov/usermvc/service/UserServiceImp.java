package ml.viktorov.usermvc.service;

import ml.viktorov.usermvc.dao.UserDaoImpl;
import ml.viktorov.usermvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userServiceImp")
public class UserServiceImp implements UserService{



    private final UserDaoImpl userDaoImp;

    @Autowired
    public UserServiceImp(UserDaoImpl userDaoImp) {
        this.userDaoImp = userDaoImp;
    }


    @Override
    @Transactional
    public User findById(Long id) {
        return userDaoImp.findById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(String firstName, String lastName) {
         userDaoImp.saveUser(firstName, lastName);
    }

    @Override
    @Transactional
    public void updateUser(Long id, String firstName, String lastName) {
        userDaoImp.updateUser(id, firstName, lastName);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDaoImp.deleteById(id);
    }
}
