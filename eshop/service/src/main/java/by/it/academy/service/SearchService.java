package by.it.academy.service;

import by.it.academy.model.ProductSpecification;
import by.it.academy.model.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    static List<ProductSpecification> productsDatabase = new ArrayList<ProductSpecification>();

    static {
        productsDatabase.add(new ProductSpecification("Apple iPhone 13", 4999.99));
        productsDatabase.add(new ProductSpecification("Apple iPhone 13 Pro", 5999.99));
        productsDatabase.add(new ProductSpecification("Apple iPhone 14", 6999.99));
        productsDatabase.add(new ProductSpecification("Apple iPhone 14 Pro", 7999.99));
        productsDatabase.add(new ProductSpecification("Apple iPhone 15", 8999.99));
        productsDatabase.add(new ProductSpecification("Apple iPhone 15 Pro", 9999.99));
        productsDatabase.add(new ProductSpecification("Samsung Galaxy A53", 4999.99));
        productsDatabase.add(new ProductSpecification("Motorola M70", 2999.99));
        productsDatabase.add(new ProductSpecification("Huawei P30 Lite", 3999.99));
        productsDatabase.add(new ProductSpecification("Honor 10", 1999.99));
        productsDatabase.add(new ProductSpecification("Honor 20", 2999.99));
        productsDatabase.add(new ProductSpecification("Honor 30", 3999.99));
        productsDatabase.add(new ProductSpecification("Vivo 1018", 4999.99));
        productsDatabase.add(new ProductSpecification("Mi Redmi 9", 8999.99));
    }

    public List<ProductSpecification> searchProducts(SearchCriteria searchCriteria) {
        return productsDatabase.stream()
                .filter(productSpecification ->
                        productSpecification.getProductName()
                                .contains(searchCriteria.getProductNameCriteria()))
                .collect(Collectors.toList());
    }

}
