package tokopedia_codingtest;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String n){
        if (n.length() < 1) return false;

        Stack<Character> stack_Chars = new Stack<>();

        int i = 0;

        while (i < n.length()) {
            char temp = n.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[') {
                stack_Chars.push(temp);
            } else {
                if (stack_Chars.isEmpty()) {
                    return false;
                }
                char tp = stack_Chars.pop();
                if(temp == ')' && tp !='(')
                    return false;
                if(temp == '}' && tp !='{')
                    return false;
                if(temp == ']' && tp != '[')
                    return false;
            }
            i++;
        }

        return stack_Chars.empty();
    }

    @Test
    public void testValidStack(){
        System.out.println(isValid("[](){}"));
        System.out.println(isValid("[]"));
    }
}
