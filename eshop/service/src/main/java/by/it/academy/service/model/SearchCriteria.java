package by.it.academy.service.model;

import java.io.Serializable;

public class SearchCriteria implements Serializable {

    private String productNameCriteria;

    public SearchCriteria() {
    }

    public String getProductNameCriteria() {
        return productNameCriteria;
    }

    public void setProductNameCriteria(String productNameCriteria) {
        this.productNameCriteria = productNameCriteria;
    }
}
