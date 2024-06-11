package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author VeselovND <br>
 * created at 11.06.2024 <br>
 * <a href="https://leetcode.com/problems/implement-queue-using-stacks/description/">Implement Queue using Stacks</a>
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

    public static class MyQueue {

        Deque<Integer> read = new ArrayDeque<>();
        Deque<Integer> write = new ArrayDeque<>();

        public MyQueue() {

        }

        public void push(int x) {
            write.push(x);
        }

        public int pop() {
            while (!write.isEmpty()) {
                read.push(write.pop());
            }
            int result = read.pop();
            while (!read.isEmpty()) {
                write.push(read.pop());
            }
            return result;
        }

        public int peek() {
            while (!write.isEmpty()) {
                read.push(write.pop());
            }
            int result = read.peek();
            while (!read.isEmpty()) {
                write.push(read.pop());
            }
            return result;
        }

        public boolean empty() {
            return write.isEmpty();
        }
    }

    public static class MyQueueOptimized {

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> helper = new ArrayDeque<>();

        int first;

        public MyQueueOptimized() {

        }

        public void push(int x) {
            //если стек пустой то присвоили в переменную (первый элем) значение
            if (stack.isEmpty()) {
                first = x;
            }
            //перегнали общий стек в хелпер
            while (!stack.isEmpty()) {
                helper.push(stack.pop());
            }
            //добавили свежее значение, и перегоняем обратно в общий стек, чтобы новое значение было в хвосте
            helper.push(x);

            while (!helper.isEmpty()) {
                stack.push(helper.pop());
            }
        }

        public int pop() {
            int res = stack.pop();
            if (!stack.isEmpty())
                first = stack.peek();
            return res;
        }

        public int peek() {
            return first;
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

}
