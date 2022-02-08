package y2022.mid;

import helper.ListNode;
//https://leetcode.com/problems/linked-list-cycle-ii/
public class Detectcycle {
    public static void main(String[] args) {
        Detectcycle app = new Detectcycle();
       // ListNode a00 = new ListNode(-1);
      //  ListNode a0 = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
       // a00.next = a0;
      //  a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
       // a5.next = a2;
       // detectCycle(a00);
        swapNodes1(a1, 2);

    }

    public static ListNode swapNodes1(ListNode head, int k) {

        ListNode start = head;
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i<k-1; i++) {
            start = start.next;
        }

        for (int i = 0; i<k; i++) {
            fast = fast.next;
        }

        while (fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }

        int temp = start.value;
        start.value = slow.value;
        slow.value = temp;

/*        ListNode f = head;
        for (int i = 0; i< k-1; i++) {
            f = f.next;
        }*/

        return head;

    }

    public static ListNode swapNodes(ListNode head, int k) {

        ListNode start = new ListNode(-1);
        start.next = head;
        start = start.next;

        ListNode slow =  new ListNode(-1);
        slow.next = head;
        slow = slow.next;
        ListNode fast =  new ListNode(-1);
        fast.next = head;
        fast = fast.next;

        for (int i = 0; i<k-1; i++) {
            start = start.next;
        }

        for (int i = 0; i<k; i++) {
            fast = fast.next;
        }

        while (fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }

        int temp = start.value;
        start.value = slow.value;
        slow.value = temp;

        ListNode f = head;
        for (int i = 0; i< k-1; i++) {
            f = f.next;
        }

        return head;

    }
    //https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

    private static ListNode detectCycle(ListNode head) {
        if (head.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while(fast!=slow) {
            if (fast==null || fast.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = head;

        while (slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
