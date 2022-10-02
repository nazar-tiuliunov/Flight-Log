package eu.profinit.education.flightlog;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import eu.profinit.education.flightlog.configuration.WebDriverConfiguration;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = WebDriverConfiguration.class)
@Slf4j
@ActiveProfiles("inttest")
public class FlightLogSeleniumTests {

    @Autowired
    public WebDriver webDriver;

    @Value("${application.url}")
    private String baseUrl;

    @Before
    public void setUp() {
        webDriver.get(baseUrl);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Ignore("Test is not implemented")
    @Test
    public void testAddNewFlight() throws Exception {
        // TODO tutorial-3.5: Implement an end to end test using Selenium that registers a new flight and checks whether it was created
    }
}
