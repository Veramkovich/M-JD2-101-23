package by.it.academy.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecificationDao {

    public List<ProductSpecificationDto> read() throws SQLException, ClassNotFoundException {
        Statement statement = EShopDataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from product_specification");

        List<ProductSpecificationDto> products = new ArrayList<>();
        while(resultSet.next()) {
            Long id = resultSet.getLong("id");
            String productName = resultSet.getString("product_name");
            Double productPrice = resultSet.getDouble("product_price");
            products.add(new ProductSpecificationDto(id, productName, productPrice));
        }
        resultSet.close();
        statement.close();
        return products;
    }

    public ProductSpecificationDto readById(Long id) {
        return null;
    }

    public void create(ProductSpecificationDto productSpecificationDto) {}

    public void update(ProductSpecificationDto productSpecificationDto) {}

    public void delete(ProductSpecificationDto productSpecificationDto){}



}
