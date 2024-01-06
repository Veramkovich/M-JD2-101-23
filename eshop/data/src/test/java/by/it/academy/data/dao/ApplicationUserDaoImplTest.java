package by.it.academy.data.dao;

import by.it.academy.data.TestDataConfiguration;
import by.it.academy.data.pojo.ApplicationUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
public class ApplicationUserDaoImplTest {

    @Autowired
    ApplicationUserDao applicationUserDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByUserName() {
        //Given
        String adminUserName = "admin";
        //When
        List<ApplicationUser> results = applicationUserDao.findByUserName(adminUserName);
        //Then
        assertEquals(1, results.size());
        assertEquals("admin", results.get(0).getPassword());
    }
}