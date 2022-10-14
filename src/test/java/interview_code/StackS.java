package interview_code;

import java.util.List;
import java.util.Stack;

public class StackS {
    static void superStack(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            switch (s.split(" ")[0].toLowerCase()) {
                case "push":
                    if (s.split(" ")[1] != null) {
                        stack.push(Integer.parseInt(s.split(" ")[1]));
                        System.out.println(stack.peek());
                    }
                    break;
                case "pop":
                    stack.pop();
                    System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
                    break;
                case "inc":
                    if (s.split(" ")[1] != null && s.split(" ")[2] != null) {
                        Integer e = Integer.parseInt(s.split(" ")[1]);
                        Integer k = Integer.parseInt(s.split(" ")[2]);
//                        for (int inc = 0; inc < e; inc++) {
//                            stack.add(inc, stack.get(inc) + k);
//                            stack.remove(inc + 1);
//                        }
                        int inc = 0;
                        while (inc < e) {
                            stack.add(inc, stack.get(inc) + k);
                            stack.remove(inc + 1);
                            inc++;
                        }
                        System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
                    }
                    break;
            }
        }
    }

    public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
        // Write your code here
        int[] res = new int[saving+1];
        int N = currentValue.size();
        for (int i = 1; i <= N; i++){
            int weight = currentValue.get(i - 1), value = futureValue.get(i - 1) - currentValue.get(i - 1);
            for (int j = saving; j >= weight; j--){
                res[j] = Math.max(res[j], res[j-weight]+value);
            }
        }
        return res[saving];
    }
}
