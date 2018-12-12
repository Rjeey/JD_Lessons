package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createStudent(){
        Student student = new Student();
        student.setName("Student");
        student.setSecondName("Student2");
        student.setFaculty("POIT");
        student.setCourseYear((short) 3);


    }



    @After
    public void tearDown() throws Exception {
        if(session !=null && session.isOpen()){
            session.close();
            session = null;
        }
    }
}