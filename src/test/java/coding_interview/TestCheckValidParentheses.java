package coding_interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class TestCheckValidParentheses {
    public boolean isValidParentheses(String chars){
        // check length for string brackets
        if (chars.length() < 1) return false;

        // init stack from data structure
        Stack<Character> characterStack = new Stack<>();
        int i = 0;
        // looping char with length value
        while (i < chars.length()) {
            // create var temp for assign charAt i
            char temp = chars.charAt(i);

            // check condition if temp start bracket
            if (temp == '(' || temp == '{' || temp == '[') {
                characterStack.push(temp);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                }
                char temp1 = characterStack.pop();
                if (temp == ')' && temp1 != '(') {
                    return false;
                }
                if (temp == '}' && temp1 != '{') {
                    return false;
                }
                if (temp == ']' && temp1 != '[') {
                    return false;
                }
            }

            i++;
        }
        return characterStack.empty();
    }

    // test function
    @Test
    public void testIsValidParentheses() {
        System.out.println(isValidParentheses("[]{}()"));

        Assertions.assertAll(
                () -> Assertions.assertTrue(isValidParentheses("([{([])}]{()})"))
        );
    }
}
