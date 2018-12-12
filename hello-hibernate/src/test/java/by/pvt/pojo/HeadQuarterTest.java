package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeadQuarterTest {
    Session session;


    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance(){
        HeadQuarter headQuarter = new HeadQuarter();

        headQuarter.setCompanyName("OOO Valsilek");
        headQuarter.setSiteUrl("www.vasilek.by");
        headQuarter.setBankAccount("123124sdgsdr13");
        headQuarter.setDerectorName("I am");

        try {
            session.beginTransaction();
            session.saveOrUpdate(headQuarter);
            session.getTransaction().commit();
            assertNotNull(headQuarter.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }



    @After
    public void tearDown() throws Exception {
        if(session !=null && session.isOpen()){
            session.close();
            session = null;
        }
    }
}