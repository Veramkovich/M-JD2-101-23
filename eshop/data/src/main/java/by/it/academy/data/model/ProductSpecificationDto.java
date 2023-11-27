package by.it.academy.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class ProductSpecificationDto implements Serializable {

    private final Long id;
    private final String productName;
    private final Double productPrice;

    private final List<PromoDto> promos;

    public ProductSpecificationDto(Long id, String productName, Double productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.promos = new ArrayList<>();
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

    public List<PromoDto> getPromos() {
        return promos;
    }
}
