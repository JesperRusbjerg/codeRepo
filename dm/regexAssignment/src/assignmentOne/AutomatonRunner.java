package assignmentOne;

import java.util.ArrayList;
import java.util.Arrays;

public class AutomatonRunner {

    private Automaton a;

    public AutomatonRunner(Automaton a) {
        this.a = a;

    }

    public void start(Instance i, int index) {

        System.out.println("assignmentOne.Instance " + i.getId() + " Is standing in " + i.getWhereWeAt().getName());
        System.out.println();

        if (i.getAction().size() == index) {
            System.out.println("assignmentOne.Instance " + i.getId() + " Is at its final destination.. ");
            System.out.println();

            if (i.getWhereWeAt().isFinalState()) {
                System.out.println("We reached a final state! for instance " + i.getId());
                System.out.println();
            } else {
                System.out.println("We did NOT reach a final state for instance " + i.getId());
                System.out.println();
            }
            return;
        }


        String go = i.getAction().get(index);


        State newState = i.getWhereWeAt().attemptToEnterNewState(go);

        if (newState != null) {
            i.getWhereWeAt().instancesInThisState.remove(i);
            i.setWhereWeAt(newState);
            i.getWhereWeAt().instancesInThisState.add(i);
            start(i, index + 1);
        } else {
            System.out.println("assignmentOne.Instance" + i.getId() + " is stuck.. Next state is not valid, going to sleep for a while here..");
            System.out.println();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i.getId() + " is trying again ...");
            start(i, index);
        }

    }

    public Automaton getA() {
        return a;
    }

    public void findAllInstancesInStates(State current) {
        if(current.eligibleStates != null){
        for (State x : current.eligibleStates) {
            findAllInstancesInStates(x);
        }
        }
        for (Instance i : current.instancesInThisState) {
            System.out.println("-------------------------------------------");
            System.out.println("assignmentOne.Instance " + i.getId() + " Is currently in this state: " + current.getName());
            System.out.println("Is this state a final one? " + current.isFinalState());
            System.out.println("-------------------------------------------");
            return;
        }


    }

    public static void main(String[] args) {
        AutomatonRunner a = new AutomatonRunner(new Automaton());
        Instance i = new Instance(new ArrayList<>(Arrays.asList("login", "gg")), a.getA().getInitState());
        Instance i1 = new Instance(new ArrayList<>(Arrays.asList("login", "database", "trampoline")), a.getA().getInitState());

        (new Thread(() -> a.start(i, 0))).start();
        (new Thread(() -> a.start(i1, 0))).start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("We starting to look");
        a.findAllInstancesInStates(a.getA().getInitState());


    }


}
