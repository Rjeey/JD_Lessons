package by.it.pojo;

import by.it.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

public class PersonTest {

    EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        entityManager = HibernateUtil.getEntityManager();
    }

    @Test
    public void createInstnce(){
    Person person = new Person();

    person.setName("Person1");
    person.setSecoundName("LastNamePerson1");
    person.setAge(14);

        try {
           entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }


    @After
    public void tearDown() throws Exception {
        if (entityManager!=null && entityManager.isOpen()){
            entityManager.close();
            entityManager = null;
        }
    }
}