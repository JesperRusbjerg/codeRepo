package assignmentOne;

import java.util.ArrayList;
import java.util.List;

public class State {

    private String name;
    List<State> eligibleStates;
    List<Instance> instancesInThisState = new ArrayList<>();

    public State(String name, List<State> eligibleStates) {
        this.name = name;
        this.eligibleStates = eligibleStates;
    }

    public State attemptToEnterNewState(String s){
        if(eligibleStates == null) return null;

        for(State e: eligibleStates){
            if(s.equals(e.getName())) return e;
        }
        return null;
    }

    public boolean isFinalState(){
        return eligibleStates == null;
    }

    public String getName() {
        return name;
    }
}



