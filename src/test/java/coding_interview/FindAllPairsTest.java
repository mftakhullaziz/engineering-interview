package coding_interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class FindAllPairsTest {

//    Sum is Target
//    Arr is random Int
    public int FindPairTest(int[] arr, int sum) {
        HashSet<Integer> s = new HashSet<>();
        int count = 0;
        for (int j : arr) {
            int temp = sum - j;
            if (s.contains(temp)) {
                System.out.println("Pair " + sum + " is (" + j + "," + temp + ")");
                if (j + temp == sum)
                    count++;
            }

            s.add(j);
        }
        System.out.println("Total Pair Number : " + count);
        return count;
    }

//    Run Test Unit for Test Function
    @Test
    public void testFindPairTest() {
        int[] Arr1 = { 1, 4, 45, 6, 10, 8, 15 };
        int[] Arr2 = { -1, 14, 2, 6, 3, 8, -6, -5, 6, -2 };
        int nSum1 = 16;
        int nSum2 = 1;
        System.out.println(FindPairTest(Arr1, nSum1));
        System.out.println(FindPairTest(Arr2, nSum2));

//        Using Assertions
        Assertions.assertAll(
                () -> Assertions.assertEquals(FindPairTest(Arr1,nSum1), 2),
                () -> Assertions.assertEquals(FindPairTest(Arr2,nSum2), 4)
        );
    }
}
