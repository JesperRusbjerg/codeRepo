import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummationsTheorm {


    //Proof for my theorm

    public static void main(String[] args) {

        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int i2;
        double d2;
        String x3;

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.


        i2 = scan.nextInt();
        d2 = scan.nextDouble();
        scan.nextLine();
        x3 = scan.nextLine();


        /* Print the sum of both integer variables on a new line. */

        System.out.println(i+i2);


        /* Print the sum of the double variables on a new line. */
        System.out.println(d+d2);

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */

        String concat = s+x3;

        System.out.println(concat);

        scan.close();

    }

    public static int pairs(int n, int[] ar){
        List<Integer> ints = new ArrayList<>();
        int res = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = ar[i];
            if(ints.contains(cur)){
                res += 1;
                ints.remove(Integer.valueOf(cur));
            }else{
                ints.add(cur);
            }

        }
        return res;
    }


}
