package by.it.academy.data.dao;

import by.it.academy.data.EShopTestDataSource;
import by.it.academy.data.TestDataConfiguration;
import by.it.academy.data.model.PromoDto;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class PromoDaoImplTest {


    @Autowired
    PromoDao promoDao;
    Connection conn;

    @Before
    public void setUp() throws Exception {
        //promoDao = new PromoDaoImpl(EShopTestSessionFactory.getSessionFactory());
        conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PROMO");
    }

    @After
    public void tearDown() throws Exception {
        promoDao = null;
        conn.createStatement().executeUpdate("DELETE FROM T_PROMO");
        conn.close();
    }

    @Test
    public void create() throws ParseException, SQLException {
        // Given
        PromoDto promoDto1 = new PromoDto(
                101,
                "New Year Promo",
                new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-10"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-15")
        );
        PromoDto promoDto2 = new PromoDto(
                102,
                "Black Friday",
                new SimpleDateFormat("yyyy-MM-dd").parse("2023-11-11"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2023-11-17")
        );

        // When
        promoDao.create(promoDto1);
        promoDao.create(promoDto2);

        // Then
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT count(*) FROM T_PROMO");
        resultSet.next();
        int actualCount = resultSet.getInt(1);
        assertEquals(2, actualCount);
    }

    @Test
    public void update() {
        // Given
        // 1. save record via JDBC: insert into my_entity values();

        // When
        // 2. call DAO update method


        // Then
        // 3. read updated record: select * from my_entity;
        // 4. assert: check changed fields
    }

    @Test
    public void getAllPromos() {
    }

    @Test
    public void getPromoById() {
    }
}