package by.it.academy.data.dao;

import by.it.academy.data.model.PromoDto;
import by.it.academy.data.pojo.Promo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Repository
@Transactional
@SuppressWarnings("unused")
public class PromoDaoImpl implements PromoDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public PromoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(PromoDto promoDto) {
        Session session;
        Promo promo = new Promo(
                promoDto.getId(),
                promoDto.getPromoName(),
                promoDto.getStartDate(),
                promoDto.getEndDate()
        );
        session = sessionFactory.getCurrentSession();
        session.persist(promo);
    }

    @Override
    public void update(PromoDto promoDto) {
        sessionFactory
                .getCurrentSession()
                .merge(new Promo(
                                promoDto.getId(),
                                promoDto.getPromoName(),
                                promoDto.getStartDate(),
                                promoDto.getEndDate()
                        )
                );
    }

    @Override
    public List<PromoDto> getAllPromos() {
        return Collections.emptyList();
    }

    @Override
    public PromoDto getPromoById(int id) {
        return null;
    }
}
