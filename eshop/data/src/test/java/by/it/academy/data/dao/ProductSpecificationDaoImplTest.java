package by.it.academy.data.dao;

import by.it.academy.data.EShopTestDataSource;
import by.it.academy.data.EShopTestSessionFactory;
import by.it.academy.data.model.ProductSpecificationDto;
import by.it.academy.data.model.PromoDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class ProductSpecificationDaoImplTest {

    ProductSpecificationDao productSpecificationDao;
    Connection conn;

    @Before
    public void setUp() throws Exception {
        productSpecificationDao = new ProductSpecificationDaoImpl(
                EShopTestSessionFactory.getSessionFactory()
        );
        conn = EShopTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PRODUCT_SPECIFICATION;");
    }

    @After
    public void tearDown() throws Exception {
        productSpecificationDao = null;
        conn.createStatement().executeUpdate("DELETE FROM T_PRODUCT_SPECIFICATION;");
        conn.close();
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

        //When
        //productSpecificationDao.create(dto);

        //Then
        ResultSet rs = conn.createStatement().executeQuery("SELECT count(*) FROM T_PRODUCT_SPECIFICATION");
        rs.next();
        int actualCount = rs.getInt(1);
        //assertEquals(1, actualCount);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}