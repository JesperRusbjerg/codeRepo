public class Summations {

    private static int n = 3;
    private static int k = 1;

    //Are these two equal?

    //Slide 9
    public static void topOne(){
        int res = 0;
        for (int i = k; i < n; i++) {

            int liftUpInto = n+1;
            int leftSide = 2^i;
//            System.out.println(leftSide);
            int rightSide = 2^liftUpInto;
            System.out.println(liftUpInto);
            res += leftSide + rightSide;

            System.out.println("Res: " + res + " At " + i);
        }
        System.out.println("Top one: " );
        System.out.println(res);
        System.out.println();
    }

    //Slide 9
    public static void bottomOne(){
        int res = 0;
        for (int i = k; i < n+1; i++) {
            res += (2^i);
        }
        System.out.println("bottom one: " );
        System.out.println(res);
        System.out.println();
    }

    public static void main(String[] args) {

//        topOne();
//        bottomOne();

        System.out.println(Math.pow(2, 4));

    }

}


