package by.pvt.pojo.annotation;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ApplicantTest {

        Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }

    @Test
    public void createInstance(){
        Applicant applicant = new Applicant();
        Profession profession = new Profession();
        Subject subject = new Subject();
        ApplicantResult applicantResult = new ApplicantResult();

        applicantResult.setApplicant(applicant);
        applicantResult.setMark(10);
        applicantResult.setSubject(subject);

        subject.setSubjectName("I'am");
        subject.setProfessionsSet(Set.of(profession));

        profession.setProfessionName("Proger");
        profession.setSubjectSet(Set.of());
        applicant.setFirstName("FirstName");
        applicant.setLastName("LastName");
        applicant.setMiddleName("MiddleName");
        applicant.setEntranceYear(15);
        applicant.setProfession(profession);
        applicant.setApplicantResults(List.of(applicantResult));

        try {
            session.beginTransaction();
            session.saveOrUpdate(applicant);
            session.saveOrUpdate(profession);
            session.saveOrUpdate(subject);
            session.saveOrUpdate(applicantResult);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()){
            session.close();
            session = null;
        }
    }
}