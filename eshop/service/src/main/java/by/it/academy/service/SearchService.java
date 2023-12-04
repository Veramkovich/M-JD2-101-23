package by.it.academy.service;

import by.it.academy.service.model.ProductSpecification;
import by.it.academy.service.model.SearchCriteria;

import java.sql.SQLException;
import java.util.List;

public interface SearchService {
    List<ProductSpecification> searchProducts(SearchCriteria searchCriteria) throws SQLException, ClassNotFoundException;
}
