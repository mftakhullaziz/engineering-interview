package backend_interview;

/*	NOTE : Class Name should be Main */
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

/* uncomment this if you want to read input.
//imports for BufferedReader

*/
import java.io.BufferedReader;
        import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.nio.charset.StandardCharsets;
import java.util.*;

class PK {
    public static void main(String args[] ) throws Exception {

		/* Sample code to perform I/O
         * Use either of these methods for input

		//BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
        String name = br.readLine();   // Reading input from STDIN
        System.out.println(name);    // Writing output to STDOUT

		//Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();   // Reading input from STDIN
        System.out.println(name);    // Writing output to STDOUT
        */

        //Write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        int nCountries = Integer.parseInt(br.readLine());
        int minTravelCost = 0;
        int temp = -1;
        for (int i=0; i<nCountries; i++) {
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            System.out.println(br2);
            String[] costTravel = br2.readLine().split(" ");
            System.out.println(Arrays.stream(costTravel).findAny());

            int localMinimum = 500;
            for(int j=0; j<3; j++) {
                System.out.println(Arrays.toString(costTravel[j].toCharArray()));
                if (Integer.parseInt(costTravel[j]) <= localMinimum)
                    if (j != temp) {
                        localMinimum = Integer.parseInt(costTravel[j]);
                        temp = j;
                    }
            }
            minTravelCost = minTravelCost+localMinimum;
        }
        System.out.println(minTravelCost);
    }

}
