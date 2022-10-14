package interview_code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeCase {

    public boolean PrimaCase1(int inputNumber) {
        if (inputNumber <= 1) {
            return false;
        } else {
            for (int i = 2; i <= inputNumber/2; i++) {
                if ((inputNumber % i) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void unitTest(){
        Assertions.assertTrue(PrimaCase1(97));
    }

    public boolean PrimaCase2(int n){
        if ( n < 2) {
            return false;
        } else {
            for (int i = 2; i <= n/2; i++){
                // System.out.println(n +" % "+ i);
                // example :
                // 10 % 2 = 0 return false => not prima
                // 11 % 2 != 0 return true => prima
                if (n % i == 0)
                    return false;

            }
        }
        return true;
    }

    public boolean PrimaCaseRekursif(int n, int i){
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n) {
            return true;
        }
        return PrimaCaseRekursif(n, i + 1);
    }

    public boolean PrimaCase3(int n){
        if ( n <= 1) return false;
        int tmp = 0;
        for (int i = 1; i <= n;  i++){
            if (n % i == 0)
                tmp++;
        }
        if (tmp != 2){
            return false;
        } else {
            return true;
        }
    }

    public List<Integer> PrimaCaseList(int n){
        List<Integer> res = new ArrayList<>();
        if ( n <= 1) res.add(0);
        int tmp = 0;
        for (int i = 1; i <= n; i++){
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
        return res;
    }

    @Test
    void testPrimaCase1(){
        Assertions.assertAll(
                () -> Assertions.assertTrue(PrimaCase1(2)),
                () -> Assertions.assertTrue(PrimaCase1(3)),
                () -> Assertions.assertTrue(PrimaCase1(5)),
                () -> Assertions.assertTrue(PrimaCase1(7)),
                () -> Assertions.assertTrue(PrimaCase1(11)),
                () -> Assertions.assertTrue(PrimaCase1(13))
        );

        Assertions.assertAll(
                () -> Assertions.assertFalse(PrimaCase1(1)),
                () -> Assertions.assertFalse(PrimaCase1(4)),
                () -> Assertions.assertFalse(PrimaCase1(6)),
                () -> Assertions.assertFalse(PrimaCase1(8)),
                () -> Assertions.assertFalse(PrimaCase1(10)),
                () -> Assertions.assertFalse(PrimaCase1(12))
        );
    }

    @Test
    void testPrimaCase2(){
        Assertions.assertAll(
                () -> Assertions.assertTrue(PrimaCase2(2)),
                () -> Assertions.assertTrue(PrimaCase2(3)),
                () -> Assertions.assertTrue(PrimaCase2(5)),
                () -> Assertions.assertTrue(PrimaCase2(7)),
                () -> Assertions.assertTrue(PrimaCase2(11)),
                () -> Assertions.assertTrue(PrimaCase2(13))
        );

        Assertions.assertAll(
                () -> Assertions.assertFalse(PrimaCase2(1)),
                () -> Assertions.assertFalse(PrimaCase2(4)),
                () -> Assertions.assertFalse(PrimaCase2(6)),
                () -> Assertions.assertFalse(PrimaCase2(8)),
                () -> Assertions.assertFalse(PrimaCase2(10)),
                () -> Assertions.assertFalse(PrimaCase2(12))
        );
    }

    @Test
    void testPrimaCaseRekursif(){
        Assertions.assertAll(
                () -> Assertions.assertTrue(PrimaCaseRekursif(2,2)),
                () -> Assertions.assertTrue(PrimaCaseRekursif(3, 2)),
                () -> Assertions.assertTrue(PrimaCaseRekursif(5, 2)),
                () -> Assertions.assertTrue(PrimaCaseRekursif(7, 2)),
                () -> Assertions.assertTrue(PrimaCaseRekursif(11, 2)),
                () -> Assertions.assertTrue(PrimaCaseRekursif(13, 2))
        );

        Assertions.assertAll(
                () -> Assertions.assertFalse(PrimaCaseRekursif(1, 2)),
                () -> Assertions.assertFalse(PrimaCaseRekursif(4, 2)),
                () -> Assertions.assertFalse(PrimaCaseRekursif(6, 2)),
                () -> Assertions.assertFalse(PrimaCaseRekursif(8, 2)),
                () -> Assertions.assertFalse(PrimaCaseRekursif(10, 2)),
                () -> Assertions.assertFalse(PrimaCaseRekursif(12,2))
        );
    }

    @Test
    void testPrimaCase3(){
        Assertions.assertAll(
                () -> Assertions.assertTrue(PrimaCase3(2)),
                () -> Assertions.assertTrue(PrimaCase3(3)),
                () -> Assertions.assertTrue(PrimaCase3(5)),
                () -> Assertions.assertTrue(PrimaCase3(7)),
                () -> Assertions.assertTrue(PrimaCase3(11)),
                () -> Assertions.assertTrue(PrimaCase3(13))
        );

        Assertions.assertAll(
                () -> Assertions.assertFalse(PrimaCase3(1)),
                () -> Assertions.assertFalse(PrimaCase3(4)),
                () -> Assertions.assertFalse(PrimaCase3(6)),
                () -> Assertions.assertFalse(PrimaCase3(8)),
                () -> Assertions.assertFalse(PrimaCase3(10)),
                () -> Assertions.assertFalse(PrimaCase3(12))
        );
    }

    @Test
    void testPrimaCaseList(){
        List<Integer> actual = Arrays.asList(2,3,5,7,11,13,17,19,23);
        Assertions.assertEquals(PrimaCaseList(25),actual);
        System.out.println(PrimaCaseList(4));
    }


}
