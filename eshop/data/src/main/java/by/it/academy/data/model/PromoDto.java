package by.it.academy.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class PromoDto implements Serializable {

    private final int id;

    private final String promoName;

    private final Date startDate;

    private final Date endDate;

    private final List<ProductSpecificationDto> products;

    public PromoDto(int id, String promoName, Date startDate, Date endDate) {
        this.id = id;
        this.promoName = promoName;
        this.startDate = startDate;
        this.endDate = endDate;
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getPromoName() {
        return promoName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<ProductSpecificationDto> getProducts() {
        return products;
    }
}
