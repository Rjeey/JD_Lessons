package by.it.dao;


import by.it.pojo.Person;
import by.it.util.HibernateUtil;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import java.io.Serializable;

public class DaoImpl {

    EntityManager entityManager;

  public void delete(Serializable id){
      entityManager = HibernateUtil.getEntityManager();
      entityManager.getTransaction().begin();
      Person personForDelete = entityManager.find(Person.class, id);
      entityManager.remove(personForDelete);
      entityManager.getTransaction().commit();
  }

  public void save (Person person){
    entityManager = HibernateUtil.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(person);
    entityManager.getTransaction().commit();
  }

  public void find(Serializable id){
      entityManager = HibernateUtil.getEntityManager();
      entityManager.find(Person.class, id);

  }
}
