package interview_code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;

public class FibonacciCase {


    public int FibonacciFindNumber(int n){
        int temp;
        int n0 = 0;
        int n1 = 1;
        if (n == 0 || n == 1) {
            return n;
        } else {
            for (int i = 2; i <= n ; i++) {
                temp = n0 + n1;
                n0 = n1;
                n1 = temp;
            }
            return n1;
        }
    }

    @Test
    void testFibonacciCase(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(FibonacciFindNumber(11), 89),
                () -> Assertions.assertEquals(FibonacciFindNumber(5), 5)
        );
    }

    public List<Integer> FibonacciCaseList(int n){
        int temp, n0 = 0, n1 = 1;
        List<Integer> result = new ArrayList<>();
        if (n == 0 || n == 1) {
            result.add(n);
        } else {
            result.add(n0);
            result.add(n1);
            for (int i = 2; i <= n ; i++) {
                temp = n0 + n1;
                n0 = n1;
                n1 = temp;
                result.add(n1);
            }
        }
        return result;
    }

    @Test
    void TestList(){
        System.out.println(FibonacciCaseList(4));
    }

    @Test
    void testFibonacciCaseList(){
        List<Integer> actual = Arrays.asList(0,1,1,2,3,5,8,13);
        List<Integer> actual_fib_8 = Arrays.asList(0,1,1,2,3,5,8,13,21);
        Assertions.assertArrayEquals(new List[]{FibonacciCaseList(7)}, new List[]{actual});
        Assertions.assertEquals(FibonacciCaseList(7), actual);
        Assertions.assertEquals(FibonacciCaseList(8), actual_fib_8);
    }

    // recursive fibonacci
    public int FibonacciCaseRecursive(int n){
        if (n == 0 || n <= 1){
            return n;
        }
        return FibonacciCaseRecursive(n-1) + FibonacciCaseRecursive(n-2);
    }

    @Test
    void testFibonacciCaseRecursive(){
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765);
        for (int i = 0; i <= 20; i++) {
            expected.add(FibonacciCaseRecursive(i));
        }
        Assertions.assertEquals(expected, actual);
    }


    // Dinamyc Fibonacci
    public BigInteger fibDynamic(int n){
        BigInteger fibonacci[] = new BigInteger[n+2];
        fibonacci[0] = BigInteger.valueOf(0);
        fibonacci[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i-1].add(fibonacci[i-2]);
        }
        return fibonacci[n];
    }


    // Dinamyc
    public BigInteger fib(int n){
        // 1 extra to handle case, n = 0
        BigInteger f[] = new BigInteger[n + 2];
        int i;
        f[0] = BigInteger.valueOf(0);
        f[1] = BigInteger.valueOf(1);
        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1].add(f[i - 2]);
        }
        return f[n];
    }

    public BigInteger FibonacciCaseRecursiveS(int n){
        if (n == 0 || n <= 1){
            return BigInteger.valueOf(n);
        }
        return FibonacciCaseRecursiveS(n-1).add(FibonacciCaseRecursiveS(n-2));
    }

    @Test
    void test(){
        List<BigInteger> actual = new ArrayList<>();
        List<Integer> arrays = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765);
        for (int s : arrays) actual.add(BigInteger.valueOf(s));

        List<BigInteger> expected = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            expected.add(fibDynamic(i));
        }
        Assertions.assertEquals(expected, actual);
    }

    public BigInteger FibonacciFindNumbers(int n){
        BigInteger temp;
        BigInteger n0 = BigInteger.valueOf(0);
        BigInteger n1 = BigInteger.valueOf(1);
        if (n == 0 || n == 1) {
            return BigInteger.valueOf(n);
        } else {
            for (int i = 2; i <= n ; i++) {
                temp = n0.add(n1);
                n0 = n1;
                n1 = temp;
            }
            return n1;
        }
    }

    @Test
    void testFindFibonacci(){

        long startTime = System.nanoTime();
        System.out.println(fibDynamic(100));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

        long startTime1 = System.nanoTime();
        System.out.println(FibonacciFindNumbers(100));
        long endTime1   = System.nanoTime();
        long totalTime1 = endTime1 - startTime1;
        System.out.println(totalTime1);


    }



}
