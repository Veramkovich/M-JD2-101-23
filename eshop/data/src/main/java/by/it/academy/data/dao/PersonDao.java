package by.it.academy.data.dao;

import by.it.academy.data.pojo.Person;

import java.util.List;

public interface PersonDao {

    String saveNewPerson(Person person);

    List<Person> readAll();

}
