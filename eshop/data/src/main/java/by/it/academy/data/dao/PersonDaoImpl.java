package by.it.academy.data.dao;

import by.it.academy.data.pojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String saveNewPerson(Person person) {
        Session session = null;
        String savedId;
        session = sessionFactory.getCurrentSession();
        savedId = (String) session.save(person);//Some work
        return savedId;
    }

    @Override
    @Transactional(readOnly = true)
    public Person readPersonById(String id) {
        Session session;
        Person person;
        session = sessionFactory.getCurrentSession();
        person = session.get(Person.class, id); //Some work
        return person;
    }

    @Override
    public boolean deletePersonById(String id) {
        Session session;
        Person person;
        session = sessionFactory.getCurrentSession();
        person = session.get(Person.class, id); //Some work
        if (person == null) {
            return false;
        }
        session.delete(person);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> readAll(int startPosition, int pageSize) {
        Session session;
        session = sessionFactory.getCurrentSession();
        return session.createQuery("from Person order by firstName, lastName", Person.class)
                .setFirstResult(startPosition)
                .setMaxResults(pageSize)
                .list();
    }
}
