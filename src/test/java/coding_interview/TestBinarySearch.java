package coding_interview;

import java.util.Arrays;

public class TestBinarySearch {
    public int BinarySearch(int[] array_n, int target) {
        // init left and right
        int left = 0;
        int right = array_n.length-1;

        // sort array
        Arrays.sort(array_n);

        // check while left <= right
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
}
