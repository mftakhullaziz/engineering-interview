package backend_interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberTest {

    public String PrimeTest(int n){
        List<Integer> res = new ArrayList<>();

        if ( n <= 1) res.add(0);
        int tmp;

        for (int i = 1; i <= 1000; i++){
            int counter=0;
            for(tmp =i; tmp>=1; tmp--) {
                if(i%tmp==0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                res.add(i);
            }
        }

//        Get Prime range in List
        List<Integer> temp_result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            temp_result.add(res.get(i));
        }
        String result = temp_result.toString();
        return result.replace("[","").replace("]","");
    }

    @Test
    public void testPrime1(){
        System.out.println("Test ==> PrimeTest(2) : " + PrimeTest(2));
        System.out.println("Test ==> PrimeTest(4) : " +PrimeTest(4));

//        Using Assertions
        String actual = "2, 3";
        String actual1 = "2, 3, 5, 7";
        Assertions.assertAll(
                () -> Assertions.assertEquals(PrimeTest(2),actual),
                () -> Assertions.assertEquals(PrimeTest(4),actual1)
        );
    }
}
