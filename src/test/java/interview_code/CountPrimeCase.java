package interview_code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CountPrimeCase {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }

    public int countP(int n){
        List<Integer> res = new ArrayList<>();
        if ( n < 2) return 0;
        int tmp = 0;
        for (int i = 3; i <= n; i++){
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
        return res.size();
    }

    @Test
    void Test(){
        System.out.println(countPrimes(10));
        System.out.println(countP(10));
    }
}
