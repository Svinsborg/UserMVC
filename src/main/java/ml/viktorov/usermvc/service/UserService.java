package ml.viktorov.usermvc.service;

import ml.viktorov.usermvc.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> getAllUsers();

    void saveUser(String firstName, String lastName);

    void updateUser(Long id, String firstName, String lastName);

    void deleteById(Long id);
}
