import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Integer> tower = new ArrayList();
    private String name;

    public Tower( String name) {
        this.name = name;

    }

    public List<Integer> getTower() {
        return tower;
    }

    public void setTower(List<Integer> tower) {
        this.tower = tower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "name='" + name + '\'' +
                '}';
    }
}
