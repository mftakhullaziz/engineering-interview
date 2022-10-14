package interview_code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialCase {
    /**
     * Factorial konsep 5! = 5*4*3*2*1
     */

    // Kompleksitas Linier O(N)
    public int FactorialCase(int value){
        int temp = 1;
        for (int i = value; i >=1 ; i--) {
            temp *= i;
        }
        return temp;
    }

    @Test
    void testFactorialCase(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(FactorialCase(5),120)
        );
    }

    // if without temporary variable
    public int FactorialCase2(int value, int total){
        for (int i = value; i >=1 ; i--) {
            total *= i;
        }
        return total;
    }

    @Test
    void testFactorialCase2(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(FactorialCase2(5, 1),120)
        );
    }

    // if not looping
    public int FactorialRecursive(int n){
        if (n <= 1){
            return 1;
        }
        return n * FactorialCase(n-1);
    }

    @Test
    void testFactorialCase3(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(FactorialRecursive(5),120)
        );
    }

    // if tail recursive
    public int FactorialTailRecursive(int total, int n){
        if (n <= 1) return total;
        return FactorialTailRecursive(total * n, n-1);
    }

    @Test
    void testFactorialCase4(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(FactorialTailRecursive(1, 5),120)
        );
    }


}
