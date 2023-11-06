package by.it.academy.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EShopSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //Configuration conf = new Configuration();
                //conf.setPhysicalNamingStrategy(new MyPhysicalNamingStrategy());
                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
