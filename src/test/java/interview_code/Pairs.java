package interview_code;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;

public class Pairs {
    public ArrayList<Integer> pairsArrays(int[] arrlist) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> notPairs = new ArrayList<>();
        // Check if pairs element
        for(int element: arrlist) {
            if (!hashSet.add(element)) {
                arrayList.add(element);
            }
        }
        // Check if there are no pairs of elements
        for (int i: hashSet) {
            if (!arrayList.contains(i)){
                notPairs.add(i);
            }
        }
        return notPairs;
    }

    @Test
    public void testPairs(){
        System.out.println("Not Pairs in Arrays : " + pairsArrays(new int[] {1,1,3,4,5,6,3,4,6,7,8}));
    }
}
