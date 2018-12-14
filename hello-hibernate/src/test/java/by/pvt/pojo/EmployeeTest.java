package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeTest {
        Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getTestSession();
    }


    @Test
    public void createInstance() {
        Employee employee = new Employee();
        employee.setFirstName("Pahs");
        employee.setLastName("Lolovich");
        employee.setCellPhone("1111");

        Employee employee2 = new Employee();
        employee2.setFirstName("Name2");
        employee2.setLastName("LastName2");
        employee2.setCellPhone("222222");

        Employee employee3 = new Employee();
        employee3.setFirstName("Name3");
        employee3.setLastName("LastName3");
        employee3.setCellPhone("3333");

        Department department = new Department();
        department.setDepartmentName("Department1");
        department.setEmployees(Set.of(employee,employee2));
        employee.setDepartment(department);
        employee2.setDepartment(department);

        Department department2 = new Department();
        department2.setDepartmentName("Department2");
        department2.setEmployees(Set.of(employee3));
        employee3.setDepartment(department2);

        EmployeeDetails employeeDetails = new EmployeeDetails();
        Address address1 = new Address("Minsk","Lenina","1",101);
        address1.setOfficeNumber("1234");
        employeeDetails.setAddress(address1);
        employeeDetails.setPosition("employee1");
        employeeDetails.setPrivateNr("e1");
        employeeDetails.setEmployee(employee);
        employee.setEmployeeDetails(employeeDetails);

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        Address address2 = new Address("Grodno","KamenajGorka","2",202);
        address2.setOfficeNumber("12345");
        employeeDetails.setAddress(address2);
        employeeDetails2.setPosition("employee2");
        employeeDetails2.setPrivateNr("e2");
        employeeDetails2.setEmployee(employee2);
        employee2.setEmployeeDetails(employeeDetails2);

        EmployeeDetails employeeDetails3 = new EmployeeDetails();
        Address address3 = new Address("Vitebsk","KamenajGorka3","3",303);
        address3.setOfficeNumber("123456");
        employeeDetails3.setAddress(address3);
        employeeDetails3.setPosition("employee3");
        employeeDetails3.setPrivateNr("e3");
        employeeDetails3.setEmployee(employee3);
        employee3.setEmployeeDetails(employeeDetails3);

        try {
            session.beginTransaction();
            session.saveOrUpdate(employee);
            session.saveOrUpdate(employee2);
            session.saveOrUpdate(employee3);

            session.getTransaction().commit();
            assertTrue(employee.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        }

    }

    @Test
    public void update(){
        Employee employee = new Employee();

        employee.setFirstName("Arthur");
        employee.setLastName("Pendragon");
        employee.setCellPhone("none");

        Employee employee2 = new Employee();

        employee2.setFirstName("Marhta");
        employee2.setLastName("Lolga");
        employee2.setCellPhone("123343643");

        Department department = new Department();

        department.setDepartmentName("Camelot");
        department.setEmployees(Set.of(employee));
        employee.setDepartment(department);

        Department department2 = new Department();

        department2.setDepartmentName("Illusion");
        department2.setEmployees(Set.of(employee2));
        employee2.setDepartment(department2);

        EmployeeDetails employeeDetails = new EmployeeDetails();

        employeeDetails.setPrivateNr("Arthur and the knights of the round table");
        employeeDetails.setPosition("King");
        employeeDetails.setAddress(new Address("GreatBritain", "London", "1",101 ));
        employeeDetails.setEmployee(employee);
        employee.setEmployeeDetails(employeeDetails);

        EmployeeDetails employeeDetails2 = new EmployeeDetails();

        employeeDetails2.setPrivateNr(" Mart1");
        employeeDetails2.setPosition("woman");
        employeeDetails2.setAddress(new Address("USA","Chicago","2",202));
        employeeDetails2.setEmployee(employee2);
        employee2.setEmployeeDetails(employeeDetails2);

        try {
            session.beginTransaction();
            session.saveOrUpdate(employee);
            session.saveOrUpdate(employee2);
            session.getTransaction().commit();
            assertTrue(employee.getId()>0);
        } catch (Exception e) {
            e.printStackTrace();
            if (session!=null) session.getTransaction().rollback();
        }

        employee.setDepartment(department2);
        department2.setEmployees(Set.of(employee));
        employee2.setDepartment(department);
        department.setEmployees(Set.of(employee2));

        try {
            session.beginTransaction();
            session.saveOrUpdate(employee);
            session.saveOrUpdate(employee2);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session!=null) session.getTransaction().rollback();
        }

    }


    @After
    public void tearDown() throws Exception {
        if (session !=null && session.isOpen()){
            session.close();
            session = null;

        }
    }
}