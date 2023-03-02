package ml.viktorov.usermvc.dao;


import ml.viktorov.usermvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    List<User> users;

    @Override
    public User findById(Long id) {
        if (id > 0 && id < users.size()){
            return users.get(Math.toIntExact(id));
        } else{
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public User saveUser(User user) {
        user.setId(user.getId());
        users.add(Math.toIntExact(user.getId()),user);
        return users.get(Math.toIntExact(user.getId()));
    }


    @Override
    public User updateUser(User user) {
        int id = Math.toIntExact(user.getId());
        users.set(id,user);
        return users.get(Math.toIntExact(user.getId()));
    }

    @Override
    public void deleteById(Long id) {
        User user = users.get(Math.toIntExact(id));
        users.remove(user);
    }
}
