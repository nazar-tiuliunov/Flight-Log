package eu.profinit.education.flightlog.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import eu.profinit.education.flightlog.IntegrationTestConfig;
import eu.profinit.education.flightlog.to.FileExportTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegrationTestConfig.class)
@Transactional
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class CsvExportServiceTest {

    @Autowired
    private CsvExportService testSubject;

    @Test
    public void testCSVExport() throws IOException, URISyntaxException {
        FileExportTo allFlightsAsCsv = testSubject.getAllFlightsAsCsv();

        String actualResult = new String(allFlightsAsCsv.getContent(), allFlightsAsCsv.getEncoding());
        String expectedResult = readFileToString("expectedExport.csv");

        assertTrue(expectedResult.equalsIgnoreCase(actualResult));
    }

    private String readFileToString(String fileName) throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI())));
    }
}