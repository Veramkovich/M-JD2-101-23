package by.it.academy.data.dao;

import by.it.academy.data.EShopDataSource;
import by.it.academy.data.model.ProductSpecificationDto;
import by.it.academy.data.pojo.ProductSpecification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecificationDaoImpl implements ProductSpecificationDao {

    private final SessionFactory sessionFactory;

    public ProductSpecificationDaoImpl() {
        sessionFactory = null;
    }

    public ProductSpecificationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ProductSpecificationDto> read() throws SQLException, ClassNotFoundException {
        Statement statement = EShopDataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from T_PRODUCT_SPECIFICATION");

        List<ProductSpecificationDto> products = new ArrayList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String productName = resultSet.getString("product_name");
            Double productPrice = resultSet.getDouble("product_price");
            products.add(new ProductSpecificationDto(id, productName, productPrice));
        }
        resultSet.close();
        statement.close();
        return products;
    }

    @Override
    public ProductSpecificationDto readById(Long id) {
        return null;
    }

    @Override
    public void create(ProductSpecificationDto productSpecificationDto) {
        Session session = null;
        Transaction transaction = null;
        ProductSpecification productSpecification = new ProductSpecification(
                productSpecificationDto.getId().intValue(),
                productSpecificationDto.getProductName(),
                productSpecificationDto.getProductPrice()
        );
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            int savedId = (Integer) session.save(productSpecification);//Some work
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void update(ProductSpecificationDto productSpecificationDto) {
    }

    @Override
    public void delete(ProductSpecificationDto productSpecificationDto) {
    }


}
