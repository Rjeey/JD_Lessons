package by.pvt.dao;

import by.pvt.pojo.Address;
import by.pvt.pojo.Department;
import by.pvt.pojo.Employee;
import by.pvt.pojo.EmployeeDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoImplTest {

    DaoImpl<Employee> employeeDao;
    @Before
   public void setUp(){
        employeeDao = new DaoImpl<>(Employee.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_CreateInstance(){
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
        department.setEmployees(Set.of(employee, employee2));
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


        employeeDao.saveOrUpdate(employee);

        employeeDao.saveOrUpdate(employee2);
        employeeDao.saveOrUpdate(employee3);

        assertTrue(employee.getId() == 1);
//        assertTrue(employee.getId() == 2);
//        assertTrue(employee.getId() == 3);
    }

    @Test
    public void step2_update(){
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
        department.setEmployees(Set.of(employee, employee2));
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


        employeeDao.saveOrUpdate(employee);

        employeeDao.saveOrUpdate(employee2);
        employeeDao.saveOrUpdate(employee3);


        employee.setDepartment(department);
        department.setEmployees(Set.of(employee));

        employee2.setDepartment(department2);
        employee3.setDepartment(department2);
        department2.setEmployees(Set.of(employee2,employee3));

        employeeDao.saveOrUpdate(employee);
        employeeDao.saveOrUpdate(employee2);
        employeeDao.saveOrUpdate(employee3);
    }

    @Test
    public void step3_delete(){
        employeeDao.delete(1L);
        employeeDao.delete(2L);
    }

    @After
    public void tearDown(){
        DaoImpl.isTestInstance  = false;
        employeeDao = null;
    }
}
