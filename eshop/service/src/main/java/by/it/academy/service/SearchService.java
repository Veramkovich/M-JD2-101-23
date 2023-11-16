package by.it.academy.service;

import by.it.academy.data.dao.ProductSpecificationDaoImpl;
import by.it.academy.service.model.ProductSpecification;
import by.it.academy.service.model.SearchCriteria;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    private final ProductSpecificationDaoImpl productSpecificationDaoImpl;

    public SearchService() {
        this.productSpecificationDaoImpl = new ProductSpecificationDaoImpl();
    }

    public List<ProductSpecification> searchProducts(SearchCriteria searchCriteria) throws SQLException, ClassNotFoundException {
        return productSpecificationDaoImpl
                .read()
                .stream()
                .map(dto -> new ProductSpecification(dto.getProductName(), dto.getProductPrice()))
                .filter(productSpecification ->
                        productSpecification.getProductName().contains(searchCriteria.getProductNameCriteria()))
                .collect(Collectors.toList());
    }

}
