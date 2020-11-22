package assignmentTwo;

import java.util.ArrayList;
import java.util.List;

public class AutomatonRunner {

    private List<String> regex = new ArrayList();
    private State start = new State("q1");

    public AutomatonRunner() {
        regex.add("a");
        regex.add("(b|c)*");
        regex.add("d");
    }


    public void start(State node, int regexIndex){
        if(regexIndex == regex.size()){
            node.setFinalState(true);
            return;
        }

        State newState = node.setConnections(regex.get(regexIndex), regexIndex);

        start(newState, regexIndex+1);
    }

    public void searchAutomatonPath(String s){

        State current = start;

        for (int i = 0; i < s.length(); i++) {
            String search = String.valueOf(s.charAt(i));
            current = current.searchForNextState(search);
            if(current == null){
                System.out.println("Not a valid path, no connection found");
                return;
            }
        }

        if(current.isFinalState()){
            System.out.println("We made it to a final accepted state");
        }else{
            System.out.println("We are done searching the string, but did not find a match");
        }

    }


    public State getStart() {
        return start;
    }

    public static void main(String[] args) {
        AutomatonRunner a = new AutomatonRunner();

        a.start(a.getStart(), 0);

//        State s = a.getStart();

        a.searchAutomatonPath("abbbbbbbcccccccd");
        a.searchAutomatonPath("abc");
        a.searchAutomatonPath("abbbbb");
        a.searchAutomatonPath("abbbbbccccc");

        a.searchAutomatonPath("axxx");

    }
}
