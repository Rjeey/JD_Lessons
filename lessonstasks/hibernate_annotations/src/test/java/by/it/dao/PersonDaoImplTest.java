package by.it.dao;

import by.it.pojo.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class PersonDaoImplTest {
    DaoImpl personDao;


    @Before
    public void setUp() {
        personDao = new DaoImpl();
    }

    @Test
    public void savePerson(){
        Person person = new Person();
        person.setName("PersonTest");
        person.setSecoundName("LastNameTest");
        person.setAge(15);
        personDao.save(person);
    }

    @Test
    public void finPerson(){
        Person person = new Person();
        person.setName("PersonTest");
        person.setSecoundName("LastNameTest");
        person.setAge(15);
        Person person2 = new Person();
        person2.setName("PersonTest");
        person2.setSecoundName("LastNameTest");
        person2.setAge(15);
        personDao.save(person);
        personDao.save(person2);
        personDao.find(person.getId());
    }

    @Test
    public void deletePerson(){
        Person person = new Person();
        person.setName("PersonTest");
        person.setSecoundName("LastNameTest");
        person.setAge(15);
        personDao.save(person);
        assertNotNull(person.getId());
        personDao.delete(person.getId());
        assertNull(personDao.entityManager.find(Person.class, person.getId()));
    }

    @After
    public void tearDown(){
        personDao = null;
    }
}
