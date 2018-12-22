package by.pvt.pojo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.*;

import by.pvt.util.HibernateUtil;


public class WorkerTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance() {
        Worker worker = createWorker("Worker1");
        Worker worker2 = createWorker("Worker2");
        Worker worker3 = createWorker("Worker3");
        Worker worker4 = createWorker("Worker4");
        Worker worker5 = createWorker("Worker5");



        try {
            session.beginTransaction();
            session.saveOrUpdate(worker);
            session.saveOrUpdate(worker2);
            session.saveOrUpdate(worker3);
            session.saveOrUpdate(worker4);
            session.saveOrUpdate(worker5);
            session.getTransaction().commit();
            assertNotNull(worker.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        Criteria criteria = session.createCriteria(Worker.class);
        criteria.add(Restrictions.ge("salary", new BigDecimal(1_000.00)));
        List list = criteria.list();

        System.out.println(list);

        criteria = session.createCriteria(Worker.class);
        criteria.setProjection((Projections.rowCount()));
        System.out.println(criteria.list());


    }

    private Worker createWorker(String suffix){
        if(suffix == null) suffix ="";
        Worker worker = new Worker();
        worker.setName("Worker"+ suffix);
        worker.setSecondName("Worker2"+ suffix);
        worker.setCompanyName("OOO Romashka");
        worker.setSalary(BigDecimal.valueOf(500 + Math.random()  * 1200.00));

        return worker;

    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}