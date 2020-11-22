public class TowerOfHanoi {

    Tower towerA = new Tower("A");
    Tower towerB = new Tower("B");
    Tower towerC = new Tower("C");

    public TowerOfHanoi(int sizeOfTowers) {

        for (int i = sizeOfTowers; i > 0; i--) {
            towerA.getTower().add(i);
        }
        System.out.println(towerA);
    }


    public void move(int n, Tower from, Tower spare, Tower to) {

        if (n == 1) {
            swapTower(to, from, n);
            return;
        }


        move(n - 1, from, to, spare);

        swapTower(to, from, n);

        move(n - 1, spare, from, to);


    }

    public void swapTower(Tower addTower, Tower fromTower, int n) {
        addTower.getTower().add(fromTower.getTower().get(fromTower.getTower().size() - 1));

        fromTower.getTower().remove(fromTower.getTower().get(fromTower.getTower().size() - 1));

        System.out.println("Swapping disk " + n + " from " + fromTower + " To " + addTower);

    }


    public void towersOfHanoi() {

        move(towerA.getTower().size(), towerA, towerB, towerC);

        System.out.println("Tower X: " + towerA.toString() + " Tower Y: " + towerB.toString() + " Tower Z: " + towerC.toString());
    }

    public static void main(String[] args) {

        TowerOfHanoi toh = new TowerOfHanoi(3);
        toh.towersOfHanoi();

    }


}
