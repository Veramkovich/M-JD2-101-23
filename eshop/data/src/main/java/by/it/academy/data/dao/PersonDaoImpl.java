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
        //Transaction transaction = null;
        String savedId;
        //try {
        session = sessionFactory.getCurrentSession();
        //    transaction = session.beginTransaction();
        savedId = (String) session.save(person);//Some work
        //    transaction.commit();
        //} catch (Exception e) {
        //    if (transaction != null) transaction.rollback();
        //    throw new RuntimeException(e);
        //} finally {
        //    if (session != null) session.close();
        //}
        return savedId;
    }

    @Override
    @Transactional(readOnly = true)
    public Person readPersonById(String id) {
        Session session = null;
        //Transaction transaction = null;
        Person person;
        //try {
        session = sessionFactory.getCurrentSession();
        //    transaction = session.beginTransaction();

        person = session.get(Person.class, id); //Some work

        //    transaction.commit();
        //} catch (Exception e) {
        //    if (transaction != null) transaction.rollback();
        //    throw new RuntimeException(e);
        //} finally {
        //    if (session != null) session.close();
        //}
        return person;
    }

    @Override
    public boolean deletePersonById(String id) {
        Session session = null;
        //Transaction transaction = null;
        Person person;
        //try {
        session = sessionFactory.getCurrentSession();
        //    transaction = session.beginTransaction();
        person = session.get(Person.class, id); //Some work
        if (person == null) {
            return false;
        }
        session.delete(person);
        //    transaction.commit();
        //} catch (Exception e) {
        //    if (transaction != null) transaction.rollback();
        //    throw new RuntimeException(e);
        //} finally {
        //    if (session != null) session.close();
        //}
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> readAll(int startPosition, int pageSize) {
        Session session = null;
        //try {
        session = sessionFactory.getCurrentSession();
        return session.createQuery("from Person order by firstName, lastName", Person.class)
                .setFirstResult(startPosition)
                .setMaxResults(pageSize)
                .list();

        //} catch (Exception e) {
        //    throw new RuntimeException(e);
        //} finally {
        //    if (session != null) session.close();
        //}
    }
}
