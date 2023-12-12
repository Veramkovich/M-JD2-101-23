package by.it.academy.data.dao;

import by.it.academy.data.EShopDataSource;
import by.it.academy.data.model.ProductSpecificationDto;
import by.it.academy.data.pojo.ProductSpecification;
import by.it.academy.data.pojo.Promo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ProductSpecificationDaoImpl implements ProductSpecificationDao {

    private final SessionFactory sessionFactory;

    @Autowired
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
        //Transaction transaction = null;
        final Session session = sessionFactory.getCurrentSession();
        //try {
        ProductSpecification productSpecification = new ProductSpecification(
                productSpecificationDto.getId().intValue(),
                productSpecificationDto.getProductName(),
                productSpecificationDto.getProductPrice()
        );
        productSpecification.setPromoList(productSpecificationDto
                .getPromos()
                .stream()
                .map(promoDto -> {
                    Promo promo = session.find(Promo.class, promoDto.getId());
                    if (promo == null) {
                        promo = new Promo(
                                promoDto.getId(),
                                promoDto.getPromoName(),
                                promoDto.getStartDate(),
                                promoDto.getEndDate());
                    }
                    return promo;
                })
                .peek(promo -> promo.getProducts().add(productSpecification))
                .collect(Collectors.toList())
        );

        //    transaction = session.beginTransaction();
        session.saveOrUpdate(productSpecification);//Some work
        //    transaction.commit();
        //} catch (Exception e) {
        //    if (transaction != null) transaction.rollback();
        //    throw new RuntimeException(e);
        //} finally {
        //    if (session != null) session.close();
        //}
    }

    @Override
    public void update(ProductSpecificationDto productSpecificationDto) {
    }

    @Override
    public void delete(ProductSpecificationDto productSpecificationDto) {
    }


}
