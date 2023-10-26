package by.it.academy.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EShopSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .configure() //TODO: specify conf file name (default: hibernate.cfg.xml)
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
