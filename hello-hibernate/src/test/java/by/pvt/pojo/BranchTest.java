package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BranchTest {
    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }


    @Test
    public void createInstance(){
        Branch branch = new Branch();

        branch.setCompanyName("OOO Gladious");
        branch.setSiteUrl("www.gladiolus.by");
        branch.setBranchName("GladiolusBranch");
        branch.setBranchDirector("I am");

        try {
            session.beginTransaction();
            session.saveOrUpdate(branch);
            session.getTransaction().commit();
            assertNotNull(branch.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }


    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}