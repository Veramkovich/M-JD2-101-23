package by.it.academy.service;

import by.it.academy.data.dao.ProductSpecificationDao;
import by.it.academy.data.model.ProductSpecificationDto;
import by.it.academy.service.model.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductSpecificationDao productSpecificationDao;

    @Autowired
    public ProductServiceImpl(ProductSpecificationDao productSpecificationDao) {
        this.productSpecificationDao = productSpecificationDao;
    }

    @Override
    public void saveNewProduct(ProductSpecification productSpecification, byte[] productImage) {
        ProductSpecificationDto dto = new ProductSpecificationDto(
                productSpecification.getId(),
                productSpecification.getProductName(),
                productSpecification.getProductPrice()
        );
        dto.setProductImage(productImage);
        productSpecificationDao.create(dto);
    }

    public ProductSpecification getProductById(int productId) {
        ProductSpecificationDto dto = productSpecificationDao.readById((long) productId);
        return new ProductSpecification(
                dto.getProductName(),
                dto.getProductPrice(),
                dto.getId()
        );
    }

    @Override
    public byte[] getProductImageById(Integer id) {
        return productSpecificationDao.readProductImageById((long) id);
    }
}
