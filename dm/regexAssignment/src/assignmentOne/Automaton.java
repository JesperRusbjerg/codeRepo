package assignmentOne;

import java.util.*;

public class Automaton {
    private State initState;

    public Automaton() {
        State databaseReading = new State("database", null);
        State login = new State("login", Arrays.asList(databaseReading));
        initState = new State("initial", Arrays.asList(login));
    }

    public State getInitState() {
        return initState;
    }
}
