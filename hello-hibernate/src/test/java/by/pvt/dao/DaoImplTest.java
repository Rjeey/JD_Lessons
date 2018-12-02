package by.pvt.dao;

import by.pvt.pojo.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class DaoImplTest {

    DaoImpl<Person> dao;
    @Before
    public void setUp() throws Exception {
        dao = new DaoImpl<>();
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
    }

    @Test
    public void saveOrUpdate() {

        assertNull(dao.saveOrUpdate(null));

        assertNotNull(dao.saveOrUpdate(new Person()));

        Person person = new Person();
        assertNull(person.getId());
        Person person2 = dao.saveOrUpdate(person);
        assertEquals(person,person2);
        assertNotNull(person.getId());

        person2.setSecondName("Petrova");
        Person person3 = dao.saveOrUpdate(person2);
        assertEquals("Petrova",person3.getSecondName());
    }

    @Test
    public void load() {
        try {
            dao.load(null);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }

        Serializable id = dao.saveOrUpdate(new Person()).getId();
        assertNotNull(dao.load(id));
    }

    @Test
    public void find() {
        assertNull(dao.find(null));
        assertNull(dao.find("testID"));
        Serializable id = dao.saveOrUpdate(new Person()).getId();
        assertNotNull(dao.find(id));

    }
}