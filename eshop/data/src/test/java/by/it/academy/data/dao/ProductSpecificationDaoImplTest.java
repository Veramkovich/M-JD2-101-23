package by.it.academy.data.dao;

import by.it.academy.data.EShopTestDataSource;
import by.it.academy.data.TestDataConfiguration;
import by.it.academy.data.model.ProductSpecificationDto;
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
public class ProductSpecificationDaoImplTest {

    @Autowired
    ProductSpecificationDao productSpecificationDao;
    Connection conn;

    @Before
    public void setUp() throws Exception {
        conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PRODUCT_PROMO;");
        conn.createStatement().executeUpdate("DELETE FROM T_PRODUCT_SPECIFICATION;");
        conn.createStatement().executeUpdate("DELETE FROM T_PROMO;");
    }

    @After
    public void tearDown() throws Exception {
        productSpecificationDao = null;
    }

    @Test
    public void read() {
    }

    @Test
    public void readById() {
    }

    @Test
    public void create() throws SQLException {
        //Given
        ProductSpecificationDto dto = new ProductSpecificationDto(
                1L, "iPhone 15", 5999.99
        );
        byte[] bytes = {1, 1, 1};
        dto.setProductImage(bytes);

        //When
        productSpecificationDao.create(dto);

        //Then
        ResultSet rs = conn.createStatement().executeQuery("SELECT count(*) FROM T_PRODUCT_SPECIFICATION");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void createProductWithPromo() throws SQLException, ParseException {
        //Given
        ProductSpecificationDto product1 = new ProductSpecificationDto(
                1L, "iPhone 15", 5999.99
        );
        ProductSpecificationDto product2 = new ProductSpecificationDto(
                2L, "iPad Mini 128G", 4999.99
        );
        ProductSpecificationDto product3 = new ProductSpecificationDto(
                3L, "MacBook Pro 256GB", 6999.99
        );

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

        product1.getPromos().add(promoDto1);
        product2.getPromos().add(promoDto2);
        product3.getPromos().add(promoDto1);
        product3.getPromos().add(promoDto2);

        //When
        productSpecificationDao.create(product1);
        productSpecificationDao.create(product2);
        productSpecificationDao.create(product3);


        //Then
        ResultSet rs = conn.createStatement().executeQuery("SELECT count(*) FROM T_PRODUCT_SPECIFICATION");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(3, actualCount);

        rs = conn.createStatement().executeQuery("SELECT count(*) FROM T_PROMO");
        rs.next();
        actualCount = rs.getInt(1);
        assertEquals(2, actualCount);

        rs = conn.createStatement().executeQuery("SELECT count(*) FROM T_PRODUCT_PROMO");
        rs.next();
        actualCount = rs.getInt(1);
        assertEquals(4, actualCount);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}