package eu.profinit.education.flightlog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
@ActiveProfiles("inttest")
public class FlightLogSeleniumTests {

    WebDriver webDriver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }


    @Value("${application.url}")
    private String baseUrl;

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Disabled("Test is not implemented")
    @Test
    public void testAddNewFlight() throws Exception {
        // TODO tutorial-3.5: Implement an end to end test using Selenium that registers a new flight and checks whether it was created
    }
}
