package problems;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author VeselovND <br>
 * created at 11.06.2024 <br>
 * <a href="https://leetcode.com/problems/linked-list-cycle/description/">Linked List Cycle</a>
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        //[3,2,0,-4]

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(-4, node5);
        ListNode node2 = new ListNode(2,
                new ListNode(0, node4));
        node5.setNext(node2);
        ListNode head1 = new ListNode(100, new ListNode(3100, new ListNode(3, node2)));

        System.out.println(isCycle(head1));
        System.out.println(isCycleOptimized(head1));
    }

    //сохраняем посещенные ноды в лист
    public static boolean isCycle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        List<ListNode> visited = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            if (visited.contains(curr)) {
                return true;
            }
            visited.add(curr);
            curr = curr.getNext();
        }
        return false;
    }

    //с O(1) по памяти, берем два указателя, медленный указатель идет поочередно (каждый раз берется следующая нода),
    // быстрый указатель скачет следующая +1, таким образом получается, что если есть цикл - то быстрая нода перестает меняться
    // и рано или поздно мы дойдем до slow указателя
    public static boolean isCycleOptimized(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.getNext();

        while (fast != null && fast.getNext() != null) {
            if (slow == fast) {
                return true;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return false;
    }
}
