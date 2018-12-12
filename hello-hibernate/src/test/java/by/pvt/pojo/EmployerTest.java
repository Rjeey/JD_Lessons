package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployerTest {
    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();

    }

    @Test
    public void CreateIstance(){
        Employer e = new Employer();

        e.setName("One");
        e.setCorporateForNumber("375462");

        try {
            session.beginTransaction();
            session.saveOrUpdate(e);
            session.getTransaction().commit();
            assertNotNull(e.getId());
        } catch (Exception e1) {
            e1.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @After
    public void tearDown() throws Exception {

    }
}