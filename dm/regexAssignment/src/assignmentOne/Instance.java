package assignmentOne;

import java.util.List;
import java.util.UUID;

public class Instance {

    private String id;
    private List<String> action;
    private State whereWeAt;

    public Instance(List<String> action, State s) {
        this.id = UUID.randomUUID().toString();
        this.action = action;
        this.whereWeAt = s;
    }

    public String getId() {
        return id;
    }

    public List<String> getAction() {
        return action;
    }

    public State getWhereWeAt() {
        return whereWeAt;
    }

    public void setWhereWeAt(State whereWeAt) {
        this.whereWeAt = whereWeAt;
    }

    @Override
    public String toString() {
        return "assignmentOne.Instance{" +
                "id='" + id + '\'' +
                ", action=" + action +
                ", whereWeAt=" + whereWeAt +
                '}';
    }
}

