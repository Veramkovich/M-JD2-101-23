package by.it.academy.data.dao;

import by.it.academy.data.EShopTestDataSource;
import by.it.academy.data.EShopTestSessionFactory;
import by.it.academy.data.pojo.Person;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class PersonDaoImplTest {

    PersonDao personDao;

    @org.junit.Before
    public void setUp() throws Exception {
        personDao = new PersonDaoImpl(EShopTestSessionFactory.getSessionFactory());
        Connection conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate(
                "truncate table T_PERSON;"
        );
    }

    @org.junit.After
    public void tearDown() throws Exception {
        personDao = null;
        Connection conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate(
                "truncate table T_PERSON;"
        );
    }

    @Test
    public void testSaveNewPerson() throws Exception {
        // Given
        Person person = new Person(
                null, "John", "Smith", new Date()
        );

        // When
        String savedId = personDao.saveNewPerson(person);

        // Then
        assertNotNull(savedId);
        Connection conn = EShopTestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where FIRST_NAME='John' and LAST_NAME='Smith'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testReadPersonById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `t_person`\n" +
                "(`PERSON_ID`,\n" +
                "`DATE_OF_BIRTH`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`)\n" +
                "VALUES\n" +
                "('" + testId + "',\n" +
                "'1980-01-01',\n" +
                "'Ivan',\n" +
                "'Petrov');\n");
        conn.close();

        //When
        Person person = personDao.readPersonById(testId);

        //Then
        assertNotNull(person);
        assertEquals(testId, person.getId());
        assertEquals("Ivan", person.getFirstName());
        assertEquals("Petrov", person.getLastName());

    }

    @Test
    public void testDeletePersonById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `t_person`\n" +
                "(`PERSON_ID`,\n" +
                "`DATE_OF_BIRTH`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`)\n" +
                "VALUES\n" +
                "('" + testId + "',\n" +
                "'1980-01-01',\n" +
                "'Ivan',\n" +
                "'Petrov');\n");

        //When
        boolean result = personDao.deletePersonById(testId);

        //Then
        assertTrue(result);
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where PERSON_ID='" + testId + "';"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(0, actualCount);
        conn.close();
    }

    @org.junit.Test
    public void readAll() {
    }
}