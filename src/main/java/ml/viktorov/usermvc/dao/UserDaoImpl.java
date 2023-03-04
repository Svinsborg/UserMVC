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
        Session session = sessionFactory.openSession();
        User user = session.createQuery("FROM User u WHERE u.id=:id",User.class )
                .setParameter("id",id)
                .getSingleResult();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void saveUser(String firstName, String lastName) {
        User user = new User(firstName,lastName);
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    public void updateUser(Long id, String firstName, String lastName) {
        User user = findById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = findById(id);
        sessionFactory.getCurrentSession().remove(user);
    }
}
