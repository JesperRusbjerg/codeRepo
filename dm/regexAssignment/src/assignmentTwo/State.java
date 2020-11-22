package assignmentTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {

    private String name;
    private List<StateConnectionCombination> connections = new ArrayList();
    private State nextState;
    private boolean isFinalState = false;

    public State(String name) {
        this.name = name;
    }


    public State searchForNextState(String s){

        for(StateConnectionCombination scc: connections){
            if(s.equals(scc.getCon())) return scc.getState();
        }
        return null;
    }

    public State setConnections(String cons, int qIndex) {
        if(cons.length() == 1){
            nextState = new State("q" + (qIndex + 2));
            connections.add(new StateConnectionCombination(nextState, cons));
            return nextState;
        }

        if(cons.contains("(")) cons = cons.replace("(", "");
        if(cons.contains(")")) cons = cons.replace(")", "");

        if(cons.contains("|") && cons.contains("*")) {
            cons = cons.replace("*", "");
            String[] split = cons.split("\\|");
            for (String x : split) {
                connections.add(new StateConnectionCombination(this, x));
            }
            return this;
        }else if(cons.contains("|")){
            String[] split = cons.split("\\|");
            nextState = new State("q" + (qIndex + 2));
            for(String x: split){
                connections.add(new StateConnectionCombination(nextState, x));
            }
            return nextState;

        }else if(cons.contains("*")){
            connections.add(new StateConnectionCombination(this, cons));
            return this;
        }

        return null;
    }

    public void setFinalState(boolean finalState) {
        isFinalState = finalState;
    }

    public boolean isFinalState() {
        return isFinalState;
    }


}
