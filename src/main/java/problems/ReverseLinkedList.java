package problems;

import util.ListNode;

/**
 * @author VeselovND <br>
 * created at 17.06.2024 <br>
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">Reverse Linked List</a>
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
        System.out.println(reverseRecursive(head));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        //пока не достигнем конца списка меняем ноды местами
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        //делаем хвост головой
        head = prev;
        return head;
    }

    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        //докручиваем до последнего элемента и меняем у последнего - next на предыдущий
        ListNode listNode = reverseRecursive(head.getNext());
        head.getNext().setNext(head); // поставили следующему элементу next - Текущий
        head.setNext(null); //а у текущего обнулили следующий, и возвращаем тот элем который next (lisNodee)
        return listNode;
    }
}
