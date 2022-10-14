package interview_code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubStringCase {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        HashSet<Character> hash_char = new HashSet<>();
        while (right < s.length()) {
            if (!hash_char.contains(s.charAt(right))) {
                hash_char.add(s.charAt(right));
                right++;
                max = Math.max(hash_char.size(), max);
            } else {
                hash_char.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

    public int subStringSolution(String s) {

        int left = 0 , right = 0;
        Set<Character> seen = new HashSet();
        int max = 0;

        while(right<s.length()){
            char c = s.charAt(right); //a
            if(seen.add(c)){
                max = Math.max(max,right-left+1);
                right++;
            }else{
                while(s.charAt(left)!=c){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);left++;
            }
        }
        System.out.println(seen);
        return max;
    }

    public int SubStringSolutions(String word){
        int pointer_a = 0;
        int pointer_b = 0;
        int max = 0; // =>> sliding window with max = pointer_a - pointer_b + 1
        Set<Character> setChars = new HashSet<>();
        while (pointer_a < word.length()){
            char c = word.charAt(pointer_a);
            while (setChars.contains(c)){
                setChars.remove(word.charAt(pointer_b));
                pointer_b++;
            }
            setChars.add(c);
            max = Math.max(max, pointer_a-pointer_b+1);
            pointer_a++;
        }
        return max;
    }

    @Test
    void test() {
        System.out.println(SubStringSolutions("pswwkew"));
    }

    @Test
    void testString() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(1, lengthOfLongestSubstring("bbbbbbb"));
        Assertions.assertEquals(0, lengthOfLongestSubstring(""));
    }
}
