package by.it.academy.data.dao;

import by.it.academy.data.EShopSessionFactory;
import by.it.academy.data.pojo.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDaoImpl implements PersonDao {

    @Override
    public String saveNewPerson(Person person) {
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = EShopSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(person);//Some work
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return savedId;
    }

    @Override
    public List<Person> readAll() {
        return null;
    }
}
