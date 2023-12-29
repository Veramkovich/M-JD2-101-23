package by.it.academy.data.dao;

import by.it.academy.data.model.ProductSpecificationDto;

import java.sql.SQLException;
import java.util.List;

public interface ProductSpecificationDao {
    List<ProductSpecificationDto> read() throws SQLException, ClassNotFoundException;

    ProductSpecificationDto readById(Long id);

    void create(ProductSpecificationDto productSpecificationDto);

    void update(ProductSpecificationDto productSpecificationDto);

    void delete(ProductSpecificationDto productSpecificationDto);

    byte[] readProductImageById(long id);
}
