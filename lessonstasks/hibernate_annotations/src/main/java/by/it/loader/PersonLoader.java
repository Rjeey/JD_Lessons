package by.it.loader;

import by.it.pojos.Person;
import by.it.util.HibernateUtil;

import javax.persistence.EntityManager;

public class PersonLoader {
    public static void main(String[] args)  {
        Person person = new Person(null, "Petrov", "Silent", 35);
        Person person2 = new Person(null,"Artem","Mal",18);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.persist(person2);
        entityManager.getTransaction().commit();
        HibernateUtil.close();



    }
}
