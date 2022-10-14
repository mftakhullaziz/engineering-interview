package interview_code;

import java.util.Scanner;
import java.util.Stack;

public class SuperS1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        String[] splittedString;
        Stack<Integer> stack = new Stack<>();
        do {
            System.out.println("Enter the action : ");
            userInput = scanner.nextLine();
            splittedString = userInput.split(" ");
            switch (splittedString[0].toLowerCase()) {
                case "push":
                    if (splittedString[1] != null) {
                        stack.push(Integer.parseInt(splittedString[1]));
                        System.out.println(stack.peek());
                    }
                    break;
                case "pop":
                    stack.pop();
                    System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
                    break;
                case "inc":
                    if (splittedString[1] != null && splittedString[2] != null) {
                        Integer e = Integer.parseInt(splittedString[1]);
                        Integer k = Integer.parseInt(splittedString[2]);
                        for (int inc = 0; inc < e; inc++) {
                            stack.add(inc, stack.get(inc) + k);
                            stack.remove(inc + 1);
                        }
                        System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
                    }
                    break;
            }
        } while (!splittedString[0].equalsIgnoreCase("exit"));
        scanner.close();
    }
}
