package by.it.dao;


import by.it.pojos.Person;
import by.it.util.HibernateUtil;
import org.hibernate.Session;


import java.io.Serializable;

public class DaoImpl {

  public void delete(Serializable id){
      Session session = HibernateUtil.getSession();
      session.beginTransaction();
      Person personForDelet = session.get(Person.class, id);
      session.delete(personForDelet);
      session.getTransaction().commit();
  }

  public void save (Person person){
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    session.save(person);
    session.getTransaction().commit();
  }

  public void find(Serializable id){
      Session session = HibernateUtil.getSession();
      session.load(Person.class, id);

  }
}
