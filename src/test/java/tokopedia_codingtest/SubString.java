package tokopedia_codingtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SubString {
    public int subStringSolution(String n) {
        int pointer_a = 0;
        int pointer_b = 0;
        int max = 0;

        Set<Character> object_Chars = new HashSet<>();

        while (pointer_b < n.length()) {
            char value = n.charAt(pointer_b);
            while (object_Chars.contains(value)) {
                object_Chars.remove(n.charAt(pointer_a));
                pointer_a++;
            }
            object_Chars.add(value);
            max = Math.max(max, pointer_b-pointer_a+1);
            pointer_b++;
        }
        return max;
    }

    @Test
    public void testSubString(){
        Assertions.assertEquals(3, subStringSolution("abcacbbb"));
    }
}
