import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<Long> timer = new ArrayList();
        File f = new File("/Users/Jesper/Documents/test.txt");


        for (int i = 0; i < 20; i++) {

            final long startTime = System.currentTimeMillis();

            Map<Character, Integer> freq = new HashMap<>();
            readFile(freq, f);
            final long endTime = System.currentTimeMillis();

            final long done = endTime - startTime;
            timer.add(done);
//            System.out.println("Total execution time: " + (endTime - startTime));
        }

        Collections.sort(timer);

        for (Long e : timer) {
            System.out.println(e);
        }

    }

    public static void readFile(Map<Character, Integer> freq, File f) throws IOException {
        FileReader fr = new FileReader(f);   //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;
        while ((c = br.read()) != -1)         //Read char by Char
        {
            char character = (char) c;          //converting integer to char
//            System.out.println(character);        //Display the Character

            if (freq.containsKey(character)) {
                freq.put(character, freq.get(character) + 1);
            } else {
                freq.put(character, 1);
            }


        }

    }
}

