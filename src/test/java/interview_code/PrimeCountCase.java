package interview_code;

import org.junit.jupiter.api.Test;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeCountCase {

    // O(N"3)
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        // O(n"2)
        for (int i = 2; i * i < n; i++) {
            if (!isPrime(i)) continue;
            for (int p = i * i; p < n; p += i) {
                isPrime[p] = false;
            }
        }
        // O(n)
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        int f;
        for (f = 2; f*f <= num; f++)
            if (num % f == 0) return false;
        return true;
    }

     /*
     iterasi 1
     =>> f = 2; 4 <= 6; f++ -> 2+1
            6 % 2 == 0 // false

     iterasi 2
     =>> f = 3; 9 <= 7; f++ -> 3+1
            karena kondisi loop tidak terpenuhi maka bilangan tersebut pasti prima

     return true
     */




    @Test
    void test() {
//        System.out.println(countPrimes(0));
//        System.out.println(countPrimes(10));
        System.out.println(isPrime(0));
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(5));
    }
}
