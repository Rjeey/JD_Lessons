package by.it.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtil {

    private static final EntityManagerFactory emFactory;
    private static  SessionFactory sessionFactory;

    private HibernateUtil(){
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }


    public static Session getSession(){
        return sessionFactory.openSession();
    }

    static {
        emFactory = Persistence.createEntityManagerFactory("by.it");
    }
    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }
    public static  void close(){emFactory.close();}

}


