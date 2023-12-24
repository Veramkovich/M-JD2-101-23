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

@Repository
@Transactional
@SuppressWarnings("unused")
public class ProductSpecificationDaoImpl implements ProductSpecificationDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductSpecificationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ProductSpecificationDto> read() throws SQLException, ClassNotFoundException {
        try (
                Statement statement = EShopDataSource.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("select * from T_PRODUCT_SPECIFICATION");
        ) {
            List<ProductSpecificationDto> products = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String productName = resultSet.getString("product_name");
                Double productPrice = resultSet.getDouble("product_price");
                products.add(new ProductSpecificationDto(id, productName, productPrice));
            }
            return products;
        }
    }

    @Override
    public ProductSpecificationDto readById(Long id) {
        return null;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void create(ProductSpecificationDto productSpecificationDto) {
        final Session session = sessionFactory.getCurrentSession();
        ProductSpecification productSpecification = new ProductSpecification(
                productSpecificationDto.getId() == null ? getMaxProductId() : productSpecificationDto.getId().intValue(),
                productSpecificationDto.getProductName(),
                productSpecificationDto.getProductPrice()
        );
        productSpecification.setProductImage(productSpecificationDto.getProductImage());
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
                .toList()
        );
        session.saveOrUpdate(productSpecification); //Some work
    }

    public int getMaxProductId() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select max(id) from ProductSpecification", Integer.class)
                .list()
                .get(0);
    }

    @Override
    public void update(ProductSpecificationDto productSpecificationDto) {
        this.create(productSpecificationDto);
    }

    @Override
    public void delete(ProductSpecificationDto productSpecificationDto) {
        //TODO: implement delete
    }


}
