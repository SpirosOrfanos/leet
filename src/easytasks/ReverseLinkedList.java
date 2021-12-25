package easytasks;

import wgeneric.ListNode;

public class ReverseLinkedList {

    public static void main(String... args) {
        ListNode a1 = new ListNode();
        ListNode a2 = new ListNode();
        ListNode a3 = new ListNode();
        ListNode a4 = new ListNode();
        a1.val = 1;
        a2.val = 2;
        a3.val = 3;
        a4.val = 4;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ReverseLinkedList app = new ReverseLinkedList();

        ListNode a = app.reverse(a1);
    System.out.println();
    }
    public ListNode reverse(ListNode head) {

        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        while (current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
