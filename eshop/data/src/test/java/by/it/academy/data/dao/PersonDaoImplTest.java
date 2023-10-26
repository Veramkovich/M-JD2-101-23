package by.it.academy.data.dao;

import by.it.academy.data.EShopDataSource;
import by.it.academy.data.pojo.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonDaoImplTest {

    PersonDao personDao;

    @org.junit.Before
    public void setUp() throws Exception {
        personDao = new PersonDaoImpl();
        Connection conn = EShopDataSource.getConnection();
        conn.createStatement().executeUpdate(
                "truncate table T_PERSON;"
        );
    }

    @org.junit.After
    public void tearDown() throws Exception {
        personDao = null;
        Connection conn = EShopDataSource.getConnection();
        conn.createStatement().executeUpdate(
                "truncate table T_PERSON;"
        );
    }

    @org.junit.Test
    public void testSaveNewPerson() throws Exception {
        // Given
        Person person = new Person(
                null, "John", "Smith", new Date()
        );

        // When
        String savedId = personDao.saveNewPerson(person);

        // Then
        assertNotNull(savedId);
        Connection conn = EShopDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where FIRST_NAME='John' and LAST_NAME='Smith'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @org.junit.Test
    public void readAll() {
    }
}