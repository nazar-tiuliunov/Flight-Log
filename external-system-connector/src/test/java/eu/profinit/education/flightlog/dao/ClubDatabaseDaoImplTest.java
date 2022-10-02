package eu.profinit.education.flightlog.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"integration.clubDb.baseUrl = http://vyuka.profinit.eu:8080"})
@ContextConfiguration
public class ClubDatabaseDaoImplTest {

    @Autowired
    private ClubDatabaseDao testSubject;

    @Test
    public void getUsers(){
        List<User> users = testSubject.getUsers();

        assertNotNull(users);
        assertTrue("Should contains at least 5 items.", users.size() > 5);
        assertNotNull(users.get(0).getFirstName());
        assertNotNull(users.get(0).getLastName());
        assertNotNull(users.get(0).getMemberId());
        assertNotNull(users.get(0).getRoles());
    }

    @Configuration
    @ComponentScan
    public static class IntegrationTestConfig {

    }
}