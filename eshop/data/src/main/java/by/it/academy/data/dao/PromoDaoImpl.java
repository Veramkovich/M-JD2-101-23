package by.it.academy.data.dao;

import by.it.academy.data.model.PromoDto;
import by.it.academy.data.pojo.Promo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PromoDaoImpl implements PromoDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public PromoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(PromoDto promoDto) {
        Session session = null;
        //Transaction transaction = null;
        Promo promo = new Promo(
                promoDto.getId(),
                promoDto.getPromoName(),
                promoDto.getStartDate(),
                promoDto.getEndDate()
        );
        //try {
        session = sessionFactory.getCurrentSession();
        //    transaction = session.beginTransaction();
        int savedId = (Integer) session.save(promo);//Some work
        //    transaction.commit();
        //} catch (Exception e) {
        //    if (transaction != null) transaction.rollback();
        //    throw new RuntimeException(e);
        //} finally {
        //    if (session != null) session.close();
        //}

    }

    @Override
    public void update(PromoDto promoDto) {

    }

    @Override
    public List<PromoDto> getAllPromos() {
        return null;
    }

    @Override
    public PromoDto getPromoById(int id) {
        return null;
    }
}
