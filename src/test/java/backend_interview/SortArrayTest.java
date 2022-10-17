package backend_interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayTest {

    // Sort with sort function from arrays => the time complexity O(n Log(n))
    public ArrayList<Integer> sortArray(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    // Sort with swap value time complexity O(N"2)
    public ArrayList<Integer> sortArraySwap(int[] arr) {
        int temp = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    //swap elements if not in order
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            res.add(arr[i]);
        }
        return res;
    }

    @Test
    public void testSortArray() {
        System.out.println("Sort with array sort : " + sortArray(new int[]{ 1,3,9,2,11,4,5 }));
        System.out.println("Sort with function swap sort : " + sortArraySwap(new int[]{ 1,3,9,2,11,4,5 }));

        // Run test with Assertions
        ArrayList<Integer> actual = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 9, 11));
        Assertions.assertAll(
                () -> Assertions.assertEquals(sortArray(new int[]{ 1,3,9,2,11,4,5 }), actual),
                () -> Assertions.assertEquals(sortArraySwap(new int[]{ 1,3,9,2,11,4,5 }), actual)
        );

    }
}
