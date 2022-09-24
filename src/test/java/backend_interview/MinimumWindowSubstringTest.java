package backend_interview;

import org.junit.jupiter.api.Test;

public class MinimumWindowSubstringTest {

    public String MinimumWindowSubstringSolution(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();

        // initialize needToFind array
        int[] needToFind = new int[256];
        for(int i = 0; i < tLen; i++) {
            needToFind[T.charAt(i)]++;
        }

        int[] hasFound = new int[256];
        int minWinLen = Integer.MAX_VALUE;
        int minWinBegin = 0;
        int minWinEnd = 0;
        int count = 0;
        for(int begin = 0, end = 0; end < sLen; end++) {
            // skip characters not in T
            if(needToFind[S.charAt(end)] == 0)
                continue;
            hasFound[S.charAt(end)]++;
            if(hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
                count++;
            // if window constraint is satisfied
            if(count == tLen) {
                // advance begin index as far as possible, stop when advancing breaks window constraint.
                while(needToFind[S.charAt(begin)] == 0 || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
                    if(hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
                        hasFound[S.charAt(begin)]--;
                    begin++;
                }
                // update minWindow if a minimum length is satisfied
                int windowLen = end - begin + 1;
                if(windowLen < minWinLen) {
                    minWinBegin = begin;
                    minWinEnd = end;
                    minWinLen = windowLen;
                }
            }
        }
        return (count == tLen) ? S.substring(minWinBegin, minWinEnd + 1)	: "";
    }

    @Test
    public void MinimumWindowSubstringTesting() {
        System.out.println(MinimumWindowSubstringSolution("ADOBECODEBANC", "ABC"));
    }
}


