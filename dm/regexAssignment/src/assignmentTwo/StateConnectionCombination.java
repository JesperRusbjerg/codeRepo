package assignmentTwo;

public class StateConnectionCombination {

    private State state;
    private String con;

    public StateConnectionCombination(State state, String con) {
        this.state = state;
        this.con = con;
    }

    public State getState() {
        return state;
    }

    public String getCon() {
        return con;
    }
}
