package by.it.academy.service;

import by.it.academy.service.model.ProductSpecification;


public interface ProductService {

    void saveNewProduct(ProductSpecification productSpecification, byte[] productImage);

}
