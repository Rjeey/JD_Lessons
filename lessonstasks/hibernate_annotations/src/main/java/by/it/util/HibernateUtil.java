package by.it.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory managFactory;
    static {
        managFactory = Persistence.createEntityManagerFactory("by.it");
    }

    public static EntityManager getEntityManager(){
        return managFactory.createEntityManager();
    }
    public static void close(){
        managFactory.close();
    }
}
