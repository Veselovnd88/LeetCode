package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author VeselovND <br>
 * created at 04.07.2024 <br>
 * <a href="https://leetcode.com/problems/min-stack/description/">Min Stack</a>
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

    private final Deque<Integer> stack = new ArrayDeque<>();

    private final Deque<Integer> minTrack = new ArrayDeque<>();

    public MinStack() {
        minTrack.push(Integer.MAX_VALUE);//инициализация чтобы было с чем сравнивать
    }

    //одновременно добавляем и трекаем минимальный элемент
    public void push(int val) {
        stack.push(val);
        minTrack.push(Math.min(val, minTrack.peek()));
    }

    public void pop() {
        stack.pop();
        minTrack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minTrack.peek();
    }
}
