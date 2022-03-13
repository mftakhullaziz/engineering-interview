package coding_interview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrimeEvenOddTest {

        public static List<String> Solution(int n) {
            int tmp;
            List<String> s = new ArrayList<>();
            for (int i = 1; i<=n; i++){
                int counter = 0;
                for (tmp = i; tmp>= 1; tmp--){
                    if (i%tmp == 0) {
                        counter += 1;
                    }
                }
                if (counter == 2){
                    if (i%2 == 0){
                        s.add(i + " => Even Prime");
                    } else {
                        s.add(i + " => Odd Prime");
                    }
                } else {
                    if (i%2 == 0){
                        s.add(i + " => Even");
                    } else {
                        s.add(i + " => Odd");
                    }
                }
            }
            return s;
        }

        @Test
        public void tesPrimeEvenOdd(){
            int n = 100;
            for(String s : Solution(n)) {
                System.out.println(s);
            }
        }
}
