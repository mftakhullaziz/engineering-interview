package interview_code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumCase {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                System.out.println(numMap.get(complement) + ":" + i);
                return new int[] { numMap.get(complement).intValue(), i};
            } else {
                numMap.put(nums[i], i);
            }
            i++;
        }
        return new int[] {};
    }

    @Test
    void tests() {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
//        Integer[] array = {3,2,4};
//        ArrayList<int[]> actual = new ArrayList<>();
//        actual.add(new int[] {Arrays.asList(array).indexOf(2), Arrays.asList(array).indexOf(4)});
//        System.out.println(actual);
//        ArrayList<int[]> expected = new ArrayList<>();
//        expected.add(twoSum(new int[] {3,2,4}, 6));
//        System.out.println(expected);
    }
}
