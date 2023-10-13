package by.it.academy.service;

import by.it.academy.data.ProductSpecificationDao;
import by.it.academy.model.ProductSpecification;
import by.it.academy.model.SearchCriteria;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    private final ProductSpecificationDao productSpecificationDao;

    public SearchService() {
        this.productSpecificationDao = new ProductSpecificationDao();
    }

    public List<ProductSpecification> searchProducts(SearchCriteria searchCriteria) throws SQLException, ClassNotFoundException {
        return productSpecificationDao
                .read()
                .stream()
                .map(dto -> new ProductSpecification(dto.getProductName(), dto.getProductPrice()))
                .filter(productSpecification ->
                        productSpecification.getProductName().contains(searchCriteria.getProductNameCriteria()))
                .collect(Collectors.toList());
    }

}
