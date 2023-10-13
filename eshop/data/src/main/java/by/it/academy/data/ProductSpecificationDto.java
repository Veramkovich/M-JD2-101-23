package by.it.academy.data;

import java.io.Serializable;

public final class ProductSpecificationDto implements Serializable {

    private final Long id;
    private final String productName;
    private final Double productPrice;

    public ProductSpecificationDto(Long id, String productName, Double productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }
}
