package eu.profinit.education.flightlog.domain.entities;

import static lombok.AccessLevel.PACKAGE;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import eu.profinit.education.flightlog.domain.JpaConstants.Columns;
import eu.profinit.education.flightlog.domain.JpaConstants.Sequences;
import eu.profinit.education.flightlog.domain.JpaConstants.Tables;
import eu.profinit.education.flightlog.domain.fields.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = Tables.FLIGHT)
@SequenceGenerator(name = Sequences.FLIGHT, sequenceName = Sequences.FLIGHT, initialValue = Sequences.INITIAL_VALUE)
@NoArgsConstructor(access = PACKAGE)
@Getter
@Setter
@ToString
public class Flight {

    @Id
    @GeneratedValue(generator = Sequences.FLIGHT)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type flightType;

    private Task task;
    private LocalDateTime takeoffTime;
    private LocalDateTime landingTime;

    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = Columns.PILOT_PERSON_ID)
    private Person pilot;

    @ManyToOne
    @JoinColumn(name = Columns.COPILOT_PERSON_ID)
    private Person copilot;

    private String note;

    @OneToOne
    @JoinColumn(name = Columns.TOWPLANE_FLIGHT_ID)
    private Flight towplaneFlight;

    @OneToOne
    @JoinColumn(name = Columns.GLIDER_FLIGHT_ID)
    private Flight gliderFlight;

    public Flight(Type flightType, Task task, LocalDateTime takeoffTime, Airplane airplane, Person pilot,
            Person copilot, String note) {
        this.flightType = flightType;
        this.task = task;
        this.takeoffTime = takeoffTime;
        this.airplane = airplane;
        this.pilot = pilot;
        this.copilot = copilot;
        this.note = note;
    }

    public FlightId getId() {
        return new FlightId(id);
    }

    public enum Type {
        TOWPLANE,
        GLIDER
    }
}
