package eu.profinit.education.flightlog.domain.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.profinit.education.flightlog.AbstractIntegrationTest;
import eu.profinit.education.flightlog.domain.entities.Flight;


public class FlightRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private FlightRepository testSubject;

    @Test
    public void shouldLoadFlights() {

        List<Flight> flights = testSubject.findAll();

        assertEquals(5, flights.size(), "There should be 5 flights");

    }

    @Disabled("Test is not implemented")
    @Test
    public void shouldLoadGliderFlights() {
        // TODO tutorial-3.3: Implement a test that checks that there are 2 gliders in a DB
    }

    @Test
    public void shouldLoadFlightsInTheAir() {
        List<Flight> flights = testSubject.findAllByLandingTimeNullOrderByTakeoffTimeAscIdAsc();
        
        assertEquals(3, flights.size(), "There should be 3 flights");
        assertEquals(5L, flights.get(0).getId().getId().longValue(),
                "Flight with ID 5 started first and should be first");
        assertEquals(1L, flights.get(1).getId().getId().longValue(), "Flight with ID 1 should be second");
        assertEquals(2L, flights.get(2).getId().getId().longValue(), "Flight with ID 2 should be third");
    }
}