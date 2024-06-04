package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author VeselovND
 * created at 04.06.2024
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                if (stack.peek() != null && stack.peek() == '(') {
                    stack.pop();
                } else return false;
            }
            if (s.charAt(i) == ']') {
                if (stack.peek() != null && stack.peek() == '[') {
                    stack.pop();
                } else return false;
            }
            if (s.charAt(i) == '}') {
                if (stack.peek() != null && stack.peek() == '{') {
                    stack.pop();
                } else return false;
            }

        }
        return stack.isEmpty();
    }
}
