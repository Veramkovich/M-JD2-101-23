package by.it.academy.data.dao;

import by.it.academy.data.pojo.ApplicationUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ApplicationUserDaoImpl implements ApplicationUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ApplicationUser> findByUserName(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("from ApplicationUser au where au.username=:username", ApplicationUser.class)
                .setParameter("username", username)
                .list();
    }
}
