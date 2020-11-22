public class Rationals {

    private String[] sequence;

    public Rationals(int size) {
        sequence = new String[size];

        for (int i = 0; i < size; i++) {
            sequence[i] = calcNumber(i);
        }

    }

    private String calcNumber(long n){

        int ln = (int) ((-1 + (Math.sqrt(1+8*n)))/2);

        int sn = (ln*(ln+1))/2;

        int numerator = (int) ((n - sn ) + 1);
        int denominator = (int) (ln - ( n - sn ) + 1);

        return numerator+"/"+denominator;
    }


    public String rational(long n){

        return calcNumber(n);
    }

    public String[] getSequence() {
        return sequence;
    }

    public void print(){
        for (int i = 0; i < sequence.length; i++) {
            System.out.println(sequence[i]);

        }
    }

    public static void main(String[] args) {
        Rationals r = new Rationals(200);

        //This pair should equal
        //Found in the array
        System.out.println(r.getSequence()[100]);
        //Calculated value
        System.out.println(r.rational(100));


        //This pair should equal
        //Found in the array
        System.out.println(r.getSequence()[21]);
        //Calculated value
        System.out.println(r.rational(21));


    }

}
