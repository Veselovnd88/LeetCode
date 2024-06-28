package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author VeselovND <br>
 * created at 28.06.2024 <br>
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/description/">Evaluate Reverse Polish Notation</a>
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Long> stack = new ArrayDeque<>();
        String operations = "+-*/";
        for (String token : tokens) {
            if (operations.contains(token)) {
                Long right = stack.poll();
                Long left = stack.poll();
                Long result = -1L;
                if (token.equals("+")) {
                    result = left + right;
                }
                if (token.equals("-")) {
                    result = left - right;
                }
                if (token.equals("*")) {
                    result = left * right;
                }
                if (token.equals("/")) {
                    result = left / right;
                }
                stack.push(result);
            } else {
                stack.push(Long.valueOf(token));
            }
        }
        return Math.toIntExact(stack.poll());
    }

}
