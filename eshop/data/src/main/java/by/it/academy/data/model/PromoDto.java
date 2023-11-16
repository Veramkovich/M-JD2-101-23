package by.it.academy.data.model;

import java.io.Serializable;
import java.util.Date;

public final class PromoDto implements Serializable {

    private final int id;

    private final String promoName;

    private final Date startDate;

    private final Date endDate;

    public PromoDto(int id, String promoName, Date startDate, Date endDate) {
        this.id = id;
        this.promoName = promoName;
        this.startDate = startDate;
        this.endDate = endDate;
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

}
