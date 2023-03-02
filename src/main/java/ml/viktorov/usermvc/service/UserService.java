package ml.viktorov.usermvc.service;

import ml.viktorov.usermvc.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> getAllUsers();

    User saveUser(User user);

    User updateUser(User user);

    void deleteById(Long id);
}
