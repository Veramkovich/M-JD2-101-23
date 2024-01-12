package by.it.academy.rest;

import by.it.academy.data.dao.PersonDao;
import by.it.academy.data.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonRestController {

    @Autowired
    PersonDao personDao;


    @GetMapping(value = "/api/persons")
    public List<Person> getPersons(
            @RequestParam(name = "offset") int offset,
            @RequestParam(name = "limit") int limit
    ) {
        return personDao.readAll(offset, limit);
    }

    @GetMapping(value = "/api/persons/{id}")
    public Person getPerson(
            @PathVariable("id") String id) {
        return personDao.readPersonById(id);
    }

    @PostMapping(value = "/api/persons/{id}")
    public Person createPerson(
            @PathVariable("id") String id,
            @RequestBody Person person) {
        person.setId(id);
        personDao.saveNewPerson(person);
        return person;
    }

    @PutMapping(value = "/api/persons/{id}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public Person updatePerson(
            @PathVariable("id") String id,
            Person person) {
        return person;
    }

    @DeleteMapping(value = "/api/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(
            @PathVariable("id") String id) {
        personDao.deletePersonById(id);
    }

}
