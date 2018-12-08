package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerTest {

    Session session;
    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }


    @After
    public void tearDown() throws Exception {
        
    }
    }

    @Test
    public void CreateWorker() {

        }