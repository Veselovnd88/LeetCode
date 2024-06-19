package problems;

import util.ListNode;

/**
 * @author VeselovND <br>
 * created at 19.06.2024 <br>
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/description/">Middle of the Linked List</a>
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        //два указателя, один прыгает на одну позицию, другой на две, если второй указатель доберется до конца,
        // значит первый находится на половине

        if (head == null || head.next == null) return head;

        var fast = head;
        var slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
