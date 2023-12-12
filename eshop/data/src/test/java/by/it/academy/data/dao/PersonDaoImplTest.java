package by.it.academy.data.dao;

import by.it.academy.data.EShopTestDataSource;
import by.it.academy.data.EShopTestSessionFactory;
import by.it.academy.data.TestDataConfiguration;
import by.it.academy.data.pojo.Person;
import by.it.academy.data.pojo.PersonDetails;
import by.it.academy.data.pojo.TargetGroup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class PersonDaoImplTest {

    @Autowired
    PersonDao personDao;

    @Before
    public void setUp() throws Exception {
        //personDao = new PersonDaoImpl(EShopTestSessionFactory.getSessionFactory());
        Connection conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");
        conn.createStatement().executeUpdate("DELETE FROM T_TARGET_GROUP;");
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON_DETAILS;");

    }

    @After
    public void tearDown() throws Exception {
        personDao = null;
        Connection conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");
        conn.createStatement().executeUpdate("DELETE FROM T_TARGET_GROUP;");
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON_DETAILS;");
    }

    @Test
    public void testSaveNewPerson() throws Exception {
        // Given
        Person person = new Person(
                null, "John", "Smith", new Date()
        );
        PersonDetails personDetails = new PersonDetails();
        personDetails.setMobileNumber("+375296789876");
        person.setPersonDetails(personDetails);

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
    public void testSaveNewPersonWithTargetGroup() throws SQLException, ClassNotFoundException {
        // Given
        Connection conn = EShopTestDataSource.getConnection();
        String targetGroupUUID = "b5bed480-507b-4e5d-a33e-f3ce37af0000";
        conn.createStatement().executeUpdate("INSERT INTO T_TARGET_GROUP (ID, GROUP_NAME) VALUES('"
                + targetGroupUUID
                + "', 'TestTargetGroup');");
        Person person = new Person(
                null, "John", "SmithWithTargetGroup", new Date()
        );
        TargetGroup targetGroup = EShopTestSessionFactory
                .getSessionFactory().openSession().get(TargetGroup.class, targetGroupUUID);
        person.setTargetGroup(targetGroup);

        // When
        String savedId = personDao.saveNewPerson(person);

        //Then
        ResultSet rs = conn.createStatement().executeQuery(
                "SELECT TARGET_GROUP_ID from T_PERSON where PERSON_ID='" + savedId + "';"
        );
        rs.next();
        String savedGroupId = rs.getString(1);
        assertNotNull(savedGroupId);
        assertEquals(targetGroupUUID, savedGroupId);
        conn.close();
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

    @Test
    public void readAll() throws SQLException, ClassNotFoundException {
        // Given
        Connection conn = EShopTestDataSource.getConnection();
        for (int i = 0; i < 10; i++) {
            String testId = UUID.randomUUID().toString();
            conn.createStatement().executeUpdate("INSERT INTO t_person" +
                    "(PERSON_ID," +
                    "DATE_OF_BIRTH," +
                    "FIRST_NAME," +
                    "LAST_NAME)" +
                    "VALUES" +
                    "('" + testId + "'," +
                    "'1980-01-01'," +
                    "'Ivan" + i + "'," +
                    "'Petrov');");
        }
        conn.close();

        // When
        List<Person> people = personDao.readAll(2, 3);

        // Then
        assertEquals(3, people.size());
        assertEquals("Ivan2", people.get(0).getFirstName());
        assertEquals("Ivan3", people.get(1).getFirstName());
        assertEquals("Ivan4", people.get(2).getFirstName());
    }
}