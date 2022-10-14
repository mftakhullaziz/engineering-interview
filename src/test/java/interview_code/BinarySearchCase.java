package interview_code;

import org.junit.jupiter.api.Test;

public class BinarySearchCase {

    // array = [0,9,8,4,2,5]
    // index = [0,1,2,3,4,5]

    public int search(int[] nums, int target) {
        int lower = 0; // start index
        int high = nums.length-1; // end index

        while (lower <= high) {
            // mencari nilai tengah berfungsi untuk membandingkan
            int mid = (lower + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lower = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        for (int i = lower; i <= high; i++) {
            int mid = (lower + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lower = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    @Test
    void testBinarySearch(){
        System.out.println(search(new int[] {-9,2,4,6,7,199}, 199));
    }

}
