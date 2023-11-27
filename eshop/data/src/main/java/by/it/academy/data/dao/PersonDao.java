package by.it.academy.data.dao;

import by.it.academy.data.pojo.Person;

import java.util.List;

public interface PersonDao {

    String saveNewPerson(Person person);

    Person readPersonById(String id);

    boolean deletePersonById(String id);

    List<Person> readAll(int startPosition, int pageSize);

}
