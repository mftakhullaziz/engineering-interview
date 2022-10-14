package tokopedia_codingtest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
    public boolean primeNumberSolution(int n) {
        if (n <= 1) return false;
        int i = 2;
        while (i < n){
            if ((n % i) == 0) return false;
            i++;
        }
        return true;
    }

    @Test
    public void testPrimeNumber() {
        System.out.println(primeNumberSolution(13));
    }

    // find prime number from array and output index prime
    public int findPrimeNumber(int n){
        List<Integer> res = new ArrayList<>();
        if ( n <= 1) res.add(0);
        int tmp = 0;
        for (int i = 1; i <= n; i++){
            int counter=0;
            for(tmp =i; tmp>=1; tmp--) {
                if(i%tmp == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                res.add(i);
            }
        }

        System.out.println(res);

        int[] array_prime = res.stream().mapToInt(i->i).toArray();
        int hasil = BinarySearchSolution(array_prime,43);

        return hasil;
    }

    public int BinarySearchSolution(int[] array_n, int target){
        int left = 0;
        int right = array_n.length-1;
        Arrays.sort(array_n);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array_n[mid] == target) {
                return mid;
            } else if (array_n[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int listPrimeNumber(int n){
        List<Integer> res = new ArrayList<>();
        if ( n <= 1) return 0;
        int tmp = 0;
        for (int i = 1; i <= n; i++){
            int counter=0;
            for(tmp =i; tmp>=1; tmp--) {
                if(i%tmp == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                res.add(i);
            }
        }
        int[] listPrime = new int[res.size()];
        int length = Arrays.stream(listPrime).toArray().length;
        return length;
    }

    @Test
    void test(){
//        System.out.println(findPrimeNumber(1));
        System.out.println(listPrimeNumber(3));
    }

}
