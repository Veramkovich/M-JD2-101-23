package by.it.academy.data.dao;

import by.it.academy.data.model.PromoDto;

import java.util.List;

public interface PromoDao {

    void create(PromoDto promoDto);

    void update(PromoDto promoDto);

    List<PromoDto> getAllPromos();

    PromoDto getPromoById(int id);
}
