package eu.profinit.education.flightlog.domain;

public final class JpaConstants {

    public final class Tables {
        public static final String CLUB_AIRPLANE = "c_club_airplane";
        public static final String AIRPLANE_TYPE = "c_airplane_type";
        public static final String FLIGHT = "t_flight";
        public static final String PERSON = "t_person";

        private Tables() {
            // prevent instantiation
        }
    }

    public final class Sequences {
        public static final String FLIGHT = "seq_flight";
        public static final String PERSON = "seq_person";
        public static final int INITIAL_VALUE = 100;

        private Sequences() {
            // prevent instantiation
        }
    }

    public final class Columns {
        public static final String TASK = "task";
        public static final String TOWPLANE_FLIGHT_ID = "towplane_flight_id";
        public static final String GLIDER_FLIGHT_ID = "glider_flight_id";
        public static final String TYPE_ID = "type_id";
        public static final String REGISTERED_AIRPLANE_ID = "club_airplane_id";
        public static final String PILOT_PERSON_ID = "pilot_person_id";
        public static final String COPILOT_PERSON_ID = "copilot_person_id";

        private Columns() {
            // prevent instantiation
        }
    }
}
