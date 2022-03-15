package coding_interview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCountPrime {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimesV1(int n){
        List<Integer> res = new ArrayList<>();
        if ( n < 2) return 0;
        int tmp;
        for (int i = 2; i <= n; i++){
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
        System.out.println("Total prime number : " + countPrimes(10));
        System.out.println("Total prime number : " + countPrimesV1(10));
    }
}
