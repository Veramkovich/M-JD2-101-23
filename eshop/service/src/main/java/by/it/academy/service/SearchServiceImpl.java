package by.it.academy.service;

import by.it.academy.data.dao.ProductSpecificationDao;
import by.it.academy.service.model.ProductSpecification;
import by.it.academy.service.model.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private ProductSpecificationDao productSpecificationDao;

    @Override
    @Transactional(readOnly = true)
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
