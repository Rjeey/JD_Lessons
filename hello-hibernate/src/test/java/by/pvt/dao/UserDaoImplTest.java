package by.pvt.dao;


import by.pvt.pojo.User;
import by.pvt.pojo.UserDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.Serializable;
import java.sql.Timestamp;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImplTest {

    DaoImpl<User> userDao;

    @Before
    public void setUp(){
        userDao = new DaoImpl<>(User.class);
        DaoImpl.isTestInstance = true;
    }

    @Test
    public void step1_createNewUser(){
        User user = new User();
        user.setUserName("Pasha");
        user.setEmail("Logo@gmail.com");


        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("1245");
        userDetails.setLoginAttempts(5);
        userDetails.setExpireDate(new Timestamp(System.currentTimeMillis()));

        user.setUserDetails(userDetails);
        userDetails.setUser(user);

        userDao.saveOrUpdate(user);
        assertTrue(user.getId() > 0);

    }

    @Test
    public void step2_findNewUser(){
        User user = userDao.find(1L);
        assertNotNull(user);
        assertNotNull(user.getUserDetails());

    }

    @Test
    public void step3_updateNewUser(){
        User user = userDao.load(1L);
        user.setUserName("Vova");
        userDao.saveOrUpdate(user);

        User user2 = userDao.load(1L);
        assertTrue(user.getUserName().equals("Vova"));

    }

    @Test
    public void step4_deleteUser(){
        User user = userDao.load(1L);
        userDao.delete(user.getId());

        User user2 = userDao.find(1L);
        assertNull(user2);

    }

    @After
    public void tearDown(){
        userDao = null;
        DaoImpl.isTestInstance = false;

    }
}
