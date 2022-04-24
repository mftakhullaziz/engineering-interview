package coding_interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class TestSubStringProblem {
    public int SubStringProblem(String n) {
        int pointer_a = 0;
        int pointer_b = 0;
        int max = 0;

        Set<Character> characterSet = new HashSet<>();
        while (pointer_b<n.length()) {
            char temp = n.charAt(pointer_b);
            while (characterSet.contains(temp)) {
                characterSet.remove(n.charAt(pointer_a));
                pointer_a++;
            }
            characterSet.add(temp);
            max = Math.max(max, pointer_b-pointer_a+1);
            pointer_b++;
        }
        return max;
    }

    @Test
    public void testSubString() {
        Assertions.assertEquals(3, SubStringProblem("abcacbbb"));
    }
}
